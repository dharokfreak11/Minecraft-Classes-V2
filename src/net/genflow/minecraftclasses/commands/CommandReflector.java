package net.genflow.minecraftclasses.commands;

import net.genflow.minecraftclasses.MinecraftClasses;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandReflector{

	MinecraftClasses mcClasses;

	public CommandReflector(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}
	
	String error = "===[" + ChatColor.AQUA + "Minecraft-Classes" + ChatColor.WHITE + "]===\n" + ChatColor.RED + "[ERROR] - That command does not exist!";

	public CommandReflector(String commandName, Command command ,CommandSender sender, String[] args){
		checkCommand(commandName, command, sender, args);
	}

	//Checks the command.
	private void checkCommand(String commandName, Command command, CommandSender sender, String[] args){
		if(commandName.equalsIgnoreCase("Race")){
			new RaceCommand(commandName, command, sender, args);
		}else if(commandName.equalsIgnoreCase("Class")){
			new ClassCommand(commandName, command, sender, args);
		}else{
			sender.sendMessage(error);
		}

	}




}
