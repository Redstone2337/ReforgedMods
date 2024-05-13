package com.redstone233.spawn.reforged.items;

import com.google.common.base.Supplier;
import com.redstone233.spawn.reforged.ReforgeSpawnMod;

import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ModArmorMaterial implements ArmorMaterial {
    REFORGED_ITEM("reforged_item",25, new int[]{3,8,6,3},20,
        SoundEvents.ITEM_ARMOR_EQUIP_IRON,2f,0.1f,
        () -> Ingredient.ofItems(ModItems.REFORGED_ITEM));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterial(String name, int durabilityMultiplier,
            int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness,
            float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability(Type type) {
        return BASE_DURABILITY[type.ordinal()]*this.durabilityMultiplier;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public String getName() {
        return ReforgeSpawnMod.MOD_ID + ":" + this.name;
    }

    @Override
    public int getProtection(Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

}
