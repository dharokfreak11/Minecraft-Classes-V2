package net.genflow.minecraftclasses.commands;

import net.genflow.minecraftclasses.Permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClassCommand implements CommandInterface{


	String noPermission = "===[" + ChatColor.AQUA + "Class" + ChatColor.WHITE + "]===\n" + ChatColor.RED + "[ERROR] - You do not have permission to access this command!";
	String noCommand = "===[" + ChatColor.AQUA + "Class" + ChatColor.WHITE + "]===\n" + ChatColor.RED + "[ERROR] - No such command!";
	
	//Constructor
	public ClassCommand(String commandName, Command command, CommandSender sender, String[] args){
		String type;
		
		//If sender is instance of a player.
		if(isSenderPlayer(sender)){
			Player player = (Player) sender;
			
			//If the argument length is minimum.
			if(args.length == minimumArgs()){
				
			}else{
				
				//If the second argument of the command is...
				if(args[0].equalsIgnoreCase("Select")){
					type = "Class";
					
					//If the player has permission for the command.
					if(doesPlayerHavePermission(player, "Select")){
						new SelectCommand(player, args, type);
					}else{
						player.sendMessage(noPermission);
					}
				}else if(args[0].equalsIgnoreCase("Info")){
					
					//If the player has permission for the command.
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
		if(commandName.equalsIgnoreCase("Select")){
			if(player.hasPermission(new Permissions().classSelectCommand)){
				return true;
			}else{
				return false;
			}
		}else if(commandName.equalsIgnoreCase("Info")){
			if(player.hasPermission(new Permissions().classInfoCommand)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	//The minimum arguments of the command.
	public int minimumArgs(){
		return 0;
	}

	//The maximum arguments of the command.
	public int maximumArgs(){
		return 2;
	}

}
