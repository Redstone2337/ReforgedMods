package com.redstone233.spawn.reforged.trsm;

import com.redstone233.spawn.reforged.ReforgeSpawnMod;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PROSPECTOR_LIST = createTag("prospector_list");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ReforgeSpawnMod.MOD_ID, name));
        }
    }

    public static class Items {
    
    }
    
}
