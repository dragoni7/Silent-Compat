package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.EffectResourceLocs;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class FreezingTrait extends SimpleTrait {
	public static final Serializer<FreezingTrait> SERIALIZER = new Serializer<FreezingTrait>(new ResourceLocation(SilentCompat.MODID, "freezing"), FreezingTrait::new);
	private static MobEffect freezing = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.FREEZING);
	
	public FreezingTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (freezing != null && target.canFreeze()) {
			target.addEffect(new MobEffectInstance(freezing, 60));
		}
		else {
			freezing = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.FREEZING);
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Attacks build up freezing on target. At max freeze, damage is dealth over time. Just like stepping in powdered snow.");
        return ret;
    }
}
