package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.redstone233.spawn.reforged.ModGlobalInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class InfoCommand {

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("info")
            .requires(src -> src.hasPermissionLevel(4))
                .then(CommandManager.literal("text")
                    .then(CommandManager.argument("line", IntegerArgumentType.integer())
                        .executes(run -> runLine(run.getSource(), 
                            IntegerArgumentType.getInteger(run, "line"))
                        )
                    )
                )
            .then(CommandManager.literal("book")
                .then(CommandManager.argument("page", IntegerArgumentType.integer())
                    .executes(run -> runBook(run.getSource(), 
                        IntegerArgumentType.getInteger(run, "page"))
                    )
                )
            )
            .then(CommandManager.literal("ver")
                .then(CommandManager.argument("value", IntegerArgumentType.integer())
                    .executes(run -> runVers(run.getSource(), 
                        IntegerArgumentType.getInteger(run, "value"))
                )
            )
        );
    }

    private static int runLine(ServerCommandSource source,int line) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
       if (bl) {
        if (source instanceof ServerCommandSource) {
            if (line != 0 && line >= 5) {
                if (line == 1) {
                    player.sendMessage(
                        Text.translatable("commands.info.line1",line,ModGlobalInfo.TextGlobal.textArray[0]), false);
                } else if (line == 2) {
                    player.sendMessage(
                        Text.translatable("commands.info.line2",line,ModGlobalInfo.TextGlobal.textArray[1]), false);
                } else if (line == 3) {
                    player.sendMessage(
                        Text.translatable("commands.info.line3",line,ModGlobalInfo.TextGlobal.textArray[2]), false);
                } else if (line == 4) {
                    player.sendMessage(
                        Text.translatable("commands.info.line4",line,ModGlobalInfo.TextGlobal.textArray[3]), false);
                } else if (line >= 5) {
                    player.sendMessage(Text.translatable("commands.info.line5",line), false);
                    source.sendError(Text.translatable("commands.info.fail"));
                    return 0;
                }
            }
                if (!source.getServer().isDedicated()) {
                    throw ModCommands.TRSM_COMMAND_WORONG_BE_INTEGRATED.create();
                }
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
            }
        }
       return 1;
    }

    private static int runBook(ServerCommandSource source,int page) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (page != 0 && page <= 5) {
                    if (page == 1) {
                        player.sendMessage(
                            Text.translatable("commands.info.page1",page,
                                ModGlobalInfo.TextGlobal.textArray[0]), false);
                    } else if (page == 2) {
                        player.sendMessage(
                            Text.translatable("commands.info.page2",page,
                                ModGlobalInfo.TextGlobal.textArray[1]), false);
                    } else if (page == 3) {
                        player.sendMessage(
                            Text.translatable("commands.info.page3",page,
                                ModGlobalInfo.TextGlobal.textArray[2]), false);
                    } else if (page == 4) {
                        player.sendMessage(
                            Text.translatable("commands.info.page4",page,
                                ModGlobalInfo.TextGlobal.textArray[3]), false);
                    } else if (page >= 5) {
                        player.sendMessage(Text.translatable("commands.info.page5",page), false);
                        source.sendError(Text.translatable("commands.info.fail"));
                        return 0;
                    }
                }
                if (!source.getServer().isDedicated()) {
                    throw ModCommands.TRSM_COMMAND_WORONG_BE_INTEGRATED.create();
                }
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
            }
        }  
        return Command.SINGLE_SUCCESS;
    }

    private static int runVers(ServerCommandSource source,int value) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (source instanceof ServerCommandSource) {
                if (value != 0 && value <= 4) {
                    if (value == 1) {
                        player.sendMessage(
                            Text.translatable("commands.info.ver1",value,
                                ModGlobalInfo.TextGlobal.versionAr[0]), false);
                    } else if (value == 2) {
                        player.sendMessage(
                            Text.translatable("commands.info.ver2",value,
                                ModGlobalInfo.TextGlobal.versionAr[1]), false);
                    } else if (value == 3) {
                        player.sendMessage(
                            Text.translatable("commands.info.ver3",value,
                                ModGlobalInfo.TextGlobal.versionAr[2]), false);
                    } else if (value >= 4) {
                        player.sendMessage(Text.translatable("commands.info.ver4",value), false);
                        source.sendError(Text.translatable("commands.info.fail"));
                        return 0;
                    }
                }
                if (!source.getServer().isDedicated()) {
                    throw ModCommands.TRSM_COMMAND_WORONG_BE_INTEGRATED.create();
                }
                source.sendFeedback(() -> Text.translatable("commands.info.success"), false);
            }
            
        }   
        return 1;  
    }  
      
}

