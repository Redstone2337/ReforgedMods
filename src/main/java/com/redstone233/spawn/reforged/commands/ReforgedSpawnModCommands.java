package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.redstone233.spawn.reforged.ModGlobalInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;

public class ReforgedSpawnModCommands {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("trsm")
            .requires(c -> c.hasPermissionLevel(4))
            .then(literal("info")
                    .then(argument("page", IntegerArgumentType.integer(1, 4))
                        .executes(
                            run -> getSuccess(run.getSource(), IntegerArgumentType.getInteger(run, "page"),
                                run.getSource().getPlayer()))))
                .requires(b -> b.hasPermissionLevel(4))
                .then(literal("depends")
                .executes(a -> executeStopStep(a.getSource()))
                    .then(literal("fabric")
                    .executes(a -> getDependsFabric(a.getSource(),a.getSource().getPlayer()))
                )
                    .then(literal("minecraft")
                    .executes(d -> getDependsMinecraft(d.getSource(),d.getSource().getPlayer()))
                )
            )                 
        );
    }

    private static int getDependsFabric(ServerCommandSource source,PlayerEntity player) {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           source.sendFeedback(() -> {
              return Text.translatable("commands.info.depends.fabric.success");
           }, true);
           player.sendMessage((Text) new LiteralMessage("[Cmds/INFO]Dependence Fabric to" + ModGlobalInfo.TextGlobal.versionAr[1]));
           return 1;
        } else {
           source.sendError(Text.translatable("commands.info.depends.fabric.fail"));
           player.sendMessage((Text) new LiteralMessage("[Cmds/ERROR]Dependence Fabric is error!"));
           return 0;
        }
    }

    private static int getDependsMinecraft(ServerCommandSource source,PlayerEntity player) {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           source.sendFeedback(() -> {
              return Text.translatable("commands.info.depends.minecraft.success");
           }, true);
           player.sendMessage((Text) new LiteralMessage("[Cmds/INFO]Dependence Minecraft to" + ModGlobalInfo.TextGlobal.versionAr[0]));
           return 1;
        } else {
           source.sendError(Text.translatable("commands.info.depends.minecraft.fail"));
           player.sendMessage((Text) new LiteralMessage("[Cmds/ERROR]Dependence Minecraft is error!"));
           return 0;
        }
    }

    private static int getSuccess(ServerCommandSource source, int page, PlayerEntity player) {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            source.sendFeedback(() -> {
                return Text.translatable("commands.trsm.info.page.success");
            }, true);
            if (page == 1) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[0]));
            } else if (page == 2) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[1]));
            } else if (page == 3) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[2]));
            } else if (page == 4) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/Main]" + ModGlobalInfo.TextGlobal.textArray[3]));
            }
            return 1;
        } else {
            source.sendError(Text.translatable("commands.trsm.info.page.fail"));
            if (page <= 0) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/ERROR]This value is so small!"));
            }
            if (page >= 5) {
                player.sendMessage((Text) new LiteralMessage("[Cmds/ERROR]This value is so big!"));
            }
            return 0;
        }
    }

    private static int executeStopStep(ServerCommandSource source) {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
           source.sendFeedback(() -> {
              return Text.translatable("commands.trsm.info.depends.success");
           }, true);
           return 1;
        } else {
           source.sendError(Text.translatable("commands.trsm.info.depends.fail"));
           return 0;
        }
     }

}
