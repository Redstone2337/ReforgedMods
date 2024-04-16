package com.redstone233.spawn.reforged.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class FireEffects extends StatusEffect {

    public FireEffects() {
        super(StatusEffectCategory.BENEFICIAL, 0xFF8247);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isOnFire()) {
            entity.setOnFireFor(20 * (amplifier + 1));
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // 每刻（tick）对实体应用效果
        // 在这里，我们可以添加火焰附加效果
        if (entity.isOnFire()) {
            // 如果实体已经在燃烧，我们就不需要再次点燃
            return;
        }
        // 有概率使实体着火
        // if (world.random.nextFloat() < (0.1 * (amplifier + 1))) {
           // entity.setFire(1);
        // }
        // 提供生命恢复
        entity.heal(1.0f / (amplifier + 1));
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity.isOnFire()) {
            entity.clearStatusEffects();
        }
        super.onApplied(entity, amplifier);
    }

}
