package com.redstone233.spawn.reforged.world.gen;

import com.redstone233.spawn.reforged.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.REFORGED_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures._PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.REFORGED_ORE_PLACED_KEY);
    }
}
