package com.redstone233.spawn.reforged.items.custom;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class Reforged3dHammer extends AxeItem {

    public Reforged3dHammer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,255,false,true));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,3,false,true));
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.trsm.3d.hammer.tooltip1"));
        tooltip.add(Text.translatable("item.trsm.3d.hammer.tooltip2"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}
