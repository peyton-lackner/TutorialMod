package net.peyton.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.peyton.tutorialmod.block.ModBlocks;
import net.peyton.tutorialmod.event.KeyInputHandler;
import net.peyton.tutorialmod.networking.ModMessages;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());

        KeyInputHandler.register();

        ModMessages.registerS2CPackets();
    }
}
