package net.peyton.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peyton.tutorialmod.TutorialMod;
import net.peyton.tutorialmod.block.ModBlocks;
import net.peyton.tutorialmod.item.custom.EightBallItem;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItem(
            "raw_tanzanite",
            new Item(new Item.Settings()),
            ModItemGroup.TANZANITE
    );

    public static final Item TANZANITE = registerItem(
            "tanzanite",
            new Item(new Item.Settings()),
            ModItemGroup.TANZANITE
    );

    public static final Item EIGHT_BALL = registerItem(
            "eight_ball",
            new EightBallItem(new Item.Settings().maxCount(1)),
            ItemGroups.TOOLS
    );

    public static final Item EGGPLANT_SEEDS = registerItem(
            "eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP, new Item.Settings()),
            ItemGroups.NATURAL
    );

    public static final Item EGGPLANT = registerItem(
            "eggplant",
            new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(4f).build())),
            ItemGroups.FOOD_AND_DRINK
    );




    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void RegisterModItems() {
        TutorialMod.LOGGER.debug("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
