package com.redstone233.spawn.reforged.datagen;

import com.redstone233.spawn.reforged.block.ModBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

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
    }
    
}
