package com.redstone233.spawn.reforged.datagen;

import com.redstone233.spawn.reforged.block.AppleCropBlock;
import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.items.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {

    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //throw new UnsupportedOperationException("Unimplemented method 'generate'");
        addDrop(ModBlocks.FIRE_REFORGED_BLOCK);
        addDrop(ModBlocks.REFORGED_BLOCK);
        addDrop(ModBlocks.REFORGED_BLOCK1);

        BlockStatePropertyLootCondition.Builder builder = 
            BlockStatePropertyLootCondition.builder(ModBlocks.REFORGED_APPLE_CROP)
                .properties(StatePredicate.Builder.create()
                .exactMatch(AppleCropBlock.AGE, 5));

        addDrop(ModBlocks.REFORGED_APPLE_CROP,cropDrops(ModBlocks.REFORGED_APPLE_CROP,
            ModItems.REFORGED_APPLE, 
                ModItems.REFORGED_APPLE_SEEDS, builder));
    }
    
}