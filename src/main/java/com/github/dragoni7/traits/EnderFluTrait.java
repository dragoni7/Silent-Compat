package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.ModKeys;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class EnderFluTrait extends SimpleTrait {
	
	public static final Serializer<EnderFluTrait> SERIALIZER = new Serializer<EnderFluTrait>(new ResourceLocation(SilentCompat.MODID, "enderflu"), EnderFluTrait::new);
	private static MobEffect ender_flu = null;
	
	public EnderFluTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public void onGearCrafted(TraitActionContext context) {
		ender_flu = ForgeRegistries.MOB_EFFECTS.getValue(ModKeys.ENDER_FLU);
    }
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (ender_flu != null) {
			if (target.hasEffect(ender_flu)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				target.addEffect(new MobEffectInstance(ender_flu, 180));
			}
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
