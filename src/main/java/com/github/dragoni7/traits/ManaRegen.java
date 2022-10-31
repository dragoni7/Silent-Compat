package com.github.dragoni7.traits;

import java.util.Collection;

import com.github.dragoni7.core.EffectResourceLocs;
import com.github.dragoni7.main.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class ManaRegen extends SimpleTrait {
	public static final Serializer<ManaRegen> SERIALIZER = new Serializer<ManaRegen>(new ResourceLocation(SilentCompat.MODID, "mana_regen"), ManaRegen::new);
	private static MobEffect mana_regen = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.MANAREGEN);
	
	public ManaRegen(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
	public float onAttackEntity(TraitActionContext context, LivingEntity target, float baseValue) {
		Player player = context.getPlayer();
		if (player.getRandom().nextIntBetweenInclusive(1, 5) % 5 == 0) {
			if (mana_regen != null) {
				if (!player.hasEffect(mana_regen)) {
					player.forceAddEffect(new MobEffectInstance(mana_regen, 80), player);
				}
			}
			else {
				mana_regen = ForgeRegistries.MOB_EFFECTS.getValue(EffectResourceLocs.MANAREGEN);
			}
		}
		
		return super.onAttackEntity(context, target, baseValue);
	}
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Sometimes grants mana regen");
        return ret;
    }
}
