package com.github.dragoni7.silentcompat.data;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.MaterialSet;
import com.github.dragoni7.silentcompat.core.SilentCompatItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
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
		addMaterialTags(MaterialRegistry.PLASTEEL);
		addMaterialTags(MaterialRegistry.SOURCE_STEEL);
		
		tag(Tags.Items.RAW_MATERIALS).add(SilentCompatItems.RAW_PLASTEEL.get());
		tag(ModItemTags.RAW_PLASTEEL).add(SilentCompatItems.RAW_PLASTEEL.get());
		
		tag(ModItemTags.OUTBACK_LEATHER).add(SilentCompatItems.OUTBACK_LEATHER.get());
		
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
		tag(ModItemTags.SCULK_VINE).addOptional(new ResourceLocation("deeperdarker:sculk_tendrils"));
		tag(ModItemTags.SCULK_BONE).addOptional(new ResourceLocation("deeperdarker:sculk_bone"));
		tag(ModItemTags.SOUL_CRYSTAL).addOptional(new ResourceLocation("deeperdarker:soul_crystal"));
		tag(ModItemTags.TARANTUAL_HAWK).addOptional(new ResourceLocation("alexsmobs:tarantula_hawk_wing_fragment"));
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
		tag(ModItemTags.OOZE).addOptional(new ResourceLocation("dreamland:ooze_block"));
		tag(ModItemTags.MAGE_FIBER).addOptional(new ResourceLocation("ars_nouveau:magebloom_fiber"));
		tag(ModItemTags.BLAZE_FIBER).addOptional(new ResourceLocation("ars_nouveau:blaze_fiber"));
		tag(ModItemTags.END_FIBER).addOptional(new ResourceLocation("ars_nouveau:end_fiber"));
		tag(ModItemTags.GOO).addOptional(new ResourceLocation("undergarden:goo_block"));
		tag(ModItemTags.MOGMOSS).addOptional(new ResourceLocation("undergarden:mogmoss"));
		tag(ModItemTags.DITCHBULB).addOptional(new ResourceLocation("undergarden:ditchbulb_paste"));
		tag(ModItemTags.BRUTE_TUSK).addOptional(new ResourceLocation("undergarden:brute_tusk"));
		tag(ModItemTags.BEAR_HAIR).addOptional(new ResourceLocation("alexsmobs:bear_fur"));
		tag(ModItemTags.SERPENT_TOOTH).addOptional(new ResourceLocation("alexsmobs:bone_serpent_tooth"));
		tag(ModItemTags.BLOOD_SAC).addOptional(new ResourceLocation("alexsmobs:blood_sac"));
		tag(ModItemTags.HEMOLYMPH_SAC).addOptional(new ResourceLocation("alexsmobs:hemolymph_sac"));
		tag(ModItemTags.RACCOON_TAIL).addOptional(new ResourceLocation("alexsmobs:raccoon_tail"));
		tag(ModItemTags.ANTLER).addOptional(new ResourceLocation("alexsmobs:moose_antler"));
		tag(ModItemTags.SPIKED_SCUTE).addOptional(new ResourceLocation("alexsmobs:spiked_scute"));
		tag(ModItemTags.COCKROACH_WING).addOptional(new ResourceLocation("alexsmobs:cockroach_wing"));
		tag(ModItemTags.DROPBEAR_CLAW).addOptional(new ResourceLocation("alexsmobs:dropbear_claw"));
		tag(ModItemTags.WHALE_TOOTH).addOptional(new ResourceLocation("alexsmobs:cachalot_whale_tooth"));
		tag(ModItemTags.SERRATED_SHARK_TOOTH).addOptional(new ResourceLocation("alexsmobs:serrated_shark_tooth"));
		tag(ModItemTags.FROSTSTALKER_HORN).addOptional(new ResourceLocation("alexsmobs:froststalker_horn"));
		tag(ModItemTags.BISON_FUR).addOptional(new ResourceLocation("alexsmobs:bison_fur_block"));
		tag(ModItemTags.KANGAROO_HIDE).addOptional(new ResourceLocation("alexsmobs:kangaroo_hide"));
		tag(ModItemTags.FISH_BONES).addOptional(new ResourceLocation("alexsmobs:fish_bones"));
		tag(ModItemTags.ABJURATION_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:abjuration_essence"));
		tag(ModItemTags.CONJURATION_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:conjuration_essence"));
		tag(ModItemTags.EARTH_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:earth_essence"));
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

