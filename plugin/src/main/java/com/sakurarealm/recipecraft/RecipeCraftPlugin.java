package com.sakurarealm.recipecraft;

import com.sakurarealm.recipecraft.command.TestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class RecipeCraftPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("RecipeCraftPlugin enabled.");
        getCommand("rtest").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
