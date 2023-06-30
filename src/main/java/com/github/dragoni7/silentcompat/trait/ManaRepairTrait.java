package com.github.dragoni7.silentcompat.trait;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.silentchaos512.gear.api.traits.TraitActionContext;
import net.silentchaos512.gear.gear.trait.SimpleTrait;
import java.util.Collection;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.consts.ModConsts;
import com.github.dragoni7.silentcompat.modcompats.BotaniaCompat;

/* original author: Partonetrain 
 * Curseforge message: Sorry, but I am not updating it. Others are welcome to, as it is open-source */

public class ManaRepairTrait extends SimpleTrait {

    public static final Serializer<ManaRepairTrait> SERIALIZER = new Serializer<ManaRepairTrait>(SilentCompat.getId("mana_repair"), ManaRepairTrait::new);

    private static final int MANA_PER_DAMAGE_TIER = 40;

    @Override
    public void onUpdate(TraitActionContext context, boolean isEquipped) {
    	
    	if(ModList.get().isLoaded(ModConsts.BOTANIA)) {
    		BotaniaCompat.ManaRepair(context.getGear(), context, isEquipped, MANA_PER_DAMAGE_TIER);
    	}
    }

    @Override
    public Collection<String> getExtraWikiLines() {
        Collection<String> ret = super.getExtraWikiLines();
        ret.add("Uses 20 + ( 40 per trait level) mana to repair gear.");
        return ret;
    }

    public ManaRepairTrait(ResourceLocation id) {
        super(id, SERIALIZER);
    }
}
