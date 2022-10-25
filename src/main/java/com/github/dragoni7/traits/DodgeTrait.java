package com.github.dragoni7.traits;

import net.minecraft.resources.ResourceLocation;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class DodgeTrait extends SimpleTrait {

	public DodgeTrait(ResourceLocation id) {
		super(id);
	}

	@Override
    public void onUpdate(TraitActionContext context, boolean isEquipped) {
        if (isEquipped) {
        	
        }
    }
}
