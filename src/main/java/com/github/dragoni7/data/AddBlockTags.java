package com.github.dragoni7.data;

import com.github.dragoni7.SilentCompat;
import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;

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
		addMaterialTags(MaterialRegistry.NIGHTIRON);
	}
	
	private void addMaterialTags(MaterialSet set) {
		tag(Tags.Blocks.STORAGE_BLOCKS).add(set.block.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(set.block.get());
		tag(BlockTags.NEEDS_IRON_TOOL).add(set.block.get());
		tag(set.blockTag).add(set.block.get());
	}
}
