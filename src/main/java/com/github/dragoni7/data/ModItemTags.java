package com.github.dragoni7.data;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

	public static final TagKey<Item> BEE_STINGER = createTag("bee_stinger");
	public static final TagKey<Item> BLAST_PROOF_PLATING = createTag("blast_proof_plating");
	
	private static TagKey<Item> createTag(String name) {
		return ItemTags.create(new ResourceLocation(SilentCompat.MODID, name));
	}
}
