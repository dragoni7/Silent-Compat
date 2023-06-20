package com.github.dragoni7.silentcompat.trait;
import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.consts.ModConsts;
import com.github.dragoni7.silentcompat.modcompats.BotaniaCompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import java.util.Collection;

/* original author: Partonetrain 
 * Curseforge message: Sorry, but I am not updating it. Others are welcome to, as it is open-source */

public class ManaBurstTrait extends SimpleTrait {

    public static final Serializer<ManaBurstTrait> SERIALIZER = new Serializer<>(SilentCompat.getId("mana_burst"), ManaBurstTrait::new);

    @Override
    public void onItemSwing(ItemStack stack, LivingEntity entity, int traitLevel) {
    	
    	if(ModList.get().isLoaded(ModConsts.BOTANIA)) {
    		BotaniaCompat.SpawnManaBurst(entity);
    	}
    }

    public ManaBurstTrait(ResourceLocation id) {
        super(id, SERIALIZER);
    }

    @Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("The Mana Burst is identical to that of a default, unenchanted Terra Blade. Uses 100 mana per burst.");
        return ret;
    }
}
