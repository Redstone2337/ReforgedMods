package com.redstone233.spawn.reforged.items.custom;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class VampiricSword extends SwordItem {

    public VampiricSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();

        if (playerEntity != null && itemStack != null) {
            float currentHP = playerEntity.getHealth();
            float maxHP = playerEntity.getMaxHealth();
            float vampirismAmount = calculateVampirismAmount(currentHP,maxHP);

            playerEntity.heal(vampirismAmount);
            itemStack.decrement(1);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (stack != null && user != null && entity != user) {
            if (hand == Hand.MAIN_HAND) {
                float currentHP = user.getHealth();
                float maxHP = user.getMaxHealth();
                float vampirismAmount = calculateVampirismAmount(currentHP,maxHP);

                user.heal(vampirismAmount);
                stack.decrement(1);
            } else if (hand == Hand.OFF_HAND) {
                float currentHP = user.getHealth();
                float maxHP = user.getMaxHealth();
                float vampirismAmount = calculateVampirismAmount(currentHP,maxHP);

                user.heal(vampirismAmount);
                stack.decrement(2);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (stack != null && target != null && attacker != null) {
            if (Hand.MAIN_HAND != null) {
                float currentHP = attacker.getHealth();
                float maxHP = attacker.getMaxHealth();
                float vampirismAmount = calculateVampirismAmount(currentHP,maxHP);

                attacker.heal(vampirismAmount);
                stack.decrement(1);
            } else if (Hand.OFF_HAND != null) {
                float currentHP = attacker.getHealth();
                float maxHP = attacker.getMaxHealth();
                float vampirismAmount = calculateVampirismAmount(currentHP,maxHP);

                attacker.heal(vampirismAmount);
                stack.decrement(1);
            }
        }
        return true;
    }

    private float calculateVampirismAmount(float currentHP, float maxHP) {
            double percentage = 0.1;
            float missingHealth = maxHP - currentHP;
            float VampirismAmount = (float) (missingHealth * percentage);
        return VampirismAmount;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.trsm.vampirism.tooltip1"));
        tooltip.add(Text.translatable("item.trsm.vampirism.tooltip2"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
