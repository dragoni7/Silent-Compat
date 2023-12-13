package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.api.traits.ITraitSerializer;
import net.silentchaos512.gear.api.traits.TraitActionContext;

public class InverseDimensionalEffectTrait extends DimensionalEffectTrait {
	
    public static final ITraitSerializer<InverseDimensionalEffectTrait> SERIALIZER = new Serializer<>(
    		new ResourceLocation(SilentCompat.MODID, "inverse_dimensional_effect"),
            InverseDimensionalEffectTrait::new,
            DimensionalEffectTrait::deserializeJson,
            DimensionalEffectTrait::readFromNetwork,
            DimensionalEffectTrait::writeToNetwork
    );

	public InverseDimensionalEffectTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
	@Override
    protected void applyEffects(TraitActionContext context, GearType gearType, String type, Iterable<PotionData> effects) {
        Player player = context.getPlayer();
        assert player != null; // checked in onUpdate
        
        if (gearType.matches(type) || "all".equals(type)) {
            int setPieceCount = getSetPieceCount(type, player);
            boolean hasFullSet = !"armor".equals(type) || setPieceCount >= 4;

            for (PotionData potionData : effects) {
                MobEffectInstance effect = potionData.getEffect(context.getTraitLevel(), setPieceCount, hasFullSet);
                
                // only apply effect while not in dimension
                if (effect != null && !player.level().dimension().location().equals(potionData.getDimensionId())) {
                    player.addEffect(effect);
                }
            }
        }
    }
	
    @Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("While not in ");
        this.potions.forEach((type, list) -> {
            ret.add("  - " + type);
            list.forEach(mod -> {
                ret.add("    - " + mod.getWikiLine());
            });
        });
        return ret;
    }
}
