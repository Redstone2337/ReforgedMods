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

    @SuppressWarnings("unused")
    private static final ItemGroup SUNDRY_GROUP = 
        Registry.register(Registries.ITEM_GROUP, 
        new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_sundry_group"), 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.REFORGED_ITEM))
                .displayName(Text.translatable("itemGroup.trsm_sundry_group"))
                .entries((context, entries) -> {
                    entries.add(ModItems.REFORGED_ITEM);
                    entries.add(ModItems.REFORGED_FOOD);
                    entries.add(ModItems.PROSPECTOR);
                    entries.add(ModItems.REFORGED_COAL);
                    entries.add(ModItems.ICE_DRAGON_ARROW);
                    entries.add(ModItems.COMBO_INGOT);
                    entries.add(ModItems.SECKILL_INGOT);

                    // entries.add(ModItems.REFORGED_SWORD);
                    // entries.add(ModItems.REFORGED_3D_SWORD);
                    // entries.add(ModItems.NEXUS_SWORD);
                    // entries.add(ModItems.ICE_DRAGON_SWORD);
                    // entries.add(ModItems.REFORGED_AMETHYST_SWORD);
                    // entries.add(ModItems.REFORGED_PICKAXE);
                    // entries.add(ModItems.REFORGED_AXE);
                    // entries.add(ModItems.COMBO_AXE);
                    // entries.add(ModItems.SECOND_AXE);
                    // entries.add(ModItems.REFORGED_SHOVRL);
                    // entries.add(ModItems.REFORGED_HOE);
                    // entries.add(ModItems.ICE_DRAGON_BOW);
                    // entries.add(ModItems.ENDER_BOW);

                    // entries.add(ModItems.REFORGED_HELMET);
                    // entries.add(ModItems.REFORGED_CHESTPLATE);
                    // entries.add(ModItems.REFORGED_LEGGINGS);
                    // entries.add(ModItems.REFORGED_BOOTS);
                    entries.add(ModItems.REFORGED_APPLE_SEEDS);
                    entries.add(ModItems.REFORGED_APPLE);
                    entries.add(ModItems.ICE_DRAGON_SCALES);
                    entries.add(ModItems.ICE_DRAGON_KEY);
                    entries.add(ModItems.REFORGED_AMETHYST);
                    entries.add(ModItems.FOGOTTEN_CHAKRAM);
                })
                .build());

    @SuppressWarnings("unused")
    private static final ItemGroup TOOL_GROUP = 
        Registry.register(Registries.ITEM_GROUP, 
            new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_tool_group"), 
                FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.REFORGED_PICKAXE))
                    .displayName(Text.translatable("itemGroup.trsm_tool_group"))
                    .entries((context, entries) -> {
                        
                        // entries.add(ModItems.REFORGED_SWORD);
                        // entries.add(ModItems.REFORGED_3D_SWORD);
                        // entries.add(ModItems.NEXUS_SWORD);
                        // entries.add(ModItems.ICE_DRAGON_SWORD);
                        // entries.add(ModItems.REFORGED_AMETHYST_SWORD);
                        entries.add(ModItems.REFORGED_PICKAXE);
                        entries.add(ModItems.REFORGED_AXE);
                        entries.add(ModItems.COMBO_AXE);
                        entries.add(ModItems.SECOND_AXE);
                        entries.add(ModItems.ICE_AXE);
                        entries.add(ModItems.NEXUS_AXE);
                        entries.add(ModItems.REFORGED_SHOVRL);
                        entries.add(ModItems.REFORGED_HOE);
                        // entries.add(ModItems.ICE_DRAGON_BOW);
                        // entries.add(ModItems.ENDER_BOW);
        
                        // entries.add(ModItems.REFORGED_HELMET);
                        // entries.add(ModItems.REFORGED_CHESTPLATE);
                        // entries.add(ModItems.REFORGED_LEGGINGS);
                        // entries.add(ModItems.REFORGED_BOOTS);
                        // entries.add(ModItems.REFORGED_APPLE_SEEDS);
                        // entries.add(ModItems.REFORGED_APPLE);
                        // entries.add(ModItems.ICE_DRAGON_SCALES);
                        // entries.add(ModItems.ICE_DRAGON_KEY);
                        // entries.add(ModItems.REFORGED_AMETHYST);
                        // entries.add(ModItems.FOGOTTEN_CHAKRAM);
                    })
                    .build());
    @SuppressWarnings("unused")
    private static final ItemGroup WEAPON_GROUP = 
        Registry.register(Registries.ITEM_GROUP, 
            new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_weapon_group"), 
                FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.REFORGED_SWORD))
                    .displayName(Text.translatable("itemGroup.trsm_weapon_group"))
                    .entries((context, entries) -> {          
                        entries.add(ModItems.REFORGED_SWORD);
                        entries.add(ModItems.REFORGED_3D_SWORD);
                        entries.add(ModItems.NEXUS_SWORD);
                        entries.add(ModItems.ICE_DRAGON_SWORD);
                        //entries.add(ModItems.YUANCI_SWORD);
                        //entries.add(ModItems.YUANKAN_SWORD);
                        entries.add(ModItems.REFORGED_AMETHYST_SWORD);
                        entries.add(ModItems.ICE_SICKLE);
                        //entries.add(ModItems.ERROR_STAFF);
                        entries.add(ModItems.REFORGED_PICKAXE);
                        entries.add(ModItems.REFORGED_AXE);
                        entries.add(ModItems.COMBO_AXE);
                        entries.add(ModItems.SECOND_AXE);
                        entries.add(ModItems.ICE_AXE);
                        entries.add(ModItems.NEXUS_AXE);
                        entries.add(ModItems.AMETHYST_KNIFE);
                        entries.add(ModItems.YUANCI_SWORD);
                        entries.add(ModItems.YUANKAN_SWORD);
                        // entries.add(ModItems.REFORGED_SHOVRL);
                        // entries.add(ModItems.REFORGED_HOE);
                        entries.add(ModItems.ICE_DRAGON_BOW);
                        entries.add(ModItems.ENDER_BOW);
        
                        // entries.add(ModItems.REFORGED_HELMET);
                        // entries.add(ModItems.REFORGED_CHESTPLATE);
                        // entries.add(ModItems.REFORGED_LEGGINGS);
                        // entries.add(ModItems.REFORGED_BOOTS);
                        // entries.add(ModItems.REFORGED_APPLE_SEEDS);
                        // entries.add(ModItems.REFORGED_APPLE);
                        // entries.add(ModItems.ICE_DRAGON_SCALES);
                        // entries.add(ModItems.ICE_DRAGON_KEY);
                        // entries.add(ModItems.REFORGED_AMETHYST);
                        // entries.add(ModItems.FOGOTTEN_CHAKRAM);
                    })
                    .build());



    @SuppressWarnings("unused")
    private static final ItemGroup ARMOR_GROUP = 
        Registry.register(Registries.ITEM_GROUP, 
        new Identifier(ReforgeSpawnMod.MOD_ID, "trsm_armor_group"), 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.REFORGED_CHESTPLATE))
                .displayName(Text.translatable("itemGroup.trsm_armor_group"))
                .entries((context, entries) -> {
                    // entries.add(ModItems.REFORGED_ITEM);
                    // entries.add(ModItems.REFORGED_FOOD);
                    // entries.add(ModItems.PROSPECTOR);
                    // entries.add(ModItems.REFORGED_COAL);
                    // entries.add(ModItems.ICE_DRAGON_ARROW);

                    // entries.add(ModItems.REFORGED_SWORD);
                    // entries.add(ModItems.REFORGED_3D_SWORD);
                    // entries.add(ModItems.NEXUS_SWORD);
                    // entries.add(ModItems.ICE_DRAGON_SWORD);
                    // entries.add(ModItems.REFORGED_AMETHYST_SWORD);
                    // entries.add(ModItems.REFORGED_PICKAXE);
                    // entries.add(ModItems.REFORGED_AXE);
                    // entries.add(ModItems.COMBO_AXE);
                    // entries.add(ModItems.SECOND_AXE);
                    // entries.add(ModItems.REFORGED_SHOVRL);
                    // entries.add(ModItems.REFORGED_HOE);
                    // entries.add(ModItems.ICE_DRAGON_BOW);
                    // entries.add(ModItems.ENDER_BOW);

                    entries.add(ModItems.REFORGED_HELMET);
                    entries.add(ModItems.REFORGED_CHESTPLATE);
                    entries.add(ModItems.REFORGED_LEGGINGS);
                    entries.add(ModItems.REFORGED_BOOTS);
                    // entries.add(ModItems.REFORGED_APPLE_SEEDS);
                    // entries.add(ModItems.REFORGED_APPLE);
                    // entries.add(ModItems.ICE_DRAGON_SCALES);
                    // entries.add(ModItems.ICE_DRAGON_KEY);
                    // entries.add(ModItems.REFORGED_AMETHYST);
                    // entries.add(ModItems.FOGOTTEN_CHAKRAM);
                })
                .build());

                

    public static void registerModItemGroup() {
        
    }
}

// C:\Users\Redstone\.gradle\wrapper\dists\gradle-8.6-bin\afr5mpiioh2wthjmwnkmdsd5w\gradle-8.6
