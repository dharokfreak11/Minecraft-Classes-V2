package net.genflow.minecraftclasses.handlers;

import org.bukkit.configuration.file.FileConfiguration;

import net.genflow.minecraftclasses.MinecraftClasses;

public class SettingsHandler{


	MinecraftClasses mcClasses;

	public SettingsHandler(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}

	//Returns if races are enabled.
	public boolean isRacesEnabled(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		return cfg.getConfigurationSection("Settings").getBoolean("Races-Enabled");
	}

	//Returns if classes are enabled.
	public boolean isClassesEnabled(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		return cfg.getConfigurationSection("Settings").getBoolean("Classes-Enabled");
	}

	//Returns whether death will reset your class or race.
	public boolean onDeathReset(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		return cfg.getConfigurationSection("Settings").getConfigurationSection("Gameplay-Settings").getBoolean("Death-Reset-Enabled");
	}

	//Sets whether races are enabled or not.
	public void setRacesMode(boolean mode){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		cfg.getConfigurationSection("Settings").set("Classes-Enabled", mode);
		ConfigHandler.saveDefaultConfig(mcClasses, cfg);
	}

	//Sets whether classes are enabled or not.
	public void setClassesMode(boolean mode){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		cfg.getConfigurationSection("Settings").set("Classes-Enabled", mode);
		ConfigHandler.saveDefaultConfig(mcClasses, cfg);
	}

	//Sets whether death-mode are enabled or not.
	public void setDeathMode(boolean mode){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		cfg.getConfigurationSection("Settings").getConfigurationSection("Gameplay-Settings").set("Death-Reset-Enabled", mode);
		ConfigHandler.saveDefaultConfig(mcClasses, cfg);
	}


}
