package com.redstone233.spawn.reforged.datagen;

import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.items.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModlesProvider extends FabricModelProvider {

    public ModModlesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //throw new UnsupportedOperationException("Unimplemented method 'generateBlockStateModels'");
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_REFORGED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REFORGED_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REFORGED_BLOCK1);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //throw new UnsupportedOperationException("Unimplemented method 'generateItemModels'");
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFORGED_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFORGED_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFORGED_ITEM, Models.GENERATED);
    }

}
