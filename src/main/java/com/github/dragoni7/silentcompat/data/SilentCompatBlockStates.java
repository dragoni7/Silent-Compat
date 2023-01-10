package com.github.dragoni7.silentcompat.data;

import java.util.ArrayList;

import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SilentCompatBlockStates extends BlockStateProvider {

	public SilentCompatBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		/*ArrayList<Block> blocks = new ArrayList<Block>();
		blocks.add(MaterialRegistry.MIDNIGHTIRON.block.get());
		blocks.add(MaterialRegistry.BUNNYSTEEL.block.get());
		blocks.add(MaterialRegistry.DARKCHOCOLATE.block.get());
		blocks.add(MaterialRegistry.SCULKALLOY.block.get());
		blocks.add(MaterialRegistry.CAPSID_ALLOY.block.get());
		blocks.add(MaterialRegistry.PLASTEEL.block.get());
		blocks.add(MaterialRegistry.SOURCE_STEEL.block.get());
		
		for(Block b : blocks) {
			simpleBlock(b);
		}*/
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			simpleBlock(set.block.get());
		}
	}

}
