package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.consts.ModConsts;
import com.github.dragoni7.silentcompat.modcompats.BotanicAddsCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class GaiaBurstTrait extends SimpleTrait {
	
    public static final Serializer<GaiaBurstTrait> SERIALIZER = new Serializer<>(SilentCompat.getId("gaia_burst"), GaiaBurstTrait::new);

    @Override
    public void onItemSwing(ItemStack stack, LivingEntity entity, int traitLevel) {
    	
    	if(ModList.get().isLoaded(ModConsts.BOTANICADDS)) {
    		BotanicAddsCompat.SpawnManaBurst(entity);
    	}
    }

    public GaiaBurstTrait(ResourceLocation id) {
        super(id, SERIALIZER);
    }

    @Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("The Mana Burst is identical to that of a default, unenchanted Mana Stealer Blade. Uses 100 mana per burst.");
        return ret;
    }
}
