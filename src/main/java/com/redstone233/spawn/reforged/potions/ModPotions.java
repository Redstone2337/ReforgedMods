package com.redstone233.spawn.reforged.potions;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.effects.ModEffects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {


    public static final Potion FIRE_POTION = registerModPotions("fire_potion", 
        new FirePotion(new StatusEffectInstance[]{new StatusEffectInstance(ModEffects.FIRE_STATUS_EFFECT)}));

    public static final Potion GREAT_FIRE_POTION = registerModPotions("great_fire_potion", 
        new Potion(new StatusEffectInstance(ModEffects.GREAT_FIRE_STATUS,600)));


    private static Potion registerModPotions(String name, Potion potion) {
        return (Potion)Registry.register(Registries.POTION, 
            new Identifier(ReforgeSpawnMod.MOD_ID, name), potion);
    }

    public static void registerModPotions() {
        
    }
}
