package net.peyton.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.peyton.tutorialmod.TutorialMod;

public class ModItems {

    public static final Item RAW_TANZANITE = registerItem(
            "raw_tanzanite",
            new Item(new Item.Settings()),
            ItemGroups.NATURAL
    );





    private static Item registerItem(String name, Item item, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }

    public static void RegisterModItems() {
        TutorialMod.LOGGER.debug("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
