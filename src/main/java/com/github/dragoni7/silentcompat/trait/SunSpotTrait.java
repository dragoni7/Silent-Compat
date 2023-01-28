package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class SunSpotTrait extends SimpleTrait {
	
	public static final Serializer<SunSpotTrait> SERIALIZER = new Serializer<SunSpotTrait>(new ResourceLocation(SilentCompat.MODID, "sunspot"), SunSpotTrait::new);

	public SunSpotTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Consumes restoration. Standing on fire puts it out, healing a chunk of health and granting strength.");
        return ret;
    }

}
