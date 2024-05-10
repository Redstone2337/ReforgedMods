package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class LongCommand {

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("long")
            .requires(src -> src.hasPermissionLevel(2))
                .then(CommandManager.argument("value", IntegerArgumentType.integer())
                    .executes(run -> getValue(run.getSource(), IntegerArgumentType.getInteger(run, "value"), run.getSource().getPlayer()))
        );
    }

    private static int getValue(ServerCommandSource source,int value,PlayerEntity player) throws CommandSyntaxException {
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        //if (bl) {
           if (source instanceof ServerCommandSource) { 
            if (value %2 == 0) {
                player.sendMessage(Text.translatable("commands.long.even.info",value));
            } else if (value %2 != 0) {
                player.sendMessage(Text.translatable("commands.long.odd.info",value));
            } 
            if (value < 0) {
                source.sendError(Text.translatable("commands.long.fail"));
                return 0;
            }
            if (!source.getServer().isDedicated()) {
                throw ModCommands.TRSM_COMMAND_WORONG_BE_INTEGRATED.create();
            }
        }
        //}
        source.sendFeedback(() -> Text.translatable("commands.long.success"), true);
        return 1;
    }


}
