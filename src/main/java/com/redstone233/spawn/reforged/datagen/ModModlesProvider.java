package com.redstone233.spawn.reforged.datagen;

import com.redstone233.spawn.reforged.block.AppleCropBlock;
import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.items.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REFORGED_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHANCE_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.REFORGED_APPLE_CROP,
            AppleCropBlock.AGE, 
                0,1,2,3,4,5);

        BlockStateModelGenerator.BlockTexturePool reforgedTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FIRE_REFORGED_BLOCK);

        reforgedTexturePool.stairs(ModBlocks.REFORGED_STAIR);
        reforgedTexturePool.slab(ModBlocks.REFORGED_SLAB);
        reforgedTexturePool.wall(ModBlocks.REFORGED_WALL);
        reforgedTexturePool.button(ModBlocks.REFORGED_BUTTON);
        reforgedTexturePool.pressurePlate(ModBlocks.REFORGED_PRESSURE_PLATE);
        reforgedTexturePool.fence(ModBlocks.REFORGED_FENCE);
        reforgedTexturePool.fenceGate(ModBlocks.REFORGED_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.REFORGED_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.REFORGED_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //throw new UnsupportedOperationException("Unimplemented method 'generateItemModels'");
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFORGED_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFORGED_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFORGED_ITEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.REFORGED_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.REFORGED_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REFORGED_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REFORGED_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COMBO_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SECOND_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REFORGED_SHOVRL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REFORGED_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.REFORGED_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REFORGED_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REFORGED_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REFORGED_BOOTS);

    }

}
