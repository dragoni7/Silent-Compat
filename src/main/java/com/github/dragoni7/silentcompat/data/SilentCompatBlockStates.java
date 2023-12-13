package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.*;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SilentCompatBlockStates extends BlockStateProvider {

	public SilentCompatBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, SilentCompat.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			simpleBlock(set.block.get());
		}
		
		simpleBlock(MaterialRegistry.ARCMETAL_ORE.get());
		simpleBlock(MaterialRegistry.VOIDMETAL_ORE.get());
		simpleBlock(MaterialRegistry.SOLARMETAL_ORE.get());
		simpleBlock(MaterialRegistry.PLASTEEL_ORE.get());
	}

}
