package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.consts.ModEffectsLocs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.gear.api.item.GearType;
import net.silentchaos512.gear.api.item.ICoreItem;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class LavaVisionTrait extends SimpleTrait {
	
	public static final Serializer<LavaVisionTrait> SERIALIZER = new Serializer<LavaVisionTrait>(new ResourceLocation(SilentCompat.MODID, "lava_vision"), LavaVisionTrait::new);
	private static MobEffect LAVA_VISION = ForgeRegistries.MOB_EFFECTS.getValue(ModEffectsLocs.LAVA_VISION);
	
	public LavaVisionTrait(ResourceLocation id) {
		super(id, SERIALIZER);
	}
	
    @Override
    public void onUpdate(TraitActionContext context, boolean isEquipped) {
        if (!isEquipped || context.getPlayer() == null || context.getPlayer().tickCount % 10 != 0 || LAVA_VISION == null) return;

        GearType gearType = ((ICoreItem) context.getGear().getItem()).getGearType();
        Player player = context.getPlayer();
        
        // only apply with helmet
        if (gearType == GearType.HELMET && player.isInLava()) {
        	assert player != null;
        	player.addEffect(new MobEffectInstance(LAVA_VISION, 20, 0, false, false, true));
        }
    }
	
	@Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Helmet provides lava vision");
        return ret;
    }

}
