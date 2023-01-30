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
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			addMaterialTags(set);
		}
		
		tag(Tags.Blocks.ORES).add(MaterialRegistry.ARCMETAL_ORE.get()).add(MaterialRegistry.VOIDMETAL_ORE.get()).add(MaterialRegistry.SOLARMETAL_ORE.get()).add(MaterialRegistry.PLASTEEL_ORE.get());
		tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(MaterialRegistry.VOIDMETAL_ORE.get()).add(MaterialRegistry.PLASTEEL_ORE.get());
		tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(MaterialRegistry.ARCMETAL_ORE.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(MaterialRegistry.ARCMETAL_ORE.get()).add(MaterialRegistry.VOIDMETAL_ORE.get()).add(MaterialRegistry.SOLARMETAL_ORE.get()).add(MaterialRegistry.PLASTEEL_ORE.get());
		tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(MaterialRegistry.ARCMETAL_ORE.get()).add(MaterialRegistry.VOIDMETAL_ORE.get()).add(MaterialRegistry.PLASTEEL_ORE.get()).add(MaterialRegistry.SOLARMETAL_ORE.get());
		
		tag(SilentCompatTags.SOLARMETAL_ORES).add(MaterialRegistry.SOLARMETAL_ORE.get());
		tag(SilentCompatTags.ARCMETAL_ORES).add(MaterialRegistry.ARCMETAL_ORE.get());
		tag(SilentCompatTags.VOIDMETAL_ORES).add(MaterialRegistry.VOIDMETAL_ORE.get());
		tag(SilentCompatTags.PLASTEEL_ORES).add(MaterialRegistry.PLASTEEL_ORE.get());
		
	}
	
	private void addMaterialTags(MaterialSet set) {
		tag(Tags.Blocks.STORAGE_BLOCKS).add(set.block.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(set.block.get());
		tag(BlockTags.NEEDS_IRON_TOOL).add(set.block.get());
		tag(set.blockTag).add(set.block.get());
	}
}
