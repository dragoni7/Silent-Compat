package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class HungeringStrike extends SimpleTrait {
public static final Serializer<HungeringStrike> SERIALIZER = new Serializer<HungeringStrike>(new ResourceLocation(SilentCompat.MODID, "hungering_strike"), HungeringStrike::new);
	
	public HungeringStrike(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		Player player = context.getPlayer();
		if (player.getFoodData().getFoodLevel() < 10) {
			// 10% more base damage while half food
			return baseValue + (baseValue * 0.10F);
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Deal more damage while under half hunger");
        return ret;
    }
}
