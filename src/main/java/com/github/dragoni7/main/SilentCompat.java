package com.github.dragoni7.main;

import com.github.dragoni7.core.MaterialRegistry;
import com.github.dragoni7.core.SilentCompatBlocks;
import com.github.dragoni7.core.SilentCompatItems;
import com.github.dragoni7.traits.DecayTrait;
import com.github.dragoni7.traits.DiurnalTrait;
import com.github.dragoni7.traits.EnderFluTrait;
import com.github.dragoni7.traits.NocturnalTrait;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.silentchaos512.gear.api.GearApi;

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
    	GearApi.registerTraitSerializer(DiurnalTrait.SERIALIZER);
    	GearApi.registerTraitSerializer(NocturnalTrait.SERIALIZER);
    	GearApi.registerTraitSerializer(DecayTrait.SERIALIZER);
    	GearApi.registerTraitSerializer(EnderFluTrait.SERIALIZER);
    }
    
    public static final CreativeModeTab SilentCompatTab = (new CreativeModeTab("silentcompat")  {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(MaterialRegistry.MIDNIGHTIRON.ingot.get());
		}
	});
}
