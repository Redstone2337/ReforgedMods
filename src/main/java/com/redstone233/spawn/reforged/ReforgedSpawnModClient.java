package com.redstone233.spawn.reforged;

import com.redstone233.spawn.reforged.block.ModBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ReforgedSpawnModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.REFORGED_APPLE_CROP, RenderLayer.getCutout());
    }

}
