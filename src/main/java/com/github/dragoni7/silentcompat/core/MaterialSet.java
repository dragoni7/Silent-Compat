package com.github.dragoni7.silentcompat.core;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;

public class MaterialSet {
	public String name;
	public final TagKey<Item> ingotTag;
	public final TagKey<Item> nuggetTag;
	public final TagKey<Item> blockItemTag;
	public final TagKey<Block> blockTag;
	
	public RegistryObject<Item> ingot;
	public RegistryObject<Item> nugget;
	public RegistryObject<Item> blockItem;
	public RegistryObject<Block> block;
	
	public MaterialSet(String name, MaterialColor color) {
		this.name = name;
		
		this.ingotTag = ItemTags.create(new ResourceLocation("forge", "ingots/" + name));
		this.nuggetTag = ItemTags.create(new ResourceLocation("forge", "nuggets/" + name));
		this.blockItemTag = ItemTags.create(new ResourceLocation("forge", "storage_blocks/" + name));
		this.blockTag = BlockTags.create(new ResourceLocation("forge", "storage_blocks/" + name));
		
		block = SilentCompatBlocks.BLOCKS.register(name + "_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).color(color)));
		ingot = SilentCompatItems.ITEMS.register(name + "_ingot", ()-> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));
		nugget = SilentCompatItems.ITEMS.register(name + "_nugget", ()-> new Item(new Item.Properties().tab(SilentCompat.SilentCompatTab)));
		blockItem = SilentCompatItems.ITEMS.register(name + "_block", ()-> new BlockItem(this.block.get(), new Item.Properties().tab(SilentCompat.SilentCompatTab)));
		
	}
}
