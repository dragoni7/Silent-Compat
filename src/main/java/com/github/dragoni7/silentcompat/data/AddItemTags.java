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
		tag(SilentCompatItemTags.RAW_PLASTEEL).add(SilentCompatItems.RAW_PLASTEEL.get());
		
		tag(SilentCompatItemTags.OUTBACK_LEATHER).add(SilentCompatItems.OUTBACK_LEATHER.get());
		
		// Other mod's items:
		
		tag(SilentCompatItemTags.BEE_STINGER).addOptional(new ResourceLocation("the_bumblezone:bee_stinger"));
		tag(SilentCompatItemTags.BLAST_PROOF_PLATING).addOptional(new ResourceLocation("savage_and_ravage:blast_proof_plating"));
		tag(SilentCompatItemTags.SKREECHER_SOUL).addOptional(new ResourceLocation("alexsmobs:skreecher_soul"));
		tag(SilentCompatItemTags.CAPSID).addOptional(new ResourceLocation("alexsmobs:capsid"));
		tag(SilentCompatItemTags.ALPHA_YETI_FUR).addOptional(new ResourceLocation("twilightforest:alpha_yeti_fur"));
		tag(SilentCompatItemTags.CLOTH).addOptional(new ResourceLocation("majruszsdifficulty:cloth"));
		tag(SilentCompatItemTags.CRYPTIC_END_ROD).addOptional(new ResourceLocation("byg:cryptic_end_rod"));
		tag(SilentCompatItemTags.DRAGON_SCALE).addOptional(new ResourceLocation("quark:dragon_scale"));
		tag(SilentCompatItemTags.ELASTIC_TENDON).addOptional(new ResourceLocation("alexsmobs:elastic_tendon"));
		tag(SilentCompatItemTags.EMU_FEATHER).addOptional(new ResourceLocation("alexsmobs:emu_feather"));
		tag(SilentCompatItemTags.FARSEER_ARM).addOptional(new ResourceLocation("alexsmobs:farseer_arm"));
		tag(SilentCompatItemTags.FORTUNES_FAVOR).addOptional(new ResourceLocation("meetyourfight:fortunes_favor"));
		tag(SilentCompatItemTags.HONEY_CRYSTAL).addOptional(new ResourceLocation("the_bumblezone:honey_crystal_shards"));
		tag(SilentCompatItemTags.TENTACLE).addOptional(new ResourceLocation("alexsmobs:lost_tentacle"));
		tag(SilentCompatItemTags.MASTICATOR_SCALE).addOptional(new ResourceLocation("undergarden:masticator_scales"));
		tag(SilentCompatItemTags.MOSSY_TOOTH).addOptional(new ResourceLocation("meetyourfight:mossy_tooth"));
		tag(SilentCompatItemTags.NAGA_SCALE).addOptional(new ResourceLocation("twilightforest:naga_scale"));
		tag(SilentCompatItemTags.PHANTOPLASM).addOptional(new ResourceLocation("meetyourfight:phantoplasm"));
		tag(SilentCompatItemTags.ROADRUNNER).addOptional(new ResourceLocation("alexsmobs:roadrunner_feather"));
		tag(SilentCompatItemTags.ROCKY_SHELL).addOptional(new ResourceLocation("alexsmobs:rocky_shell"));
		tag(SilentCompatItemTags.SCULK_VINE).addOptional(new ResourceLocation("deeperdarker:sculk_vines"));
		tag(SilentCompatItemTags.SCULK_VINE).addOptional(new ResourceLocation("deeperdarker:sculk_tendrils"));
		tag(SilentCompatItemTags.SCULK_BONE).addOptional(new ResourceLocation("deeperdarker:sculk_bone"));
		tag(SilentCompatItemTags.SOUL_CRYSTAL).addOptional(new ResourceLocation("deeperdarker:soul_crystal"));
		tag(SilentCompatItemTags.TARANTUAL_HAWK).addOptional(new ResourceLocation("alexsmobs:tarantula_hawk_wing_fragment"));
		tag(SilentCompatItemTags.VOID_WORM).addOptional(new ResourceLocation("alexsmobs:void_worm_mandible"));
		tag(SilentCompatItemTags.ANDESITE_ALLOY).addOptional(new ResourceLocation("create:andesite_alloy"));
		tag(SilentCompatItemTags.CAST_IRON).addOptional(new ResourceLocation("createdeco:cast_iron_ingot"));
		tag(SilentCompatItemTags.SHARK_TOOTH).addOptional(new ResourceLocation("alexsmobs:shark_tooth"));
		tag(SilentCompatItemTags.SOUL_STEEL).addOptional(new ResourceLocation("spirit:soul_steel_ingot"));
		tag(SilentCompatItemTags.GAZELLE_HORN).addOptional(new ResourceLocation("alexsmobs:gazelle_horn"));
		tag(SilentCompatItemTags.CROCODILE).addOptional(new ResourceLocation("alexsmobs:crocodile_scute"));
		tag(SilentCompatItemTags.KOMODO_SPIT).addOptional(new ResourceLocation("alexsmobs:komodo_spit"));
		tag(SilentCompatItemTags.MIMICREAM).addOptional(new ResourceLocation("alexsmobs:mimicream"));
		tag(SilentCompatItemTags.CENTIPEDE).addOptional(new ResourceLocation("alexsmobs:centipede_leg"));
		tag(SilentCompatItemTags.STRADDLITE).addOptional(new ResourceLocation("alexsmobs:straddlite"));
		tag(SilentCompatItemTags.OOZE).addOptional(new ResourceLocation("dreamland:ooze_block"));
		tag(SilentCompatItemTags.MAGE_FIBER).addOptional(new ResourceLocation("ars_nouveau:magebloom_fiber"));
		tag(SilentCompatItemTags.BLAZE_FIBER).addOptional(new ResourceLocation("ars_nouveau:blaze_fiber"));
		tag(SilentCompatItemTags.END_FIBER).addOptional(new ResourceLocation("ars_nouveau:end_fiber"));
		tag(SilentCompatItemTags.GOO).addOptional(new ResourceLocation("undergarden:goo_block"));
		tag(SilentCompatItemTags.MOGMOSS).addOptional(new ResourceLocation("undergarden:mogmoss"));
		tag(SilentCompatItemTags.DITCHBULB).addOptional(new ResourceLocation("undergarden:ditchbulb_paste"));
		tag(SilentCompatItemTags.BRUTE_TUSK).addOptional(new ResourceLocation("undergarden:brute_tusk"));
		tag(SilentCompatItemTags.BEAR_HAIR).addOptional(new ResourceLocation("alexsmobs:bear_fur"));
		tag(SilentCompatItemTags.SERPENT_TOOTH).addOptional(new ResourceLocation("alexsmobs:bone_serpent_tooth"));
		tag(SilentCompatItemTags.BLOOD_SAC).addOptional(new ResourceLocation("alexsmobs:blood_sac"));
		tag(SilentCompatItemTags.HEMOLYMPH_SAC).addOptional(new ResourceLocation("alexsmobs:hemolymph_sac"));
		tag(SilentCompatItemTags.RACCOON_TAIL).addOptional(new ResourceLocation("alexsmobs:raccoon_tail"));
		tag(SilentCompatItemTags.ANTLER).addOptional(new ResourceLocation("alexsmobs:moose_antler"));
		tag(SilentCompatItemTags.SPIKED_SCUTE).addOptional(new ResourceLocation("alexsmobs:spiked_scute"));
		tag(SilentCompatItemTags.COCKROACH_WING).addOptional(new ResourceLocation("alexsmobs:cockroach_wing"));
		tag(SilentCompatItemTags.DROPBEAR_CLAW).addOptional(new ResourceLocation("alexsmobs:dropbear_claw"));
		tag(SilentCompatItemTags.WHALE_TOOTH).addOptional(new ResourceLocation("alexsmobs:cachalot_whale_tooth"));
		tag(SilentCompatItemTags.SERRATED_SHARK_TOOTH).addOptional(new ResourceLocation("alexsmobs:serrated_shark_tooth"));
		tag(SilentCompatItemTags.FROSTSTALKER_HORN).addOptional(new ResourceLocation("alexsmobs:froststalker_horn"));
		tag(SilentCompatItemTags.BISON_FUR).addOptional(new ResourceLocation("alexsmobs:bison_fur_block"));
		tag(SilentCompatItemTags.KANGAROO_HIDE).addOptional(new ResourceLocation("alexsmobs:kangaroo_hide"));
		tag(SilentCompatItemTags.FISH_BONES).addOptional(new ResourceLocation("alexsmobs:fish_bones"));
		tag(SilentCompatItemTags.ABJURATION_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:abjuration_essence"));
		tag(SilentCompatItemTags.CONJURATION_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:conjuration_essence"));
		tag(SilentCompatItemTags.EARTH_ESSENCE).addOptional(new ResourceLocation("ars_nouveau:earth_essence"));
		tag(SilentCompatItemTags.ROTTEN_FLESH).add(Items.ROTTEN_FLESH);
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

