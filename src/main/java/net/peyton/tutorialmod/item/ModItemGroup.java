package net.peyton.tutorialmod.item;

import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.peyton.tutorialmod.TutorialMod;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID, "tanzanite"))
            .icon(() -> new ItemStack(ModItems.TANZANITE))
            .build();
}
