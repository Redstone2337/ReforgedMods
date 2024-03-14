package com.redstone233.spawn.reforged.block;

import com.redstone233.spawn.reforged.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.Properties;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;

public class AppleCropBlock extends CropBlock {

    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;

    public AppleCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.REFORGED_APPLE_SEEDS;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
