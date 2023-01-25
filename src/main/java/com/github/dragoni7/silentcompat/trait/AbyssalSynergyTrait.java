package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class AbyssalSynergyTrait extends SimpleTrait {
	
	public static final Serializer<AbyssalSynergyTrait> SERIALIZER = new Serializer<AbyssalSynergyTrait>(new ResourceLocation(SilentCompat.MODID, "abyssal_synergy"), AbyssalSynergyTrait::new);

	public AbyssalSynergyTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public float onDurabilityDamage(TraitActionContext context, int damageTaken) {
		Player player = context.getPlayer();
		double height = 0;
		
		if (player != null) {
			height = player.getY();
		}
		
		if (height < 0) {
			return Math.round(damageTaken + (0.1 * height));
		}
		
        return super.onDurabilityDamage(context, damageTaken);
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Tools deal more damage the deeper you are. Less durability loss the deeper you are.");
        return ret;
    }
}
