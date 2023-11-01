package com.sakurarealm.recipecraft.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeCraftPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Plugin germPlugin = Bukkit.getPluginManager().getPlugin("GermPlugin");
        if (germPlugin == null) {
            Bukkit.getLogger().severe("GermPlugin is not loaded");
            return;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
