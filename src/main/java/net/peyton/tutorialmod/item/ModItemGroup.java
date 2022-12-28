package net.peyton.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.peyton.tutorialmod.TutorialMod;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID, "tanzanite"))
            .displayName(Text.literal("Tanzanite Item Group"))
            .icon(() -> new ItemStack(ModItems.TANZANITE)).build();
}
