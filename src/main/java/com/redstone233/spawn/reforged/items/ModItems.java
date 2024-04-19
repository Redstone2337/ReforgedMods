package com.redstone233.spawn.reforged.items;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;
import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.items.custom.FrozenArrow;
import com.redstone233.spawn.reforged.items.custom.FrozenBow;
import com.redstone233.spawn.reforged.items.custom.FrozenSword;
import com.redstone233.spawn.reforged.items.custom.ModArmorItem;
import com.redstone233.spawn.reforged.items.custom.Prospectetor;
import com.redstone233.spawn.reforged.items.custom.VampiricSword;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item REFORGED_ITEM = registerItems("reforged_item", 
        new Item(new FabricItemSettings().maxCount(64)));

    public static final Item ICE_DRAGON_SCALES = registerItems("ice_dragon_scales", 
        new Item(new FabricItemSettings().maxCount(64)));

    public static final Item FOGOTTEN_CHAKRAM = registerItems("forgotten_chakram", 
        new Item(new FabricItemSettings().maxCount(64)));
    
    public static final Item ICE_DRAGON_KEY = registerItems("ice_dragon_key", 
        new Item(new FabricItemSettings().maxCount(64)));

    public static final Item REFORGED_AMETHYST = registerItems("reforged_amethyst", 
        new Item(new FabricItemSettings().maxCount(64)));

    public static final Item PROSPECTOR = registerItems("prospector", 
        new Prospectetor(new FabricItemSettings().maxDamage(1000)));

    //public static final Item NEXUS_SWORLD = registerItems("nexus_sword", 
        //new Prospectetor(new FabricItemSettings().maxDamage(3000)));

    public static final Item ICE_DRAGON_BOW = registerItems("light_bow", 
        new FrozenBow(new FabricItemSettings().maxDamage(12000)));

    public static final Item REFORGED_PICKAXE = registerItems("reforged_pickaxe", 
        new PickaxeItem(ModToolMaterial.REFORGED_ITEM, 5, 2.3f, 
            new FabricItemSettings().maxDamage(20000)));
    
    public static final Item REFORGED_AXE = registerItems("reforged_axe", 
        new AxeItem(ModToolMaterial.REFORGED_ITEM, 15, -3.5f, 
            new FabricItemSettings().maxDamage(25000)));
            
    public static final Item COMBO_AXE = registerItems("combo_axe", 
        new AxeItem(ModToolMaterial.REFORGED_ITEM, 15, 5.5f, 
            new FabricItemSettings().maxDamage(50000)));
            
    public static final Item SECOND_AXE = registerItems("second_axe", 
        new AxeItem(ModToolMaterial.REFORGED_ITEM, 500, -3.5f, 
            new FabricItemSettings().maxDamage(55000)));

    public static final Item REFORGED_SHOVRL = registerItems("reforged_shovel", 
        new ShovelItem(ModToolMaterial.REFORGED_ITEM, 3, 2.7f, 
            new FabricItemSettings().maxDamage(30000)));    

    public static final Item REFORGED_SWORD = registerItems("reforged_sword", 
        new SwordItem(ModToolMaterial.REFORGED_ITEM, 10, 3.6f, 
            new FabricItemSettings().maxDamage(35000)));

    public static final Item NEXUS_SWORD = registerItems("nexus_sword", 
        new VampiricSword(ModToolMaterial.REFORGED_ITEM, 20, 4.0f, 
            new FabricItemSettings().maxDamage(30000)));

    public static final Item ICE_DRAGON_SWORD = registerItems("ice_dragon_sword", 
        new FrozenSword(ModToolMaterial.REFORGED_ITEM, 10, 3.6f, 
            new FabricItemSettings().maxDamage(20000)));
    
    public static final Item REFORGED_AMETHYST_SWORD = registerItems("reforged_amethyst_sword", 
        new SwordItem(ModToolMaterial.REFORGED_AMETHYST, 11, 3.0f, 
            new FabricItemSettings().maxDamage(23002)));

    public static final Item REFORGED_HOE = registerItems("reforged_hoe", 
        new HoeItem(ModToolMaterial.REFORGED_ITEM, 6, 2.6f, 
            new FabricItemSettings().maxDamage(40000)));

    public static final Item REFORGED_HELMET = registerItems("reforged_helmets",
        new ModArmorItem(ModArmorMaterial.REFORGED_ITEM, ArmorItem.Type.HELMET, 
            new FabricItemSettings().maxDamage(33000)));

    public static final Item REFORGED_CHESTPLATE = registerItems("reforged_chestplates",
        new ArmorItem(ModArmorMaterial.REFORGED_ITEM, ArmorItem.Type.CHESTPLATE, 
            new FabricItemSettings().maxDamage(32000)));

    public static final Item REFORGED_LEGGINGS = registerItems("reforged_leggings",
        new ArmorItem(ModArmorMaterial.REFORGED_ITEM, ArmorItem.Type.LEGGINGS, 
            new FabricItemSettings().maxDamage(34000)));

    public static final Item REFORGED_BOOTS = registerItems("reforged_boots",
        new ArmorItem(ModArmorMaterial.REFORGED_ITEM, ArmorItem.Type.BOOTS, 
            new FabricItemSettings().maxDamage(36000)));

    public static final Item REFORGED_FOOD = registerItems("reforged_food",
        new Item(new FabricItemSettings().food(ModFoodComponents.REFORGED_FOOD).maxCount(64)));

    public static final Item REFORGED_APPLE = registerItems("reforged_apple",
        new Item(new FabricItemSettings().food(ModFoodComponents.REFORGED_APPLE).maxCount(64)));

     public static final Item REFORGED_APPLE_SEEDS = registerItems("reforged_apple_seeds",
        new AliasedBlockItem(ModBlocks.REFORGED_APPLE_CROP, new FabricItemSettings().maxCount(64)));

    public static final Item REFORGED_COAL = registerItems("reforged_coal", 
        new Item(new FabricItemSettings().maxCount(64)));

    public static final Item ICE_DRAGON_ARROW = registerItems("light_arrow",
        new FrozenArrow(new FabricItemSettings().maxCount(64)));

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
