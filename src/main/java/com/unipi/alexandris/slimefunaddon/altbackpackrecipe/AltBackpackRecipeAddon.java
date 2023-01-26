package com.unipi.alexandris.slimefunaddon.altbackpackrecipe;

import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Core.ItemSetup;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Handlers.CommandsHandler;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Handlers.ConfigHandler;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AltBackpackRecipeAddon extends JavaPlugin implements SlimefunAddon {

    private static AltBackpackRecipeAddon instance;
    public ConfigHandler config;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        config = new ConfigHandler(this);

        ItemSetup.INSTANCE.init();

        Objects.requireNonNull(getCommand("altbackpack")).setExecutor(new CommandsHandler(this));

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return instance;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }
}
