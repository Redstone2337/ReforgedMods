package com.redstone233.spawn.reforged;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redstone233.spawn.reforged.block.ModBlockGroup;
import com.redstone233.spawn.reforged.block.ModBlocks;
import com.redstone233.spawn.reforged.items.ModItemGroup;
import com.redstone233.spawn.reforged.items.ModItems;
import com.redstone233.spawn.reforged.potions.ModPotions;
import com.redstone233.spawn.reforged.commands.ReforgedSpawnModCommands;
import com.redstone233.spawn.reforged.effects.ModEffects;
import com.redstone233.spawn.reforged.enchantments.ModEnchantments;
import com.redstone233.spawn.reforged.world.gen.ModWorldGeneration;

public class ReforgeSpawnMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "trsm";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();
		ModBlocks.registerModBlocks();
		ModBlockGroup.registerModBlockGroup();
		ModWorldGeneration.generateModWorldGen();
		ModEnchantments.registerModEnchantments();
		ModEffects.registerModEffects();
		ModPotions.registerModPotions();

		FuelRegistry.INSTANCE.add(ModItems.REFORGED_COAL, 2000);

		CommandRegistrationCallback.EVENT
			.register((dispatcher, registryAccess, environment) -> ReforgedSpawnModCommands.register(dispatcher)
		);
	}
}
