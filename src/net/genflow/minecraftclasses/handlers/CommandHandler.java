package net.genflow.minecraftclasses.handlers;

import java.util.ArrayList;
import java.util.List;

import net.genflow.minecraftclasses.MinecraftClasses;
import net.genflow.minecraftclasses.commands.CommandManager;

public class CommandHandler{

	MinecraftClasses mcClasses;
	
	
	//Constructor
	public CommandHandler(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}

	
	//If you want to add more commands just add another string to the list.
	public List<String> getCommands(){
		List<String> commands = new ArrayList<String>();
		commands.add("Race");
		commands.add("Class");
		return commands;
	}
	
	//Registers all commands.
	public void registerAllCommands(List<String> commands){
		for(String command : commands){
			MinecraftClasses.getInstance().getCommand(command).setExecutor(new CommandManager(mcClasses));
		}
	}
	
}
