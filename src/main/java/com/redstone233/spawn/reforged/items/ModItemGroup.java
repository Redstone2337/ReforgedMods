package com.redstone233.spawn.reforged.items;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup REFORGED_GROUP =
        Registry.register(Registries.ITEM_GROUP,
            new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_item_group"), 
                FabricItemGroup
                    .builder()
                    .displayName(Text.translatable("itemGroup.trsm_item_group"))
                    .icon(() -> 
                        new ItemStack(ModItems.REFORGED_ITEM))
                        .entries((displayContext,entries) -> {
                            entries.add(ModItems.REFORGED_ITEM)
                        }));

    public static void registerModItemGroup() {
        
    }
}
