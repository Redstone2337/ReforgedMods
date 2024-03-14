package com.redstone233.spawn.reforged.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent REFORGED_FOOD = 
        new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,200), (float) 0.2)
        .build();

    public static final FoodComponent REFORGED_APPLE = 
        new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,200), (float) 0.5)
        .build();
}
