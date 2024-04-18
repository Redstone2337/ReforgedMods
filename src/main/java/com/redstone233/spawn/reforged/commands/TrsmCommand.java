package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.redstone233.spawn.reforged.ModGlobalInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class TrsmCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("trsm")
            .requires(src -> src.hasPermissionLevel(2))
                .then(CommandManager.literal("info")
                    .then(CommandManager.argument("page", IntegerArgumentType.integer())
                    .executes(null)
            )
        )
            .requires(src -> src.hasPermissionLevel(2))
                .then(CommandManager.literal("depends")
                    .then(CommandManager.literal("fabric")
                    .executes(run -> getDependsFabric(run.getSource()))
            ).then(CommandManager.literal("minecraft")
                .executes(run -> getDependsMinecraft(run.getSource()))
            )
        );
    }

    private static int getDependsFabric(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            source.sendFeedback(() -> {
                return Text.translatable("commands.trsm.success");
            }, true);
            player.sendMessage(Text.translatable("commands.trsm.fabric.version",
                ModGlobalInfo.TextGlobal.versionAr[1]), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.trsm.fail"));
            return 0;
        }
    }

    private static int getDependsMinecraft(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            source.sendFeedback(() -> {
                    return Text.translatable("commands.trsm.success");
            }, true);
            player.sendMessage(Text.translatable("commands.trsm.minecraft.version",
            ModGlobalInfo.TextGlobal.versionAr[0]), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.trsm.fail"));
            return 0;
        }
        
    }
}
