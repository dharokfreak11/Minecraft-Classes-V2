package net.genflow.minecraftclasses.commands;

import net.genflow.minecraftclasses.MinecraftClasses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor{

	MinecraftClasses mcClasses;
	
	//Constructor
	public CommandManager(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}

	//On player command.
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){
		new CommandReflector(Label, cmd, sender, args);
		return true;
	}

}
