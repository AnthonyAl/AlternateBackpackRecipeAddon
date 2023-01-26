package com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Handlers;

import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Commands.HelpCmd;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Commands.ReloadCmd;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Commands.SubCommand;
import com.unipi.alexandris.slimefunaddon.altbackpackrecipe.AltBackpackRecipeAddon;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public final class CommandsHandler implements TabExecutor {

    private final HashMap<String, SubCommand> commands = new HashMap<>();

    public CommandsHandler(AltBackpackRecipeAddon plugin) {
        commands.put("help", new HelpCmd(this));
        commands.put("reload", new ReloadCmd(plugin));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "Alternate Backpack Recipe Addon" + ChatColor.GRAY + " is a plugin addon for slimefun designed by Antitonius" +
                    " for adding a custom alternate recipe for Slimefun4 backpacks. To check the help page, type "
                    + ChatColor.YELLOW + "/altbackpack help" + ChatColor.GRAY + ".");
            return true;
        }

        SubCommand command = commands.get(args[0].toLowerCase());

        if (command == null) {
            sender.sendMessage(ChatColor.RED + "Unknown command. To check out the help page, type " + ChatColor.GRAY + "/altbackpack help" + ChatColor.RED + ".");
            return true;
        }

        if (command.inGameOnly() && !(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Console cannot run this command.");
            return true;
        }

        String[] subCmdArgs = new String[args.length - 1];
        System.arraycopy(args, 1, subCmdArgs, 0, subCmdArgs.length);

        if (!command.onCommand(sender, subCmdArgs)) {
            sender.sendMessage(ChatColor.RED + "Command usage: /altbackpack " + ChatColor.GRAY + command.getUsage() + ChatColor.RED + ".");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        //create new array
        final List<String> completions = new ArrayList<>();
        //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
        StringUtil.copyPartialMatches(args[0], commands.keySet().stream().toList(), completions);
        //sort the list
        Collections.sort(completions);
        return completions;
    }

    public Collection<SubCommand> getCommands() {
        return commands.values();
    }
}
