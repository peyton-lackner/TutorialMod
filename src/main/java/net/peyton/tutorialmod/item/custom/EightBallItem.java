package net.peyton.tutorialmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Executes Server-Side and on Main Hand
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            // Output Random Number from 0, 9
            outputRandomNumber(user, 10);
            // Add Cooldown
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Right Click to get a random number!").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press Shift for more info!").formatted(Formatting.YELLOW));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputRandomNumber(PlayerEntity player, int bound) {
        player.sendMessage(Text.literal("Your Number is " + getRandomNumber(bound)));
    }

    private int getRandomNumber(int bound) {
        return Random.createLocal().nextInt(bound);
    }
}
