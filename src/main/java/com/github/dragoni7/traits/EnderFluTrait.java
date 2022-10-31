package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.EffectResourceLocs;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.GearHelper;

public class EnderFluTrait extends SimpleTrait {
	
	public static final Serializer<EnderFluTrait> SERIALIZER = new Serializer<EnderFluTrait>(new ResourceLocation(SilentCompat.MODID, "enderflu"), EnderFluTrait::new);
	private static MobEffect ender_flu = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.ENDER_FLU);
	
	public EnderFluTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		SilentCompat.LOGGER.info("effect = " + ender_flu);
		if (ender_flu != null) {
			if (target.hasEffect(ender_flu)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(ender_flu, 180));
			}
		}
		else {
			ender_flu = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.ENDER_FLU);
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Infects the target with Ender Flu");
        return ret;
    }
}
