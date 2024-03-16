package com.redstone233.spawn.reforged.datagen;

import java.util.concurrent.CompletableFuture;

import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.trsm.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup arg) {
        //throw new UnsupportedOperationException("Unimplemented method 'configure'");
        getOrCreateTagBuilder(ModTags.Blocks.PROSPECTOR_LIST)
            .add(ModBlocks.FIRE_REFORGED_BLOCK)
            .forceAddTag(BlockTags.COAL_ORES)
            .forceAddTag(BlockTags.IRON_ORES)
            .forceAddTag(BlockTags.GOLD_ORES)
            .forceAddTag(BlockTags.LAPIS_ORES)
            .forceAddTag(BlockTags.DIAMOND_ORES)
            .forceAddTag(BlockTags.REDSTONE_ORES)
            .forceAddTag(BlockTags.EMERALD_ORES)
            .forceAddTag(BlockTags.COPPER_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.FIRE_REFORGED_BLOCK)
            .add(ModBlocks.REFORGED_BLOCK)
            .add(ModBlocks.REFORGED_BLOCK1);
            
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.REFORGED_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.REFORGED_BLOCK1);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.FIRE_REFORGED_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, 
            new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.FIRE_REFORGED_BLOCK);
                
        getOrCreateTagBuilder(BlockTags.FENCES)
            .add(ModBlocks.REFORGED_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
            .add(ModBlocks.REFORGED_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
            .add(ModBlocks.REFORGED_WALL);
    }
    
}
