package com.redstone233.spawn.reforged.items.custom;

import java.util.List;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class NexusSword extends Item {
    public NexusSword(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();

        if (player != null && itemStack != null) {
            int currentHP = player.getHealth();
            int maxHP = player.getMaxHealth();
            int vampirismAmount = calculateVampirismAmount(currentHP, maxHP);

            player.heal(vampirismAmount);
            itemStack.decrement(1); // Decrease the item stack size by 1
        }

        return ActionResult.PASS;
    }

    private int calculateVampirismAmount(int currentHP, int maxHP) {
        // Calculate the amount of health to be restored based on your desired logic
        // For example, you can restore a percentage of the missing health
        double percentage = 0.1; // Restore 10% of the missing health
        int missingHealth = maxHP - currentHP;
        int vampirismAmount = (int) (missingHealth * percentage);
        return vampirismAmount;
    }
    
    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.trsm.nexus_sword.tooltip1").formatted(Formatting.GREEN));
        tooltip.add(Text.translatable("item.trsm.nexus_sword.tooltip2").formatted(Formatting.RED));
        super.appendTooltip(stack, world, tooltip, context);
    }
}