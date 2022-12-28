package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class FireReactTrait extends SimpleTrait {
	public static final Serializer<FireReactTrait> SERIALIZER = new Serializer<FireReactTrait>(new ResourceLocation(SilentCompat.MODID, "fire_react"), FireReactTrait::new);

	public FireReactTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Sets attackers on fire");
        return ret;
    }
}
