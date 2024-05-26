package com.redstone233.spawn.reforged.items.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IceStaff extends Item {

    public IceStaff(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        BlockPos pos = user.getBlockPos();
        if (!world.isClient()) {
            if (user != null && hand == Hand.MAIN_HAND) {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,50,false,false,false));
                BlockState ice = Blocks.ICE.getDefaultState();
                world.setBlockState(pos, ice, 3);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

}
