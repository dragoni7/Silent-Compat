package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.GearHelper;

public class DiurnalTrait extends SimpleTrait {
	
	public static final Serializer<DiurnalTrait> SERIALIZER = new Serializer<DiurnalTrait>(new ResourceLocation(SilentCompat.MODID, "diurnal"), DiurnalTrait::new);
	
	@Override
	public void onUpdate(TraitActionContext context, boolean isEquipped) {
		Level world = context.getPlayer().getLevel();
		
		long time = world.getDayTime() % 24000;
		if (time < 13000) {
			// repair during day
			if (context.getPlayer().tickCount % 240 == 0) {
				GearHelper.attemptDamage(context.getGear(), -1, context.getPlayer(), InteractionHand.MAIN_HAND);
			}
		}
	}
	
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		Level world = context.getPlayer().getLevel();
		
		long time = world.getDayTime() % 24000;
		if (time < 13000) {
			// 10% more base damage during day
			return baseValue + (baseValue * 0.10F);
		}
		
		return baseValue;
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Deal increased damage during the day. Gear slowly repairs during the day");
        return ret;
    }
	
	public DiurnalTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}

}
