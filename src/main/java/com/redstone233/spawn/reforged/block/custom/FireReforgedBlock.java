package com.redstone233.spawn.reforged.block.custom;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;

public class FireReforgedBlock extends Block {

    public FireReforgedBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(200);
        super.onEntityLand(world, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("item.trsm.fire_reforged_block.tooltip"));
        super.appendTooltip(stack, world, tooltip, options);
    }

}
