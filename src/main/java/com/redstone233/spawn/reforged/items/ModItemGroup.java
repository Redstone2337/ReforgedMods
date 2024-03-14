package com.redstone233.spawn.reforged.items;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.block.ModBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    @SuppressWarnings("unused")
    private static final ItemGroup ITEM_GROUP = 
        Registry.register(Registries.ITEM_GROUP, 
        new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_group"), 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.REFORGED_ITEM))
                .displayName(Text.translatable("itemGroup.trsm_group"))
                .entries((context, entries) -> {
                    entries.add(ModItems.REFORGED_ITEM);
                    entries.add(ModItems.REFORGED_FOOD);
                    entries.add(ModBlocks.REFORGED_BLOCK);
                    entries.add(ModBlocks.REFORGED_BLOCK1);
                    entries.add(ModBlocks.FIRE_REFORGED_BLOCK);
                    entries.add(ModItems.PROSPECTOR);
                    entries.add(ModItems.REFORGED_COAL);

                    entries.add(ModItems.REFORGED_SWORD);
                    entries.add(ModItems.REFORGED_PICKAXE);
                    entries.add(ModItems.REFORGED_AXE);
                    entries.add(ModItems.REFORGED_SHOVRL);
                    entries.add(ModItems.REFORGED_HOE);

                    entries.add(ModItems.REFORGED_HELMET);
                    entries.add(ModItems.REFORGED_CHESTPLATE);
                    entries.add(ModItems.REFORGED_LEGGINGS);
                    entries.add(ModItems.REFORGED_BOOTS);
                    entries.add(ModItems.REFORGED_APPLE_SEEDS);
                    entries.add(ModItems.REFORGED_APPLE);
                })
                .build());

    public static void registerModItemGroup() {
        
    }
}

// C:\Users\Redstone\.gradle\wrapper\dists\gradle-8.6-bin\afr5mpiioh2wthjmwnkmdsd5w\gradle-8.6
