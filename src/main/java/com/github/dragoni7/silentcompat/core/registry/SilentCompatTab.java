package com.github.dragoni7.silentcompat.core.registry;

import com.github.dragoni7.silentcompat.SilentCompat;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;

public class SilentCompatTab {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SilentCompat.MODID);
	

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("tab", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MaterialRegistry.MATERIAL_SETS.get("capsid_alloy").ingot.get()))
                    .title(Component.translatable("itemGroup.silentcompat"))
                    .displayItems((itemDisplayParameters, output) -> {
                    	SilentCompatItems.ITEMS.getEntries().forEach(ro -> output.accept(ro.get()));
                    })
                    .build());
}
