package net.genflow.minecraftclasses.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface CommandInterface{

	boolean isSenderPlayer(CommandSender sender);
	
	boolean doesPlayerHavePermission(Player player, String commandName);
	
	int minimumArgs();
	
	int maximumArgs();
	
	
}
