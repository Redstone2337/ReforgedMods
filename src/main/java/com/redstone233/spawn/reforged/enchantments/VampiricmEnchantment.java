package com.redstone233.spawn.reforged.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class VampiricmEnchantment extends Enchantment {

    // public VampiricmEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
    //     super(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON, 
    //         new EquipmentSlot[] {
    //             EquipmentSlot.MAINHAND,
    //             EquipmentSlot.OFFHAND
    //         }
    //     );
    // }

    protected VampiricmEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMaxPower(int level) {
        return 5;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

   @SuppressWarnings("unused")
@Override
   public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user instanceof LivingEntity && target instanceof LivingEntity) {
            LivingEntity userAttacker = (LivingEntity) user;
            LivingEntity livingTarget = (LivingEntity) target;
            float damageDealt = userAttacker.getMainHandStack().getDamage();
            float healthRestored = damageDealt * level * 0.1f;
            userAttacker.heal(healthRestored);
        }
       super.onTargetDamaged(user, target, level);
   }
}
