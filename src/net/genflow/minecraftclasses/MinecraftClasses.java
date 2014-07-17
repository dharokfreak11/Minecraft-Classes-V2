package net.genflow.minecraftclasses;

import java.io.File;

import net.genflow.minecraftclasses.handlers.ConfigHandler;
import net.genflow.minecraftclasses.handlers.RaceClassHandler;
import net.genflow.minecraftclasses.handlers.SettingsHandler;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftClasses extends JavaPlugin{

	
	private static MinecraftClasses instance;

	// Allows access to the main class
	public static MinecraftClasses getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		this.getServer().getPluginManager();
		instance = this;
		getLogger().info("Version " + getDescription().getVersion() + " has been enabled!");
		checkDefaultConfig();
	}
	
	//Checks default config.
	private void checkDefaultConfig(){
		File defaultFiles = new File(getInstance().getDataFolder(), "Settings");
		File checkFile = new File(defaultFiles, "config.yml");
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(this);
		if(checkFile.exists()){
			
		}else{
			RaceClassHandler raceClassHandler = new RaceClassHandler(this);
			SettingsHandler settingsHandler = new SettingsHandler(this);
			cfg.createSection("Settings");
			cfg.createSection("Races-Classes");
			ConfigHandler.saveDefaultConfig(this, cfg);
			raceClassHandler.setClassList();
			raceClassHandler.setRaceList();
			settingsHandler.setClassesMode(true);
			settingsHandler.setRacesMode(true);
			cfg.getConfigurationSection("Settings").createSection("Gameplay-Settings");
			ConfigHandler.saveDefaultConfig(this, cfg);
			settingsHandler.setDeathMode(true);
		}
	}

	@Override
	public void onDisable() {
		this.getServer().getPluginManager();
		getLogger().info("Version " + getDescription().getVersion() + " has been disabled!");
	}
	
}
