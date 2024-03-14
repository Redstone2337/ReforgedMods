package com.redstone233.spawn.reforged.block;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.block.custom.FireReforgedBlock;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block REFORGED_BLOCK = 
        registerBlocks("reforged_block", 
        new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_BLOCK1 = 
        registerBlocks("reforged_block1", 
        new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_APPLE_CROP = Registry.register(Registries.BLOCK, 
        new Identifier(ReforgeSpawnMod.MOD_ID, "reforged_apple_crop"), 
            new AppleCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block FIRE_REFORGED_BLOCK = 
        registerBlocks("fire_reforged_block", 
            new FireReforgedBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    private static Block registerBlocks(String name,Block block) {
        registerBlockItems(name,block);
        return Registry.register(Registries.BLOCK, 
            new Identifier(ReforgeSpawnMod.MOD_ID, name), block);
    }

    private static Item registerBlockItems(String name,Block block) {
        return Registry.register(Registries.ITEM,
            new Identifier(ReforgeSpawnMod.MOD_ID, name),
                new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks() {

    }
}
