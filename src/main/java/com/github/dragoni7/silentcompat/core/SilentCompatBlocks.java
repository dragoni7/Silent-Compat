package com.github.dragoni7.silentcompat.core;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SilentCompatBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SilentCompat.MODID);
}
