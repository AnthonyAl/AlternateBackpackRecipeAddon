package com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Handlers;

import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.AltBackpackRecipeAddon;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Core.Config;
import org.bukkit.configuration.file.FileConfiguration;

@SuppressWarnings({"unused"})
public final class ConfigHandler {

    private final Config config = new Config();

    public ConfigHandler(AltBackpackRecipeAddon plugin) {
        loadBaseConfig(plugin);
    }

    private void loadBaseConfig(AltBackpackRecipeAddon plugin) {
        FileConfiguration fileConfiguration = plugin.getConfig();

        config.setBackpack_number(fileConfiguration.getInt("options.backpack-number"));

        if(config.getBackpack_number() < 1 || config.getBackpack_number() > 64) config.setBackpack_number(2);
    }

    public int getBackpack_number() {
        return config.getBackpack_number();
    }

    public void setBackpack_number(int backpack_number) {
        config.setBackpack_number(backpack_number);
    }


}
