package com.redstone233.spawn.reforged.items;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.items.custom.Prospectetor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item REFORGED_ITEM = registerItems("reforged_item", 
        new Item(new FabricItemSettings()));
        
    public static final Item PROSPECTOR = registerItems("prospector", 
        new Prospectetor(new FabricItemSettings().maxDamage(64)));

    public static final Item REFORGED_PICKAXE = registerItems("reforged_pickaxe", 
        new PickaxeItem(ModToolMaterial.REFORGED_ITEM, 5, 2.3f, 
            new FabricItemSettings()));
    
    public static final Item REFORGED_AXE = registerItems("reforged_axe", 
        new AxeItem(ModToolMaterial.REFORGED_ITEM, 11, 5.2f, 
            new FabricItemSettings()));

    public static final Item REFORGED_SHOVRL = registerItems("reforged_shovel", 
        new ShovelItem(ModToolMaterial.REFORGED_ITEM, 3, 3.1f, 
            new FabricItemSettings()));    

    public static final Item REFORGED_SWORD = registerItems("reforged_sword", 
        new SwordItem(ModToolMaterial.REFORGED_ITEM, 10, 1.5f, 
            new FabricItemSettings()));

    public static final Item REFORGED_HOE = registerItems("reforged_hoe", 
        new HoeItem(ModToolMaterial.REFORGED_ITEM, 4, 3.1f, 
            new FabricItemSettings()));

    public static final Item REFORGED_FOOD = registerItems("reforged_food",
        new Item(new FabricItemSettings().food(ModFoodComponents.REFORGED_FOOD)));

    public static final Item REFORGED_COAL = registerItems("reforged_coal", 
    new Item(new FabricItemSettings()));

    private static void addItemsToIG(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(REFORGED_ITEM);
    }

    private static Item registerItems(String name,Item item) {
        return Registry.register(Registries.ITEM,
            new Identifier(ReforgeSpawnMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIG);
    }
}
