package com.github.dragoni7.trait;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class KnockoutTrait extends SimpleTrait {
	public static final Serializer<KnockoutTrait> SERIALIZER = new Serializer<KnockoutTrait>(new ResourceLocation(SilentCompat.MODID, "knockout"), KnockoutTrait::new);
	private static double effectChance = 1/5;
	
	public KnockoutTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		
		if (context.getPlayer().getRandom().nextDouble() <= effectChance) {
			target.knockback(20, 1, 1);
		}
			
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Chance to inflict a heavy knockback to targets");
        return ret;
    }
}
