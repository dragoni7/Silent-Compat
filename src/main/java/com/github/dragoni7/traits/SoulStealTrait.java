package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.ModKeys;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class SoulStealTrait extends SimpleTrait {
	public static final Serializer<SoulStealTrait> SERIALIZER = new Serializer<SoulStealTrait>(new ResourceLocation(SilentCompat.MODID, "soul_steal"), SoulStealTrait::new);
	private static MobEffect soul_steal = null;
	
	public SoulStealTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    public void onGearCrafted(TraitActionContext context) {
		soul_steal = ForgeRegistries.MOB_EFFECTS.getValue(ModKeys.SOUL_STEAL);
    }
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		if (soul_steal != null && target instanceof LivingEntity) {
			Player player = context.getPlayer();
			if (player.hasEffect(soul_steal)) {
				return super.onAttackEntity(context, target, baseValue);
			} 
			else {
				if (player.getRandom().nextInt(10) % 10 == 0) {
					context.getPlayer().addEffect(new MobEffectInstance(soul_steal, 100));
				}
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Chance to gain life steal on hit");
        return ret;
    }
}
