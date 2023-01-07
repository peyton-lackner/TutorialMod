package net.peyton.tutorialmod.world.feature;

import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.peyton.tutorialmod.TutorialMod;

import java.util.function.BiConsumer;

public class ModConfiguredFeatures {
    public static final RegistryKey<PlacedFeature> TANZANITE_ORE =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TutorialMod.MOD_ID, "tanzanite_ore_under"));
    public static final RegistryKey<PlacedFeature> NETHERRACK_TANZANITE_ORE =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TutorialMod.MOD_ID, "tanzanite_ore_nether"));
    public static final RegistryKey<PlacedFeature> ENDSTONE_TANZANITE_ORE =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TutorialMod.MOD_ID, "tanzanite_ore_end"));


    public static void registerConfiguredFeatures() {
        TutorialMod.LOGGER.debug("Registering ModConfiguredFeatures for " + TutorialMod.MOD_ID);
        BiomeModifications.create(new Identifier(TutorialMod.MOD_ID, "features"))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), myOreModifier(TANZANITE_ORE))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInTheNether(), myOreModifier(NETHERRACK_TANZANITE_ORE))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInTheEnd(), myOreModifier(ENDSTONE_TANZANITE_ORE))
        ;
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> myOreModifier(RegistryKey<PlacedFeature> orePlacedFeatureKey) {
        return (biomeSelectionContext, biomeModificationContext) ->
                biomeModificationContext.getGenerationSettings()
                        .addFeature(GenerationStep.Feature.UNDERGROUND_ORES, orePlacedFeatureKey);
    }
}
