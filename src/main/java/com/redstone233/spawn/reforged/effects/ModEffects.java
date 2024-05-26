package com.redstone233.spawn.reforged.effects;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect FIRE_STATUS_EFFECT = registerModEffects("fire_on_body", new FireEffect());
    public static final StatusEffect GREAT_FIRE_STATUS = registerModEffects("great_fire_on_body",new GreatFireEffect());
    public static final StatusEffect GOOD_FIRE_STATUS = registerModEffects("good_fire_on_body", new GoodFireEffect());

    public static final StatusEffect EXP_EFFECT = registerModEffects("experience",  new ExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect GOOD_EXP_EFFECT = registerModEffects("good_experience",  new GoodExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect GREAT_EXP_EFFECT = registerModEffects("great_experience",  new GreatExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect BETTER_EXP_EFFECT = registerModEffects("better_experience",  new BetterExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    public static final StatusEffect BEST_EXP_EFFECT = registerModEffects("best_experience",  new BestExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));

    private static final StatusEffect registerModEffects(String name,StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, 
            new Identifier(ReforgeSpawnMod.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        
    }
}
