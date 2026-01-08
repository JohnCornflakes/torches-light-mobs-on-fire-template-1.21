package me.JohnCornflakes.tlmofSpigotPaper121X;

import org.bukkit.plugin.java.JavaPlugin;

public final class TlmofSpigotPaper121X extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
