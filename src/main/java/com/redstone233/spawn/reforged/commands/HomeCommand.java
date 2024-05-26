package com.redstone233.spawn.reforged.commands;

// import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

import net.minecraft.command.argument.DefaultPosArgument;
import net.minecraft.command.argument.PosArgument;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.LookTarget;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HomeCommand {
    
    private static final SimpleCommandExceptionType INVALID_POSITION_EXCEPTION = new SimpleCommandExceptionType(Text.translatable("commands.teleport.invalidPosition"));
    private static double x = 0;
    private static double y = 0;
    private static double z = 0;
    private static int b = 0;
    private static double[] home_pos;
    private static String[] names = {"a1","a2","a3"};


    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("home").requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal("set")
                .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                    .then(CommandManager.argument("name", StringArgumentType.string())
                        .executes(run -> setPosHome(run.getSource(), Vec3ArgumentType.getPosArgument(run, "pos"), run.getSource().getPlayer(), StringArgumentType.getString(run, "name")))
                    )
                )
            .then(CommandManager.literal("this")
                .then(CommandManager.argument("name", StringArgumentType.string())
                    .executes(run -> setThisHome(run.getSource(), run.getSource().getPlayer(), StringArgumentType.getString(run, "name"))
                  )
               )
            )
        )
        .requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal("tp")
               .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                  .executes(run -> tpHome(run.getSource(), Collections.singleton(((ServerCommandSource)run.getSource()).getEntityOrThrow()), run.getSource().getWorld(), Vec3ArgumentType.getPosArgument(run, "pos"), DefaultPosArgument.zero(), (LookTarget)null)
            )
        )
        .requires(src -> src.hasPermissionLevel(4))
            .then(CommandManager.literal("remove")
               .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                  .executes(run -> removePosHome(run.getSource(), Vec3ArgumentType.getPosArgument(run, "pos"), run.getSource().getPlayer())
               )
            )
            .then(CommandManager.argument("name", StringArgumentType.string())
               .executes(run -> removeNameHome(run.getSource(), StringArgumentType.getString(run, "name"), run.getSource().getPlayer())
               )
            )
         )
      );
    }

    private static int setThisHome(ServerCommandSource source, PlayerEntity player,String name) throws CommandSyntaxException {
      //Set<PositionFlag> pos = EnumSet.noneOf(PositionFlag.class);
      Vec3d vec3d = player.getPos();
        if(name == null) {
            for (int i = 0; i < home_pos.length; i++) {
              source.sendError(Text.translatable("commands.home.fail",home_pos[i]));
            }
            
        } else {
           if (player instanceof PlayerEntity) {
               // pos.add(PositionFlag.X);
               // pos.add(PositionFlag.Y);
               // pos.add(PositionFlag.Z);
               x = vec3d.x;
               y = vec3d.y;
               z = vec3d.z;
               home_pos[0] = x;
               home_pos[1] = y;
               home_pos[2] = z;
            }
            source.sendFeedback(() -> Text.translatable("commands.home.success",x,y,z), true);
        }
        return 1;
    }

    private static int setPosHome(ServerCommandSource source,PosArgument location,PlayerEntity player,String name) throws CommandSyntaxException {
      Vec3d vec3d = location.toAbsolutePos(source);
      // File file = new File("C:\\桌面\\cache", name);
      if (name == null) {
         b = b + 1;
         if (b <= 3) {
            for (String string : names) {
               name = string;
               player.addCommandTag(name);
            }
         }
         source.sendFeedback(() -> Text.translatable("commands.home.success"), true);
         return Command.SINGLE_SUCCESS;
      } else {
         player.addCommandTag(name);
      }
      if (vec3d == null) {
         source.sendError(Text.translatable("commands.home.fail"));
         return 0;
      } else {
         player.addCommandTag(vec3d.toString());
         source.sendFeedback(() -> Text.translatable("commands.home.success",vec3d.x,vec3d.y,vec3d.z), true);
      }
      return 1;
    }


    private static int tpHome(ServerCommandSource source, Collection<? extends Entity> targets, ServerWorld world, PosArgument location, @Nullable PosArgument rotation, @Nullable LookTarget facingLocation) throws CommandSyntaxException {
      Vec3d vec3d = location.toAbsolutePos(source);
      Vec2f vec2f = rotation == null ? null : rotation.toAbsoluteRotation(source);
      Set<PositionFlag> set = EnumSet.noneOf(PositionFlag.class);
      if (location.isXRelative()) {
         set.add(PositionFlag.X);
      }

      if (location.isYRelative()) {
         set.add(PositionFlag.Y);
      }

      if (location.isZRelative()) {
         set.add(PositionFlag.Z);
      }

      if (rotation == null) {
         set.add(PositionFlag.X_ROT);
         set.add(PositionFlag.Y_ROT);
      } else {
         if (rotation.isXRelative()) {
            set.add(PositionFlag.X_ROT);
         }

         if (rotation.isYRelative()) {
            set.add(PositionFlag.Y_ROT);
         }
      }

      @SuppressWarnings("rawtypes")
    Iterator var9 = targets.iterator();

      while(var9.hasNext()) {
         Entity entity = (Entity)var9.next();
         if (rotation == null) {
            teleport(source, entity, world, vec3d.x, vec3d.y, vec3d.z, set, entity.getYaw(), entity.getPitch(), facingLocation);
         } else {
            teleport(source, entity, world, vec3d.x, vec3d.y, vec3d.z, set, vec2f.y, vec2f.x, facingLocation);
         }
      }

      if (targets.size() == 1) {
         source.sendFeedback(() -> {
            return Text.translatable("commands.home.success", new Object[]{((Entity)targets.iterator().next()).getDisplayName(), formatFloat(vec3d.x), formatFloat(vec3d.y), formatFloat(vec3d.z)});
         }, true);
      }

      return targets.size();
   }

   private static int removePosHome(ServerCommandSource source,PosArgument pos,PlayerEntity player) throws CommandSyntaxException {
      Vec3d vec3d = pos.toAbsolutePos(source);
      if (vec3d == null) {
         source.sendError(Text.translatable("commands.home.fail"));
         return 0;
      } else {
         player.removeCommandTag(vec3d.toString());
         source.sendFeedback(() -> Text.translatable("commands.home.success",vec3d.x,vec3d.y,vec3d.z), true);
      }
      return 1;
   }

   private static int removeNameHome(ServerCommandSource source,String name,PlayerEntity player) throws CommandSyntaxException {
      if (name == null) {
         source.sendError(Text.translatable("commands.home.rem.fail"));
         return 0;
      } else {
         player.removeCommandTag(name);
         source.sendFeedback(() -> Text.translatable("commands.home.rem.success",name), true);
      }
      return 1;
   }

   private static String formatFloat(double d) {
      return String.format(Locale.ROOT, "%f", d);
   }


    private static void teleport(ServerCommandSource source, Entity target, ServerWorld world, double x, double y, double z, Set<PositionFlag> movementFlags, float yaw, float pitch, @Nullable LookTarget facingLocation) throws CommandSyntaxException {
      BlockPos blockPos = BlockPos.ofFloored(x, y, z);
      if (!World.isValid(blockPos)) {
         throw INVALID_POSITION_EXCEPTION.create();
      } else {
         float f = MathHelper.wrapDegrees(yaw);
         float g = MathHelper.wrapDegrees(pitch);
         if (target.teleport(world, x, y, z, movementFlags, f, g)) {
            if (facingLocation != null) {
               //facingLocation.look(source, target);
            }

            label23: {
               if (target instanceof LivingEntity) {
                  LivingEntity livingEntity = (LivingEntity)target;
                  if (livingEntity.isFallFlying()) {
                     break label23;
                  }
               }

               target.setVelocity(target.getVelocity().multiply(1.0, 0.0, 1.0));
               target.setOnGround(true);
            }

            if (target instanceof PathAwareEntity) {
               PathAwareEntity pathAwareEntity = (PathAwareEntity)target;
               pathAwareEntity.getNavigation().stop();
            }

         }
      }
   }

}
