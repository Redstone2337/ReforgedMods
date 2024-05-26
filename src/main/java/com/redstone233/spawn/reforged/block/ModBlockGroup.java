package com.redstone233.spawn.reforged.block;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModBlockGroup {

    @SuppressWarnings("unused")
    private static final ItemGroup BLOCK_GROUP = 
        Registry.register(Registries.ITEM_GROUP,
        new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_block_group"), 
        FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModBlocks.REFORGED_BLOCK1))
                .displayName(Text.translatable("itemGroup.trsm_block_group"))
                .entries((context, entries) -> {
                    entries.add(ModBlocks.REFORGED_BUTTON);
                    entries.add(ModBlocks.REFORGED_DOOR);
                    entries.add(ModBlocks.REFORGED_FENCE);
                    entries.add(ModBlocks.REFORGED_FENCE_GATE);
                    entries.add(ModBlocks.REFORGED_PRESSURE_PLATE);
                    entries.add(ModBlocks.REFORGED_SLAB);
                    entries.add(ModBlocks.REFORGED_STAIR);
                    entries.add(ModBlocks.REFORGED_TRAPDOOR);
                    entries.add(ModBlocks.CHANCE_BLOCK);
                    entries.add(ModBlocks.REFORGED_ORE);
                    entries.add(ModBlocks.REFORGED_BLOCK);
                    entries.add(ModBlocks.REFORGED_BLOCK1);
                    entries.add(ModBlocks.FIRE_REFORGED_BLOCK);
                })
                .build()
            );




    public static void registerModBlockGroup() {
        
    }
}
