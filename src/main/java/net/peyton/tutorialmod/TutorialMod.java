package net.peyton.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.peyton.tutorialmod.block.ModBlocks;
import net.peyton.tutorialmod.item.ModItems;
import net.peyton.tutorialmod.networking.ModMessages;
import net.peyton.tutorialmod.painting.ModPaintings;
import net.peyton.tutorialmod.util.ModLootTableModifiers;
import net.peyton.tutorialmod.villager.ModVillagers;
import net.peyton.tutorialmod.world.feature.ModConfiguredFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();

		ModLootTableModifiers.modifyLootTables();

		ModMessages.registerC2SPackets();
	}
}
