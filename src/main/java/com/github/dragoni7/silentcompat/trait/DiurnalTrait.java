package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import net.silentchaos512.gear.util.GearHelper;
import net.silentchaos512.utils.MathUtils;

public class DiurnalTrait extends SimpleTrait {
	
	public static final Serializer<DiurnalTrait> SERIALIZER = new Serializer<DiurnalTrait>(new ResourceLocation(SilentCompat.MODID, "diurnal"), DiurnalTrait::new);
	
	@Override
	public void onUpdate(TraitActionContext context, boolean isEquipped) {
		Level world = context.getPlayer().getLevel();
		
		// repair during day
		long time = world.getDayTime() % 24000;
		if (time < 13000 && shouldActivate(context)) {
			GearHelper.attemptDamage(context.getGear(), -1, context.getPlayer(), InteractionHand.MAIN_HAND);
		}
	}
	
	private boolean shouldActivate(TraitActionContext context) {
		if (context.getPlayer() != null && context.getPlayer().tickCount % 40 == 0) {
			return MathUtils.tryPercentage(0.25f);
		}
		
		return false;
	}
	
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		Level world = context.getPlayer().getLevel();
		
		long time = world.getDayTime() % 24000;
		if (time < 13000) {
			// 10% more base damage during day
			return baseValue + (baseValue * 0.10F);
		}
		
		return super.onAttackEntity(context, target, baseValue);
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
