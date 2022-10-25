package com.github.dragoni7.data;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddItemTags extends ItemTagsProvider {
	
	public AddItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, SilentCompat.MODID, helper);
	}

	@Override
	protected void addTags() {
		
		addMaterialTags(MaterialRegistry.MIDNIGHTIRON);
		addMaterialTags(MaterialRegistry.BUNNYSTEEL);
		addMaterialTags(MaterialRegistry.DARKCHOCOLATE);
		addMaterialTags(MaterialRegistry.SCULKALLOY);
		addMaterialTags(MaterialRegistry.CAPSID_ALLOY);
		
		// Other mod's items:
		
		tag(ModItemTags.BEE_STINGER).addOptional(new ResourceLocation("the_bumblezone:bee_stinger"));
		tag(ModItemTags.BLAST_PROOF_PLATING).addOptional(new ResourceLocation("savage_and_ravage:blast_proof_plating"));
	}
	
	private void addMaterialTags(MaterialSet set) {
		tag(Tags.Items.INGOTS).add(set.ingot.get());
		tag(Tags.Items.NUGGETS).add(set.nugget.get());
		tag(Tags.Items.STORAGE_BLOCKS).add(set.blockItem.get());
		
		tag(set.ingotTag).add(set.ingot.get());
		tag(set.nuggetTag).add(set.nugget.get());
		tag(set.blockItemTag).add(set.blockItem.get());
	}
}
