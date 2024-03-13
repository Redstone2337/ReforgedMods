package com.redstone233.spawn.reforged;

import com.redstone233.spawn.reforged.datagen.ModBlockTagProvider;
import com.redstone233.spawn.reforged.datagen.ModItemTagProvider;
import com.redstone233.spawn.reforged.datagen.ModLootTablesProvider;
import com.redstone233.spawn.reforged.datagen.ModModlesProvider;
import com.redstone233.spawn.reforged.datagen.ModRecipesProvider;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ReforgeSpawnModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModlesProvider::new);
		pack.addProvider(ModLootTablesProvider::new);
		pack.addProvider(ModRecipesProvider::new);
	}
}
