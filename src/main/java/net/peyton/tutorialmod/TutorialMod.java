package net.peyton.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.peyton.tutorialmod.block.ModBlocks;
import net.peyton.tutorialmod.item.ModItems;
import net.peyton.tutorialmod.painting.ModPaintings;
import net.peyton.tutorialmod.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.RegisterModItems();
		ModBlocks.RegisterModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();
	}
}
