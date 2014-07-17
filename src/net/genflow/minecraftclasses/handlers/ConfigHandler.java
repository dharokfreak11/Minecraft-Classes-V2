package net.genflow.minecraftclasses.handlers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import net.genflow.minecraftclasses.MinecraftClasses;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler{

	static MinecraftClasses mcClasses;

	// Default Config
	public static FileConfiguration getDefaultConfig(MinecraftClasses plugin){
		String fileName = "config" + ".yml";
		File dataFolder = new File(MinecraftClasses.getInstance().getDataFolder(), "Settings");
		File configFile = new File(dataFolder, fileName);
		return YamlConfiguration.loadConfiguration(configFile);
	}

	// Default Config
	public static void saveDefaultConfig(MinecraftClasses plugin, FileConfiguration cfg){
		String fileName = "config" + ".yml";
		File dataFolder = new File(MinecraftClasses.getInstance().getDataFolder(), "Settings");
		dataFolder.mkdirs();
		File configFile = new File(dataFolder, fileName);
		try{
			cfg.save(configFile);
		}catch(IOException ex){
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
		}
	}

	// Player Config
	public static FileConfiguration getPlayerConfig(MinecraftClasses plugin, String name) {
		String fileName = name + ".yml";
		File dataFolder = new File(MinecraftClasses.getInstance().getDataFolder(), "Players");
		File configFile = new File(dataFolder, fileName);
		return YamlConfiguration.loadConfiguration(configFile);
	}

	// Player Config
	public static void savePlayerConfig(MinecraftClasses plugin, String name, FileConfiguration cfg) {
		String fileName = name + ".yml";
		File dataFolder = new File(MinecraftClasses.getInstance().getDataFolder(), "Players");
		dataFolder.mkdirs();
		File configFile = new File(dataFolder, fileName);
		try{
			cfg.save(configFile);
		}catch(IOException ex){
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
		}
	}

}
