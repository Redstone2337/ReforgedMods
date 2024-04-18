package com.redstone233.spawn.reforged.enchantments;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {


    public static final Enchantment VAMPRICM_ENCHANTMENT = 
        registerModEnchantments("vampiricm",
            new VampiricmEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON,
                new EquipmentSlot[] {
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND
                }
            )
        );

    public static final Enchantment FROZEN = 
        registerModEnchantments("frozen",
            new FrozenEnchantment(Enchantment.Rarity.COMMON,EnchantmentTarget.WEAPON,
                new EquipmentSlot[] {
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND
                }
            )
        );

    public static final Enchantment SPEED = 
        registerModEnchantments("speed", 
            new SpeedEnchantments(Enchantment.Rarity.UNCOMMON,EnchantmentTarget.WEAPON,
                new EquipmentSlot[] {
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND
                }
            )
        );

    
    public static final Enchantment CURSE_SPEED = 
        registerModEnchantments("curse_speed", 
            new CurseSpeedEnchantment(Enchantment.Rarity.VERY_RARE,EnchantmentTarget.WEAPON,
                new EquipmentSlot[] {
                    EquipmentSlot.MAINHAND,
                    EquipmentSlot.OFFHAND
                }
            )
        );

    private static Enchantment registerModEnchantments(String name,Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, 
            new Identifier(ReforgeSpawnMod.MOD_ID, name),enchantment);
    }

    public static void registerModEnchantments() {
        
    }
}
