package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.gear.trait.SimpleTrait.Serializer;

public class AdrenalineTrait extends SimpleTrait {

	public static final Serializer<AdrenalineTrait> SERIALIZER = new Serializer<AdrenalineTrait>(new ResourceLocation(SilentCompat.MODID, "adrenaline"), AdrenalineTrait::new);

	public AdrenalineTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Applies adrenaline rush when low health.");
        return ret;
    }
}
