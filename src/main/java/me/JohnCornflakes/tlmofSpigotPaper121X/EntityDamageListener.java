package me.JohnCornflakes.tlmofSpigotPaper121X;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

public class EntityDamageListener implements Listener {
    private final TlmofSpigotPaper121X plugin;

    public EntityDamageListener(TlmofSpigotPaper121X plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity(@NotNull EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity victim = event.getEntity();

        if (damager instanceof Player) {
            Player attacker = (Player) damager;
            PlayerInventory playerInventory = attacker.getInventory();
            ItemStack itemInMainHand = playerInventory.getItemInMainHand();

            if (itemInMainHand.getType() == Material.TORCH || itemInMainHand.getType() == Material.SOUL_TORCH) {
                victim.setFireTicks(120);
            }

        } else if (damager instanceof Zombie || damager instanceof Drowned || damager instanceof Husk) {
            LivingEntity livingEntity = (LivingEntity) damager;
            EntityEquipment entityEquipment = livingEntity.getEquipment();
            ItemStack itemInMainHand = entityEquipment.getItemInMainHand();

            if (itemInMainHand.getType() == Material.TORCH || itemInMainHand.getType() == Material.SOUL_TORCH) {
                victim.setFireTicks(120);
            }

        }
    }
}
