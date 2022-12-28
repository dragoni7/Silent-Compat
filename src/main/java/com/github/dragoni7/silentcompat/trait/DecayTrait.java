package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.EffectResourceLocs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class DecayTrait extends SimpleTrait {
	
	public static final Serializer<DecayTrait> SERIALIZER = new Serializer<DecayTrait>(new ResourceLocation(SilentCompat.MODID, "decay"), DecayTrait::new);
	private static MobEffect decay = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.DECAY_EFFECT);
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (decay != null) {
			if (target.hasEffect(decay)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(decay, 100));
			}
		}
		else {
			decay = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.DECAY_EFFECT);
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Applies Decay to targets");
        return ret;
    }
	
	public DecayTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

}
