package com.redstone233.spawn.reforged.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class CurseSpeedEnchantment extends Enchantment {

    public CurseSpeedEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxPower(int level) {
        return 5;
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && user instanceof PlayerEntity player) {
            ((LivingEntity) target).addStatusEffect(
                new StatusEffectInstance(StatusEffects.SPEED,20 * 4 * level));
            ((LivingEntity) target).addStatusEffect(
                new StatusEffectInstance(StatusEffects.SLOW_FALLING,20 * 4 * level));
            player.addStatusEffect(
                new StatusEffectInstance(StatusEffects.STRENGTH,100 * 2 * level));
            player.addStatusEffect(
                new StatusEffectInstance(StatusEffects.GLOWING,20 * 4 * level));
        }
        super.onTargetDamaged(user, target, level);
    }

}
