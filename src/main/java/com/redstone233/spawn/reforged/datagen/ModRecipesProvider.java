package com.redstone233.spawn.reforged.datagen;


import java.util.List;

import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.items.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipesProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> REFORGED_ITEM_LIST = 
        List.of(ModItems.REFORGED_ITEM);

    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //throw new UnsupportedOperationException("Unimplemented method 'generate'");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.REFORGED_ITEM,
            RecipeCategory.BUILDING_BLOCKS, ModBlocks.REFORGED_BLOCK);

        offerSmelting(exporter, REFORGED_ITEM_LIST, 
            RecipeCategory.MISC, ModItems.REFORGED_ITEM, 0.7f, 200, "reforged_item");
        
        offerBlasting(exporter, REFORGED_ITEM_LIST, 
            RecipeCategory.MISC, ModItems.REFORGED_ITEM, 0.7f, 100, "reforged_item");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 3)
            .pattern("###")
            .input('#', Items.BEETROOT)
            .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
            .offerTo(exporter,new Identifier("sugar_from_beetroot"));
    }
}
