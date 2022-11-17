package com.github.dragoni7.main;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.SilentCompatBlocks;
import com.github.dragoni7.core.SilentCompatItems;
import com.github.dragoni7.trait.AbyssalSynergyTrait;
import com.github.dragoni7.trait.ColdTrait;
import com.github.dragoni7.trait.DecayTrait;
import com.github.dragoni7.trait.DiurnalTrait;
import com.github.dragoni7.trait.DodgingTrait;
import com.github.dragoni7.trait.EdibleTrait;
import com.github.dragoni7.trait.EmuDodgeTrait;
import com.github.dragoni7.trait.EnderFluTrait;
import com.github.dragoni7.trait.FeatherWeightTrait;
import com.github.dragoni7.trait.FireReactTrait;
import com.github.dragoni7.trait.FleetFootedTrait;
import com.github.dragoni7.trait.FreezingTrait;
import com.github.dragoni7.trait.GooeyTrait;
import com.github.dragoni7.trait.HungeringStrike;
import com.github.dragoni7.trait.KnightlyTrait;
import com.github.dragoni7.trait.KnockoutTrait;
import com.github.dragoni7.trait.LuckyBreak;
import com.github.dragoni7.trait.NeptunesMightTrait;
import com.github.dragoni7.trait.NocturnalTrait;
import com.github.dragoni7.trait.RetaliatingBlastTrait;
import com.github.dragoni7.trait.SoulStealTrait;
import com.github.dragoni7.trait.UnstableMagicTrait;
import com.github.dragoni7.trait.VigorousTrait;
import com.github.dragoni7.trait.VorpalTrait;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.silentchaos512.gear.api.GearApi;
import net.silentchaos512.gear.api.traits.ITraitSerializer;

import org.slf4j.Logger;

@Mod(SilentCompat.MODID)
public class SilentCompat
{
    public static final String MODID = "silentcompat";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SilentCompat()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SilentCompatItems.ITEMS.register(modEventBus);
        SilentCompatBlocks.BLOCKS.register(modEventBus);
        MaterialRegistry.init();
        registerTraits();
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    public void registerTraits() {
    	registerTrait(DiurnalTrait.SERIALIZER);
    	registerTrait(NocturnalTrait.SERIALIZER);
    	registerTrait(DecayTrait.SERIALIZER);
    	registerTrait(EnderFluTrait.SERIALIZER);
    	registerTrait(DodgingTrait.SERIALIZER);
    	registerTrait(EdibleTrait.SERIALIZER);
    	registerTrait(FleetFootedTrait.SERIALIZER);
    	registerTrait(FreezingTrait.SERIALIZER);
    	registerTrait(FeatherWeightTrait.SERIALIZER);
    	registerTrait(VorpalTrait.SERIALIZER);
    	registerTrait(HungeringStrike.SERIALIZER);
    	registerTrait(SoulStealTrait.SERIALIZER);
    	registerTrait(LuckyBreak.SERIALIZER);
    	registerTrait(RetaliatingBlastTrait.SERIALIZER);
    	registerTrait(KnockoutTrait.SERIALIZER);
    	registerTrait(AbyssalSynergyTrait.SERIALIZER);
    	registerTrait(VigorousTrait.SERIALIZER);
    	registerTrait(GooeyTrait.SERIALIZER);
    	registerTrait(UnstableMagicTrait.SERIALIZER);
    	registerTrait(KnightlyTrait.SERIALIZER);
    	registerTrait(FireReactTrait.SERIALIZER);
    	registerTrait(NeptunesMightTrait.SERIALIZER);
    	registerTrait(ColdTrait.SERIALIZER);
    	registerTrait(EmuDodgeTrait.SERIALIZER);
    }
    
    private void registerTrait(ITraitSerializer<?> serializer) {
    	GearApi.registerTraitSerializer(serializer);
    }
    
    public static final CreativeModeTab SilentCompatTab = (new CreativeModeTab("silentcompat")  {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(MaterialRegistry.CAPSID_ALLOY.ingot.get());
		}
	});
}
