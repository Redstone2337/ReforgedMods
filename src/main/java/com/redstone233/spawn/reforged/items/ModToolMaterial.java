package com.redstone233.spawn.reforged.items;

import com.google.common.base.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterial implements ToolMaterial {
    REFORGED_AMETHYST(6,610,5.0f,4.0f,30,
    () -> Ingredient.ofItems(ModItems.REFORGED_AMETHYST)),
    ICE_DRAGON_SCALES(9,660,5.5f,4.5f,30,
    () -> Ingredient.ofItems(ModItems.ICE_DRAGON_SCALES)),
    REFORGED_ITEM(5,600,4.5f,3.5f,25,
    () -> Ingredient.ofItems(ModItems.REFORGED_ITEM));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel,int itemDurability,float miningSpeed,float attackDamage,int enchantability,Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
