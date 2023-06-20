package com.github.dragoni7.silentcompat.trait;

import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.consts.ModConsts;
import com.github.dragoni7.silentcompat.modcompats.MythicBotanyCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.silentchaos512.gear.gear.trait.SimpleTrait;

public class AlfBurstTrait extends SimpleTrait {

    public static final Serializer<AlfBurstTrait> SERIALIZER = new Serializer<>(SilentCompat.getId("alf_burst"), AlfBurstTrait::new);

    @Override
    public void onItemSwing(ItemStack stack, LivingEntity entity, int traitLevel) {
    	
    	if(ModList.get().isLoaded(ModConsts.MYTHICBOT)) {
    		MythicBotanyCompat.SpawnManaBurst(entity);
    	}
    }

    public AlfBurstTrait(ResourceLocation id) {
        super(id, SERIALIZER);
    }

    @Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("The Mana Burst is identical to that of a default, unenchanted Alf Blade. Uses 100 mana per burst.");
        return ret;
    }
}
