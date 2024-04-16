package com.redstone233.spawn.reforged.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class GreatFireEffect extends StatusEffect {

    public GreatFireEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFF8247);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isOnFire()) {
            entity.setOnFireFor(20 * (amplifier + 2));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity.isOnFire()) {
            entity.clearStatusEffects();
        }
        super.onApplied(entity, amplifier);
    }

}
