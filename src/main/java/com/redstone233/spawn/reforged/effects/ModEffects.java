package com.redstone233.spawn.reforged.effects;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final StatusEffect FIRE_STATUS_EFFECT = 
        registerModEffects("fire_effect",
            new FireEffects());

    private static final StatusEffect registerModEffects(String name,StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, 
            new Identifier(ReforgeSpawnMod.MOD_ID, name), effect);
    }

    public static void registerModEffects() {
        
    }
}
