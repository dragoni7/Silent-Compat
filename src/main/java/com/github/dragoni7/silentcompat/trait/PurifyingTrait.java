package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class PurifyingTrait extends SimpleTrait {

	public static final Serializer<PurifyingTrait> SERIALIZER = new Serializer<PurifyingTrait>(
			new ResourceLocation(SilentCompat.MODID, "purifying"), PurifyingTrait::new);

	public PurifyingTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

	@Override
	public Collection<String> getExtraWikiLines() {
		Collection<String> ret = super.getExtraWikiLines();
		ret.add("Rare chance to remove harmful effects when hit. Requires full set");
		return ret;
	}
}
