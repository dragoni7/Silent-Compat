package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class DevouringTrait extends SimpleTrait {
	
	public static final Serializer<DevouringTrait> SERIALIZER = new Serializer<DevouringTrait>(new ResourceLocation(SilentCompat.MODID, "devouring"), DevouringTrait::new);

	public DevouringTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Getting a kill has a chance to grant the devouring effect. Requires full set");
        return ret;
    }
}
