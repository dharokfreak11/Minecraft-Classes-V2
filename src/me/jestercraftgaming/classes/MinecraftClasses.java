package me.jestercraftgaming.classes;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import me.jestercraftgaming.classes.config.ConfigHandler;
import me.jestercraftgaming.classes.config.PlayerConfigHandler;
import me.jestercraftgaming.classes.listeners.PlayerDeathListener;
import me.jestercraftgaming.classes.listeners.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftClasses extends JavaPlugin{
	
	private static MinecraftClasses instance;
	
	private Set<ConfigHandler> raceSet = new HashSet<ConfigHandler>();
	private Set<ConfigHandler> classSet = new HashSet<ConfigHandler>();
	
	Methods methods = new Methods(this);
	PlayerListener playerlistener = new PlayerListener(this); 
	PlayerDeathListener deathlistener = new PlayerDeathListener(this); 
	public static MinecraftClasses plugin;
	public boolean raceSelected;
	public String race;
	public String userClass = "**";
	public String userSubClass = "**";
	public String prefix = "[Minecraft Classes]";
	public String dieConfig;
	
	//This is what happens when the plugin is enabled
	@Override
	public void onEnable(){
		instance = this;
		saveDefaultConfig();
		getLogger().info("Minecraft Classes Version " + getDescription().getVersion() + " has been enabled!");
		Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(this), this);
		dieConfig = getConfig().getString("Die");
		loadFiles();
	}
	//This is what happens when the plugin is disabled
	@Override
	public void onDisable(){
		getLogger().info("Minecraft Classes Version " + getDescription().getVersion() + " has been disabled!");
	}
	
	//Allows access to the main class
	public static MinecraftClasses getInstance() {
		return instance;
	}
	
	private void loadFiles() {
		File classes = new File(getDataFolder(), "Classes");
		File races = new File(getDataFolder(), "Races");
		if (!classes.exists()) {
			classes.mkdirs();
		}
		if (!races.exists()) {
			races.mkdirs();
		}
		for (File f : classes.listFiles()) {
			classSet.add(new ConfigHandler(f));
		}
		for (File f : races.listFiles()) {
			raceSet.add(new ConfigHandler(f));
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){
		
		//Checks if the sender is a player
		if(sender instanceof Player){
			Player player = (Player) sender;
			FileConfiguration cfg = PlayerConfigHandler.getConfig(this, player);
			
			//Info Command
			if(Label.equalsIgnoreCase("MinecraftClasses")){
				player.sendMessage(ChatColor.AQUA + "===Minecraft-Classes===");
				player.sendMessage(ChatColor.YELLOW + "-Description:");
				player.sendMessage(ChatColor.DARK_RED + "-Commands:");
			}
			
			//Race command
			if(Label.equalsIgnoreCase("Race")){
				//Checks if the player isn't selecting another race.
				if(!cfg.getString("Race").equals("**")){
					player.sendMessage("You may not select more than one race.");
				}else{
					if(args.length == 0) {
				        sender.sendMessage(ChatColor.DARK_RED + "Wrong usage! Try /Race <Name of race>");
				        return true;
					}
					
					//Checks for the race Human
					if(args[0].equalsIgnoreCase("Human")){
						if(args.length > 1){
							player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
						}else{
							race = "Human";
							player.sendMessage("You have selected the race " + race);
							cfg.set("Race", race);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							methods.getRace();
						}
					}
					
					//Checks for the race Orc
					if(args[0].equalsIgnoreCase("Orc")){
						if(args.length > 1){
							player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
						}else{
							race = "Orc";
							player.sendMessage("You have selected the race " + race);
							cfg.set("Race", race);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							methods.getRace();
						}
					}
					
					//Checks for the race Dwarf
					if(args[0].equalsIgnoreCase("Dwarf")){
						if(args.length > 1){
							player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
						}else{
							race = "Dwarf";
							player.sendMessage("You have selected the race " + race);
							cfg.set("Race", race);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							methods.getRace();
						}
					}
					//Checks for the race Undead
					if(args[0].equalsIgnoreCase("Undead")){
						if(args.length > 1){
							player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
						}else{
							race = "Undead";
							player.sendMessage("You have selected the race " + race);
							cfg.set("Race", race);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							methods.getRace();
						}
					}
				}
			}
			
			//Class Command
			if(Label.equalsIgnoreCase("Class")){
				if(dieConfig.equals("true")){
					if(!cfg.getString("Class").equals("**") || !cfg.getString("Specialization").equals("**")){
						player.sendMessage("You may select a class when you die.");
					}else{
						if(args.length == 0) {
					        sender.sendMessage(ChatColor.DARK_RED + "Wrong usage! Try /Class <Name of class>");
					        return true;
						}
						
						//Checks args for Warrior
						if(args[0].equalsIgnoreCase("Warrior")){
							if(args.length > 1){
								player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
							}else{
								userClass = "Warrior";
								player.sendMessage("You have selected the class " + userClass);
								cfg.set("Class", userClass);
								PlayerConfigHandler.saveConfig(this, player, cfg);
								player.sendMessage("Now select your specialization. By typing /Specialization <name of specialty>.");
							}
						}
						
						//Checks args for archer
						if(args[0].equalsIgnoreCase("Archer")){
							if(args.length > 1){
								player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
							}else{
								userClass = "Archer";
								player.sendMessage("You have selected the class " + userClass);
								cfg.set("Class", userClass);
								PlayerConfigHandler.saveConfig(this, player, cfg);
								player.sendMessage("Now select your specialization. By typing /Specialization <name of specialty>.");
							}
						}
						
						//Checks args for mage
						if(args[0].equalsIgnoreCase("Mage")){
							if(args.length > 1){
								player.sendMessage(ChatColor.DARK_RED + "Too many arguments! Try /Race <name of race>");
							}else{
								userClass = "Mage";
								player.sendMessage("You have selected the class " + userClass);
								cfg.set("Class", userClass);
								PlayerConfigHandler.saveConfig(this, player, cfg);
								player.sendMessage("Now select your specialization. By typing /Specialization <name of specialty>.");
							}
						}
					}
				}else{
					//Checks for wrong usage
					if(args.length == 0) {
				        sender.sendMessage(ChatColor.DARK_RED + "Wrong usage! Try /Class <Name of class>");
				        return true;
					}
					
					//Checks args for Warrior
					if(args[0].equalsIgnoreCase("Warrior")){
						if(args.length > 1){
							
						}else{
							userClass = "Warrior";
							player.sendMessage("You have selected the class " + userClass);
							cfg.set("Class", userClass);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							player.sendMessage("Now select your specialization. By typing /Specialization <name of specialty>.");
						}
					}
					
					//Checks args for archer
					if(args[0].equalsIgnoreCase("Archer")){
						if(args.length > 1){
							
						}else{
							userClass = "Archer";
							player.sendMessage("You have selected the class " + userClass);
							cfg.set("Class", userClass);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							player.sendMessage("Now select your specialization. By typing /Specialization <name of specialty>.");
						}
					}
					
					//Checks args for mage
					if(args[0].equalsIgnoreCase("Mage")){
						if(args.length > 1){
							
						}else{
							userClass = "Mage";
							player.sendMessage("You have selected the class " + userClass);
							cfg.set("Class", userClass);
							PlayerConfigHandler.saveConfig(this, player, cfg);
							player.sendMessage("Now select your specialization. By typing /Specialization <name of specialty>.");
						}
					}
				}
				
			}
			
			//Specialization Command
			if(Label.equalsIgnoreCase("Specialization")){
				//Checks args to see if there isn't a argument
				if(args.length == 0) {
			        sender.sendMessage(ChatColor.DARK_RED + "Wrong usage! Try /Specialization <Name of specialty>.");
			        return true;
				}
				
				//Fury Specialization
				if(cfg.getString("Class").equals("Warrior")){
					if(args[0].equalsIgnoreCase("Fury")){
						userSubClass = "Fury";
						cfg.set("Specialization", userSubClass);
						PlayerConfigHandler.saveConfig(this, player, cfg);
						methods.getUserClass();
						player.sendMessage("Character customization complete!");
					}
				}
				
				//Guard Specialization
				if(cfg.getString("Class").equals("Warrior")){
					if(args[0].equalsIgnoreCase("Guard")){
						userSubClass = "Guard";
						cfg.set("Specialization", userSubClass);
						PlayerConfigHandler.saveConfig(this, player, cfg);
						methods.getUserClass();
						player.sendMessage("Character customization complete!");
					}
				}
				
				//Scout Specialization
				if(cfg.getString("Class").equals("Archer")){
					if(args[0].equalsIgnoreCase("Scout")){
						userSubClass = "Scout";
						cfg.set("Specialization", userSubClass);
						PlayerConfigHandler.saveConfig(this, player, cfg);
						methods.getUserClass();
						player.sendMessage("Character customization complete!");
					}
				}
				
				//Sniper Specialization
				if(cfg.getString("Class").equals("Archer")){
					if(args[0].equalsIgnoreCase("Sniper")){
						userSubClass = "Sniper";
						cfg.set("Specialization", userSubClass);
						PlayerConfigHandler.saveConfig(this, player, cfg);
						methods.getUserClass();
						player.sendMessage("Character customization complete!");
					}
				}
				//Light Specialization
				if(cfg.getString("Class").equals("Mage")){
					if(args[0].equalsIgnoreCase("Light")){
						userSubClass = "Light";
						cfg.set("Specialization", userSubClass);
						PlayerConfigHandler.saveConfig(this, player, cfg);
						methods.getUserClass();
						player.sendMessage("Character customization complete!");
					}
				}
				//Dark Specialization
				if(cfg.getString("Class").equals("Mage")){
					if(args[0].equalsIgnoreCase("Dark")){
						userSubClass = "Dark";
						cfg.set("Specialization", userSubClass);
						PlayerConfigHandler.saveConfig(this, player, cfg);
						methods.getUserClass();
						player.sendMessage("Character customization complete!");
					}
				}
				if(cfg.getString("Class").equals("**")){
					player.sendMessage("You need to select a class! Type /Class <name of class> to select a class.");
				}
			}
		}
		return false;
	}
}

