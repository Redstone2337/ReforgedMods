package com.redstone233.spawn.reforged.commands;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.ServerTickManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class NbtCommand {

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("nbt")
            .requires(src -> src.hasPermissionLevel(2))
                .then(CommandManager.argument("slot", IntegerArgumentType.integer())
                .executes(run -> getNbt(run.getSource(),
                    IntegerArgumentType.getInteger(run, "slot"),
                        run.getSource().getPlayer()
                )
            )
        );
    }

    private static int getNbt(ServerCommandSource source, int slot, PlayerEntity player) throws CommandSyntaxException{
        ServerTickManager serverTickManager = source.getServer().getTickManager();
        boolean bl = serverTickManager.stopStepping();
        ItemStack stack = player.getInventory().getStack(slot);
        if (bl) {
            if (slot >= 0 && slot <= 40) {
                if (stack.hasNbt()) {
                    assert stack.getNbt() != null;
                    String s = stack.getNbt().toString();
                    player.sendMessage((Text) new LiteralMessage(s), false);
                } else {
                    player.sendMessage(Text.translatable("commands.nbt.slot.error"), false);
                }
            } else if (slot < 0) {
                player.sendMessage(Text.translatable("commands.nbt.slot.small", slot), false);
            } else if (slot > 40) {
                player.sendMessage(Text.translatable("command.nbt.slot.big", slot), false);
            }
            source.sendFeedback(() -> {
                return Text.translatable("commands.nbt.success");
            }, true);
                return 1;
        } else {
            source.sendError(Text.translatable("commands.nbt.fail"));
                return 0;
        }
    }

}
