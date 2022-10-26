package com.github.dragoni7.data;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.MaterialSet;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
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
		tag(ModItemTags.SKREECHER_SOUL).addOptional(new ResourceLocation("alexsmobs:skreecher_soul"));
		tag(ModItemTags.CAPSID).addOptional(new ResourceLocation("alexsmobs:capsid"));
		tag(ModItemTags.ALPHA_YETI_FUR).addOptional(new ResourceLocation("twilightforest:alpha_yeti_fur"));
		tag(ModItemTags.CLOTH).addOptional(new ResourceLocation("majruszsdifficulty:cloth"));
		tag(ModItemTags.CRYPTIC_END_ROD).addOptional(new ResourceLocation("byg:cryptic_end_rod"));
		tag(ModItemTags.DRAGON_SCALE).addOptional(new ResourceLocation("quark:dragon_scale"));
		tag(ModItemTags.ELASTIC_TENDON).addOptional(new ResourceLocation("alexsmobs:elastic_tendon"));
		tag(ModItemTags.EMU_FEATHER).addOptional(new ResourceLocation("alexsmobs:emu_feather"));
		tag(ModItemTags.FARSEER_ARM).addOptional(new ResourceLocation("alexsmobs:farseer_arm"));
		tag(ModItemTags.FORTUNES_FAVOR).addOptional(new ResourceLocation("meetyourfight:fortunes_favor"));
		tag(ModItemTags.HONEY_CRYSTAL).addOptional(new ResourceLocation("the_bumblezone:honey_crystal_shards"));
		tag(ModItemTags.TENTACLE).addOptional(new ResourceLocation("alexsmobs:lost_tentacle"));
		tag(ModItemTags.MASTICATOR_SCALE).addOptional(new ResourceLocation("undergarden:masticator_scales"));
		tag(ModItemTags.MOSSY_TOOTH).addOptional(new ResourceLocation("meetyourfight:mossy_tooth"));
		tag(ModItemTags.NAGA_SCALE).addOptional(new ResourceLocation("twilightforest:naga_scale"));
		tag(ModItemTags.PHANTOPLASM).addOptional(new ResourceLocation("meetyourfight:phantoplasm"));
		tag(ModItemTags.ROADRUNNER).addOptional(new ResourceLocation("alexsmobs:roadrunner_feather"));
		tag(ModItemTags.ROCKY_SHELL).addOptional(new ResourceLocation("alexsmobs:rocky_shell"));
		tag(ModItemTags.SCULK_VINE).addOptional(new ResourceLocation("deeperdarker:sculk_vines"));
		tag(ModItemTags.TARANTUAL_HAWK).addOptional(new ResourceLocation("alexsmobs:tarantula_hawk_wing"));
		tag(ModItemTags.VOID_WORM).addOptional(new ResourceLocation("alexsmobs:void_worm_mandible"));
		tag(ModItemTags.ANDESITE_ALLOY).addOptional(new ResourceLocation("create:andesite_alloy"));
		tag(ModItemTags.CAST_IRON).addOptional(new ResourceLocation("createdeco:cast_iron_ingot"));
		tag(ModItemTags.SHARK_TOOTH).addOptional(new ResourceLocation("alexsmobs:shark_tooth"));
		tag(ModItemTags.SOUL_STEEL).addOptional(new ResourceLocation("spirit:soul_steel_ingot"));
		tag(ModItemTags.GAZELLE_HORN).addOptional(new ResourceLocation("alexsmobs:gazelle_horn"));
		tag(ModItemTags.CROCODILE).addOptional(new ResourceLocation("alexsmobs:crocodile_scute"));
		tag(ModItemTags.KOMODO_SPIT).addOptional(new ResourceLocation("alexsmobs:komodo_spit"));
		tag(ModItemTags.MIMICREAM).addOptional(new ResourceLocation("alexsmobs:mimicream"));
		tag(ModItemTags.CENTIPEDE).addOptional(new ResourceLocation("alexsmobs:centipede_leg"));
		tag(ModItemTags.STRADDLITE).addOptional(new ResourceLocation("alexsmobs:straddlite"));
		tag(ModItemTags.ROTTEN_FLESH).add(Items.ROTTEN_FLESH);
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
