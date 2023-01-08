package net.peyton.tutorialmod.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.peyton.tutorialmod.TutorialMod;
import net.peyton.tutorialmod.networking.packet.DrinkingC2SPacket;
import net.peyton.tutorialmod.networking.packet.ExampleC2SPacket;

public class ModMessages {
    public static final Identifier DRINKING_ID = new Identifier(TutorialMod.MOD_ID, "drinking");
    public static final Identifier THIRST_SYNC_ID = new Identifier(TutorialMod.MOD_ID, "thirst_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(TutorialMod.MOD_ID, "example");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::recieve);
        ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::recieve);
    }

    public static void registerS2CPackets() {

    }
}
