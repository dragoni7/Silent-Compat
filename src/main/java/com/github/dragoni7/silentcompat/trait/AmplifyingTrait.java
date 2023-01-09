package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class AmplifyingTrait extends SimpleTrait {
	
	public static final Serializer<AmplifyingTrait> SERIALIZER = new Serializer<AmplifyingTrait>(new ResourceLocation(SilentCompat.MODID, "amplifying"), AmplifyingTrait::new);

	public AmplifyingTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Getting a kill has a chance to grant the amplified effect. Requires full set");
        return ret;
    }
}
