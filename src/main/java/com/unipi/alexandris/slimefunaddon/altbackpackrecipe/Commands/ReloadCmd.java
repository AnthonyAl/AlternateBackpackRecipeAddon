package com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Commands;

import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.AltBackpackRecipeAddon;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Handlers.ConfigHandler;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class ReloadCmd implements SubCommand{

    private final AltBackpackRecipeAddon plugin;

    public ReloadCmd(AltBackpackRecipeAddon plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("Reloading AltBackpacks Recipe.. .  . ");
        plugin.reloadConfig();
        plugin.config = new ConfigHandler(plugin);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return Collections.emptyList();
    }

    @Override
    public String getUsage() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reloads the config.yml for the plugin.";
    }
}
