package name.lhm_mod;

import name.lhm_mod.entity.ModEntities;
import name.lhm_mod.entity.custom.LhmEntity;
import name.lhm_mod.registry.ModItemGroup;
import name.lhm_mod.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LhmMod implements ModInitializer {
	public static final String MOD_ID = "lhm-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("lhm 我超市梨的马");
		ModEntities.registerModEntities();
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		FabricDefaultAttributeRegistry.register(ModEntities.Lhm,LhmEntity.createAttributes());
	}
}