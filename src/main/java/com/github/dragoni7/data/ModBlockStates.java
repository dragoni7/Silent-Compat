package com.github.dragoni7.data;

import java.util.ArrayList;

import com.github.dragoni7.core.MaterialRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider {

	public ModBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		ArrayList<Block> blocks = new ArrayList<Block>();
		blocks.add(MaterialRegistry.NIGHTIRON.block.get());
		
		for(Block b : blocks) {
			simpleBlock(b);
		}
	}

}
