package com.github.dragoni7.trait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class LuckyBreak extends SimpleTrait {
	
public static final Serializer<LuckyBreak> SERIALIZER = new Serializer<LuckyBreak>(new ResourceLocation(SilentCompat.MODID, "lucky_break"), LuckyBreak::new);
public static final ArrayList<MobEffect> EFFECTS = new ArrayList<MobEffect>(List.of(
		MobEffects.ABSORPTION, 
		MobEffects.DAMAGE_BOOST, 
		MobEffects.DAMAGE_RESISTANCE, 
		MobEffects.DIG_SPEED, 
		MobEffects.FIRE_RESISTANCE, 
		MobEffects.WATER_BREATHING, 
		MobEffects.REGENERATION,
		MobEffects.LUCK,
		MobEffects.MOVEMENT_SPEED));

	public LuckyBreak(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Chance to gain random potion effect when hit. Effected by luck");
        return ret;
    }
}
