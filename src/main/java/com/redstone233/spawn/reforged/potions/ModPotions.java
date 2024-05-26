package com.redstone233.spawn.reforged.potions;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.effects.ModEffects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {


    // public static final Potion FIRE_POTION = registerModPotions("fire_potion", 
       // new FirePotion(new StatusEffectInstance[]{new StatusEffectInstance(ModEffects.FIRE_STATUS_EFFECT)}));

    public static final Potion FIRE_POTION = registerModPotions("fire_on_body", 
        new Potion(new StatusEffectInstance(ModEffects.FIRE_STATUS_EFFECT,1600)));
    
    public static final Potion GREAT_FIRE_POTION = registerModPotions("great_fire_on_body", 
        new Potion(new StatusEffectInstance(ModEffects.GREAT_FIRE_STATUS,1400)));

    public static final Potion GOOD_FIRE_POTION = registerModPotions("good_fire_on_body", 
        new Potion(new StatusEffectInstance(ModEffects.GREAT_FIRE_STATUS,1200)));

    public static final Potion EXP_POTION = registerModPotions("experience", 
        new Potion(new StatusEffectInstance(ModEffects.EXP_EFFECT,2000)));

    public static final Potion GOOD_EXP_POTION = registerModPotions("good_experience", 
        new Potion(new StatusEffectInstance(ModEffects.GOOD_EXP_EFFECT,1800)));

    public static final Potion GREAT_EXP_POTION = registerModPotions("great_experience", 
        new Potion(new StatusEffectInstance(ModEffects.GREAT_EXP_EFFECT,1600)));

    public static final Potion BETTER_EXP_POTION = registerModPotions("better_experience", 
        new Potion(new StatusEffectInstance(ModEffects.BETTER_EXP_EFFECT,1400)));

    public static final Potion BEST_EXP_POTION = registerModPotions("best_experience", 
        new Potion(new StatusEffectInstance(ModEffects.BEST_EXP_EFFECT,1200)));

    private static Potion registerModPotions(String name, Potion potion) {
        return (Potion)Registry.register(Registries.POTION, 
            new Identifier(ReforgeSpawnMod.MOD_ID, name), potion);
    }

    public static void registerModPotions() {
        
    }
}
