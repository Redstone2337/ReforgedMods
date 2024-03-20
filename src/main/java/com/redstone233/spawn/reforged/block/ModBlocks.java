package com.redstone233.spawn.reforged.block;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.block.custom.FireReforgedBlock;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
// import net.minecraft.block.Block;
// import net.minecraft.block.BlockSetType;
// import net.minecraft.block.Blocks;
// import net.minecraft.block.ButtonBlock;
// import net.minecraft.block.DoorBlock;
// import net.minecraft.block.FenceBlock;
// import net.minecraft.block.FenceGateBlock;
// import net.minecraft.block.PressurePlateBlock;
// import net.minecraft.block.SlabBlock;
// import net.minecraft.block.StairsBlock;
// import net.minecraft.block.TrapdoorBlock;
// import net.minecraft.block.WallBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block REFORGED_BLOCK = 
        registerBlocks("reforged_block1", 
        new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
        
        public static final Block REFORGED_ORE = registerBlocks("reforged_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(5f),UniformIntProvider.create(2,5)));

    public static final Block REFORGED_BLOCK1 = 
        registerBlocks("reforged_block", 
        new Block(FabricBlockSettings.copyOf(Blocks.STONE)));
        
        public static final Block CHANCE_BLOCK = 
        registerBlocks("chance_block", 
        new Block(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_STAIR = 
        registerBlocks("reforged_stairs", 
        new StairsBlock(ModBlocks.REFORGED_BLOCK1.getDefaultState(),FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_SLAB = 
        registerBlocks("reforged_slab", 
        new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_BUTTON = 
        registerBlocks("reforged_button", 
            new ButtonBlock(BlockSetType.STONE, 20, FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_PRESSURE_PLATE = 
        registerBlocks("reforged_pressure_plate", 
            new PressurePlateBlock(BlockSetType.STONE,FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_FENCE = 
        registerBlocks("reforged_fence", 
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
            
    public static final Block REFORGED_FENCE_GATE = 
        registerBlocks("reforged_fance_gate", 
            new FenceGateBlock(WoodType.OAK,FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_WALL = 
        registerBlocks("reforged_wall", 
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_DOOR= 
        registerBlocks("reforged_door", 
            new DoorBlock(BlockSetType.STONE,FabricBlockSettings.copyOf(Blocks.STONE)));

    public static final Block REFORGED_TRAPDOOR = 
        registerBlocks("reforged_trapdoor", 
            new TrapdoorBlock(BlockSetType.STONE,FabricBlockSettings.copyOf(Blocks.STONE)));
    
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
