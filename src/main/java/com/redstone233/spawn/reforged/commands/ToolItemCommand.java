package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.redstone233.spawn.reforged.items.ModItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ToolItemCommand {

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("moditem")
            .requires(src -> src.hasPermissionLevel(2))
                .then(CommandManager.literal("sword")
                .then(CommandManager.literal("reforged")
                    .then(CommandManager.literal("give")
                    .executes(run -> giveReforged(run.getSource())
                    )
                )
                .then(CommandManager.literal("clear")
                    .executes(run -> clearReforged(run.getSource())
                    )
                )
            )
            .then(CommandManager.literal("nexus")
                .then(CommandManager.literal("give")
                    .executes(run -> giveNexus(run.getSource())
                    )
                )
        .then(CommandManager.literal("clear")
                .executes(run -> clearNexus(run.getSource())
                    )
                )
            )
            .then(CommandManager.literal("ice")
            .then(CommandManager.literal("give")
                .executes(run -> giveIce(run.getSource())
                    )
                )
            .then(CommandManager.literal("clear")
                .executes(run -> clearIce(run.getSource())
                    )
                )
            )
            .then(CommandManager.literal("amethyst")
            .then(CommandManager.literal("give")
                .executes(run -> giveAmethyst(run.getSource())
                )
            )
        .then(CommandManager.literal("clear")
                    .executes(run -> clearAmethyst(run.getSource())
                    )
                )
            )
        )
        .requires(src -> src.hasPermissionLevel(2))
            .then(CommandManager.literal("axe")
            .then(CommandManager.literal("reforged")
            .then(CommandManager.literal("give") 
                    .executes(run -> giveReforgedAxe(run.getSource())
                    )
                )
                .then(CommandManager.literal("clear")
                    .executes(run -> clearReforgedAxe(run.getSource())
                    )
                )
            )
            .then(CommandManager.literal("combo")
            .then(CommandManager.literal("give")
                .executes(run -> giveComboAxe(run.getSource())
                )
            )
                .then(CommandManager.literal("clear")
                    .executes(run -> clearComboAxe(run.getSource())
                    )
                )
            )
            .then(CommandManager.literal("second")
            .then(CommandManager.literal("give")
                .executes(run -> giveSecondAxe(run.getSource())
                )
            )
                .then(CommandManager.literal("clear")
                    .executes(run -> clearSecondAxe(run.getSource())
                    )
                )
            )
        );
    }

    private static int giveReforged(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.REFORGED_SWORD))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearReforged(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int giveNexus(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.NEXUS_SWORD))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearNexus(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int giveIce(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.ICE_DRAGON_SWORD))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearIce(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int giveAmethyst(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.REFORGED_AMETHYST_SWORD))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearAmethyst(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int giveReforgedAxe(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.REFORGED_AXE))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearReforgedAxe(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int giveComboAxe(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.COMBO_AXE))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearComboAxe(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int giveSecondAxe(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().insertStack(new ItemStack(ModItems.SECOND_AXE))) {
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }

    private static int clearSecondAxe(ServerCommandSource source) throws CommandSyntaxException {
        PlayerEntity player = source.getPlayer();
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        if (bl) {
            if (!player.getInventory().isEmpty()) {
                player.getInventory().clear();
                throw new SimpleCommandExceptionType(Text.translatable("invnventory.isfull")).create();
            }
            source.sendFeedback(() -> Text.translatable("commands.moditem.success"), false);
            return 1;
        } else {
            source.sendError(Text.translatable("commands.moditem.fail"));
            return 0;
        }        
    }
}
