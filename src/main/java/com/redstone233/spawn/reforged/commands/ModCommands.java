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

    public static final SimpleCommandExceptionType TRSM_COMMAND_EXCEPTION_TYPE = 
        new SimpleCommandExceptionType(Text.translatable("commands.trsm.run"));
    public static final SimpleCommandExceptionType TRSM_COMMAND_WORONG_BE_INTEGRATED =
        new SimpleCommandExceptionType(Text.translatable("commands.trsm.be.int"));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        LiteralArgumentBuilder<ServerCommandSource> builder =
            CommandManager.literal("reforgedspawn").executes(ModCommands::run)
            .then(LongCommand.register())
            .then(NbtCommand.register())
            .then(TrsmCommand.register())
            .then(InfoCommand.register())
            .then(ToolItemCommand.register())
            .then(ReforgedCommand.register());
        dispatcher.register(builder);
        dispatcher.register(HomeCommand.register());
    }

    private static int run(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        throw new SimpleCommandExceptionType(Text.translatable("commands.trsm.usage")).create();
    }

}
