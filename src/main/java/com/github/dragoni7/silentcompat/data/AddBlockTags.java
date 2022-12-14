package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddBlockTags extends BlockTagsProvider {
	
	public AddBlockTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, SilentCompat.MODID, helper);
	}
	
	protected void addTags() {
		/*addMaterialTags(MaterialRegistry.MIDNIGHTIRON);
		addMaterialTags(MaterialRegistry.BUNNYSTEEL);
		addMaterialTags(MaterialRegistry.DARKCHOCOLATE);
		addMaterialTags(MaterialRegistry.SCULKALLOY);
		addMaterialTags(MaterialRegistry.CAPSID_ALLOY);
		addMaterialTags(MaterialRegistry.PLASTEEL);
		addMaterialTags(MaterialRegistry.SOURCE_STEEL);*/
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			addMaterialTags(set);
		}
	}
	
	private void addMaterialTags(MaterialSet set) {
		tag(Tags.Blocks.STORAGE_BLOCKS).add(set.block.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(set.block.get());
		tag(BlockTags.NEEDS_IRON_TOOL).add(set.block.get());
		tag(set.blockTag).add(set.block.get());
	}
}
