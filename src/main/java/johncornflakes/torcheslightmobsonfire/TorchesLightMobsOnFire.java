package johncornflakes.torcheslightmobsonfire;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.block.TorchBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TorchesLightMobsOnFire implements ModInitializer {
	public static final String MOD_ID = "torches-light-mobs-on-fire";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

//        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
//            Item handItem = player.getMainHandStack().getItem();
//            if (entity instanceof LivingEntity && (handItem == Items.TORCH || handItem == Items.SOUL_TORCH)) {
//                entity.setOnFireForTicks(120);
//
//            }
//
//            return ActionResult.PASS;
//        });

        ServerLivingEntityEvents.ALLOW_DAMAGE.register((livingEntity, damageSource, v) -> {
            LOGGER.info(livingEntity.toString());
            Entity attacker = damageSource.getAttacker();

            if (attacker instanceof ZombieEntity || attacker instanceof PlayerEntity || attacker instanceof HuskEntity || attacker instanceof DrownedEntity) {
                LOGGER.info(attacker.toString());
                Item itemInMain = ((LivingEntity) attacker).getMainHandStack().getItem();
                if (itemInMain == Items.TORCH || itemInMain == Items.SOUL_TORCH) {
                    livingEntity.setFireTicks(120);
                }
            }

//            LOGGER.info(damageSource.toString());

            return true;
        });


	}
}