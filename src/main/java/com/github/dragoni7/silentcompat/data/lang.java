package com.github.dragoni7.silentcompat.data;

import org.codehaus.plexus.util.StringUtils;

import com.github.dragoni7.silentcompat.SilentCompat;
import com.github.dragoni7.silentcompat.core.registry.MaterialRegistry;
import com.github.dragoni7.silentcompat.core.registry.MaterialSet;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatEffects;
import com.github.dragoni7.silentcompat.core.registry.SilentCompatItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class lang extends LanguageProvider {

	public lang(DataGenerator gen, String locale) {
		super(gen, SilentCompat.MODID, locale);
	}
	
	@Override
	protected void addTranslations() {
		add("itemGroup." + SilentCompat.MODID, "SilentCompat");
		
		for (MaterialSet set : MaterialRegistry.MATERIAL_SETS.values()) {
			String name = set.name.replace('_', ' ');
			name = StringUtils.capitaliseAllWords(name);
			translateMaterialSet(set, name);
		}
		
		add(SilentCompatItems.OUTBACK_LEATHER.get(), "Outback Leather");
		add(SilentCompatItems.RAW_PLASTEEL.get(), "Raw Plasteel");
		add(SilentCompatItems.CHOCOLATECHIP.get(), "Chocolate Chip");
		add(SilentCompatItems.WARDEN_INGOT.get(), "Warden Ingot");
		
		add(SilentCompatEffects.AMPLIFIED.get(), "Amplified");
		add(SilentCompatEffects.DEVOURING.get(), "Devouring");
		
		add("trait.silentcompat.diurnal", "Diurnal");
		add("trait.silentcompat.diurnal.desc", "Deal increased damage during the day. Gear slowly repairs during the day");
		add("trait.silentcompat.nocturnal", "Nocturnal");
		add("trait.silentcompat.nocturnal.desc", "Deal increased damage at night. Gear slowly repairs at night");
		add("trait.silentcompat.decay", "Decay");
		add("trait.silentcompat.decay.desc", "Applies Decay to targets (Requires: Dreamland)");
		add("trait.silentcompat.ender_flu", "Ender Flu");
		add("trait.silentcompat.ender_flu.desc", "Infects the target with Ender Flu (Requires: Alexs Mobs)");
		add("trait.silentcompat.dodging", "Dodging");
		add("trait.silentcompat.dodging.desc", "Grants a chance to avoid damage. Requires full armor set. Does not protect against projectiles and armor ignoring damage");
		add("trait.silentcompat.chocolate_chipping", "Chocolate Chipping");
		add("trait.silentcompat.chocolate_chipping.desc", "Chance to drop a chocolate chip on durability loss");
		add("trait.silentcompat.fleetfooted", "Fleet-Footed");
		add("trait.silentcompat.fleetfooted.desc", "Increases speed while jumping and sprinting on-hit (Requires: Alexs Mobs)");
		add("trait.silentcompat.freezing", "Freezing");
		add("trait.silentcompat.freezing.desc", "Attacks build up freezing on target. At max freeze, damage is dealth over time. Just like stepping in powdered snow. (Requires: Ars Nouveau)");
		add("trait.silentcompat.featherweight", "Featherweight");
		add("trait.silentcompat.featherweight.desc", "Targets take additional knockback when hit. (Requires: Undergarden)");
		add("trait.silentcompat.vorpal", "Vorpal");
		add("trait.silentcompat.vorpal.desc", "Deal more damage to targets with over 200 hearts");
		add("trait.silentcompat.hungering_strike", "Hungering Strike");
		add("trait.silentcompat.hungering_strike.desc", "Deal more damage while under half hunger");
		add("trait.silentcompat.soul_steal", "Soul Steal");
		add("trait.silentcompat.soul_steal.desc", "Chance to gain life steal on hit. (Requires: Alexs Mobs)");
		add("trait.silentcompat.lucky_break", "Lucky Break");
		add("trait.silentcompat.lucky_break.desc", "Chance to gain random potion effect when hit. Effected by luck");
		add("trait.silentcompat.retaliating_blast", "Retaliating Blast");
		add("trait.silentcompat.retaliating_blast.desc", "Attacks or being attacked have a chance to apply a delayed explosion on the target (Requires: Ars Nouveau)");
		add("trait.silentcompat.knockout", "Knockout");
		add("trait.silentcompat.knockout.desc", "Chance to inflict a heavy knockback to targets");
		add("trait.silentcompat.abyssal_synergy", "Abyssal Synergy");
		add("trait.silentcompat.abyssal_synergy.desc", "Tools deal more damage the deeper you are. Less durability loss the deeper you are.");
		add("trait.silentcompat.vigorous", "Vigorous");
		add("trait.silentcompat.vigorous.desc", "Deal more damage while at full health");
		add("trait.silentcompat.unstable_magic", "Unstable Magic");
		add("trait.silentcompat.unstable_magic.desc", "Somtimes gain a random positive magic effect or apply random negative magic effect to targets. (Requires: Ars Nouveau)");
		add("trait.silentcompat.gooey", "Gooey");
		add("trait.silentcompat.gooey.desc", "Attacks have a chance to apply scintling goo under the target's feet. (Requires: Undergarden");
		add("trait.silentcompat.knightly", "Knightly");
		add("trait.silentcompat.knightly.desc", "Attacks do extra damage to armored targets");
		add("trait.silentcompat.fire_react", "Fire React");
		add("trait.silentcompat.fire_react.desc", "Sets attackers on fire");
		add("trait.silentcompat.neptunes_might", "Neptune's Might");
		add("trait.silentcompat.neptunes_might.desc", "Does more damage to targets while in water");
		add("trait.silentcompat.cold", "Cold");
		add("trait.silentcompat.cold.desc", "Chills attackers. (Requires: Twilight Forest");
		add("trait.silentcompat.emu_dodge", "Emu Dodge");
		add("trait.silentcompat.emu_dodge.desc", "Grants a chance to avoid projectile damage. Requires full armor set");
		add("trait.silentcompat.jolt_hit", "Jolt Hit");
		add("trait.silentcompat.jolt_hit.desc", "Consumes amplified, dealing bonus damage and chaining to a nearby entity.");
		add("trait.silentcompat.amplifying", "Amplifying");
		add("trait.silentcompat.amplifying.desc", "Getting a kill has a chance to grant the amplified effect. Requires full set");
		add("trait.silentcompat.blinding", "Blinding");
		add("trait.silentcompat.blinding.desc", "Consumes amplified on tool swing, launching a projectile that blinds and slows targets. Damage is equal to 3 times trait level.");
		add("trait.silentcompat.purifying", "Purifying");
		add("trait.silentcompat.purifying.desc", "Rare chance to remove harmful effects when hit. Requires full set");
		add("trait.silentcompat.devouring", "Devouring");
		add("trait.silentcompat.devouring.desc", "Getting a kill has a chance to grant the devouring effect. Requires full set.");
		add("trait.silentcompat.umbral_blast", "Umbral Blast");
		add("trait.silentcompat.umbral_blast.desc", "Consumes devouring on tool swing, launching a projectile that weakens, damages, and knocks back targets. Damage is equal to 3 times the trait level.");
		add("trait.silentcompat.volitile", "Volitile");
		add("trait.silentcompat.volitile.desc", "Consumes devouring, applying the volitile effect on the target.");
		add("trait.silentcompat.restoration", "Restoration");
		add("trait.silentcompat.restoration.desc", "Getting a kill has a chance to grant the restoration effect. Requires full set.");
		add("trait.silentcompat.scorching", "Scorching");
		add("trait.silentcompat.scorching.desc", "Consumes restoration, applying the scorch effect to the target hit.");
		add("trait.silentcompat.sunspot", "Sun Spot");
		add("trait.silentcompat.sunspot.desc", "Consumes restoration. Standing in fire puts it out, healing a large chunk of health and granting strength.");
		
		// JEED
		add("effect.silentcompat.amplified.description", "Increases speed. Allows certain traits such as Jolt Hit to proc.");
		add("effect.silentcompat.devouring.description", "Grants absorption hearts on kills. Has a cap. Allows certain traits such as volitile to proc.");
		add("effect.silentcompat.restoration.description", "Steadily restores hp over time. Allows certain traits such as scorch to proc.");
		add("effect.silentcompat.volitile.description", "Causes explosions when hit.");
		add("effect.silentcompat.scorch.description", "Sets the target on fire. When the effect ends, the target explodes, spreading scorch to nearby mobs.");
	}
	
	private void translateMaterialSet(MaterialSet set, String name) {
		add(set.ingot.get(), name + " Ingot");
		add(set.nugget.get(), name + " Nugget");
		add(set.block.get(), name + " Block");
		add("material.silentcompat." + set.name, name);
	}
}
