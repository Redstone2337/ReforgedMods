package com.redstone233.spawn.reforged.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class SeckillArmorEnchant extends Enchantment {

    public SeckillArmorEnchant(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
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
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (attacker instanceof LivingEntity && user instanceof PlayerEntity player) {
            ((LivingEntity) attacker).addStatusEffect(
                new StatusEffectInstance(StatusEffects.WITHER,-1,255,false,true));
            player.addStatusEffect(
                new StatusEffectInstance(StatusEffects.STRENGTH,1200,255,false,true));
        }
        super.onUserDamaged(user, attacker, level);
    }

}
