package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ModCommands {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> builder =
            CommandManager.literal("trsm").executes(ModCommands::run)
            .then(LongCommand.register())
            .then(NbtCommand.register())
            .then(TrsmCommand.register())
            .then(ReforgedCommand.register());
        dispatcher.register(builder);
    }

    private static int run(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        throw new SimpleCommandExceptionType(Text.translatable("commands.trsm.usage")).create();
    }

}
