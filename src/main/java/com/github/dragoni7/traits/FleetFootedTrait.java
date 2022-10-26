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

public class FleetFootedTrait extends SimpleTrait {
	
	public static final Serializer<FleetFootedTrait> SERIALIZER = new Serializer<FleetFootedTrait>(new ResourceLocation(SilentCompat.MODID, "fleetfooted"), FleetFootedTrait::new);
	private static MobEffect fleet_footed = null;
	
	public FleetFootedTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public void onGearCrafted(TraitActionContext context) {
		fleet_footed = ForgeRegistries.MOB_EFFECTS.getValue(ModKeys.FLEET_FOOTED);
    }
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (fleet_footed != null && target instanceof LivingEntity) {
			if (target.hasEffect(fleet_footed)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				context.getPlayer().addEffect(new MobEffectInstance(fleet_footed, 60));
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Increases speed while jumping and sprinting on-hit");
        return ret;
    }
}
