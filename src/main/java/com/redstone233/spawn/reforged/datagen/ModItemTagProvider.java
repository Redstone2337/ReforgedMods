package com.redstone233.spawn.reforged.datagen;

import java.util.concurrent.CompletableFuture;

import com.redstone233.spawn.reforged.items.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.REFORGED_HELMET,ModItems.REFORGED_CHESTPLATE,
                ModItems.REFORGED_LEGGINGS,ModItems.REFORGED_BOOTS);
    }

}
