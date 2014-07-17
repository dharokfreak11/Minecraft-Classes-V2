package net.genflow.minecraftclasses.commands;

import net.genflow.minecraftclasses.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RaceCommand implements CommandInterface{

	String noPermission = "===[" + ChatColor.AQUA + "Race" + ChatColor.WHITE + "]===\n" + ChatColor.RED + "[ERROR] - You do not have permission to access this command!";
	String noCommand = "===[" + ChatColor.AQUA + "Race" + ChatColor.WHITE + "]===\n" + ChatColor.RED + "[ERROR] - No such command!";
	
	
	//Constructor
	public RaceCommand(String commandName, Command command, CommandSender sender, String[] args){
		String type;
		
		//If sender is instance of a player.
		if(isSenderPlayer(sender)){
			Player player = (Player) sender;
			
			//If the argument length is equal to the minimum length.
			if(args.length == minimumArgs()){
				//Info command implementation.
			}else{
				
				//If the armument is equal to...
				if(args[0].equalsIgnoreCase("Select")){
					type = "Race";
					
					//If player has permission for the argument.
					if(doesPlayerHavePermission(player, "Select")){
						new SelectCommand(player, args, type);
					}else{
						player.sendMessage(noPermission);
					}
				}else if(args[0].equalsIgnoreCase("Info")){
					
					//If player has permission for the argument.
					if(doesPlayerHavePermission(player, "Info")){
						
					}else{
						player.sendMessage(noPermission);
					}
				}else{
					player.sendMessage(noCommand);
				}
			}
		}
	}

	//Returns whether the sender of the command is instance of a player.
	public boolean isSenderPlayer(CommandSender sender){
		if(sender instanceof Player){
			return true;
		}else{
			return false;
		}
	}

	//Returns whether the player has permission for the command.
	public boolean doesPlayerHavePermission(Player player, String commandName){
		
		//If the command name is equal to...
		if(commandName.equalsIgnoreCase("Select")){
			
			//Checks if player has permission to a set field in class Permissions.
			if(player.hasPermission(new Permissions().raceSelectCommand)){
				return true;
			}else{
				return false;
			}
		}else if(commandName.equalsIgnoreCase("Info")){
			
			//Checks if player has permission to a set field in class Permissions.
			if(player.hasPermission(new Permissions().raceInfoCommand)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	//Returns minimum arguments of the command.
	public int minimumArgs(){
		return 0;
	}

	//Returns maximum arguments of the command.
	public int maximumArgs(){
		return 2;
	}

}
