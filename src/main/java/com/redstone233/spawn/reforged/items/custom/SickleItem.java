package com.redstone233.spawn.reforged.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class SickleItem extends SwordItem {
    public SickleItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user != null && entity != null) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,50,false,false,false));
        }
        if (user instanceof PlayerEntity) {
            entity.kill();
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target != null  && attacker != null) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,50,false,false,false));
        } else if (attacker instanceof PlayerEntity) {
            target.kill();
        }
        return true;
    }
}
