package net.genflow.minecraftclasses.handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import net.genflow.minecraftclasses.MinecraftClasses;

public class RaceClassHandler{

	MinecraftClasses mcClasses;

	//Constructor
	public RaceClassHandler(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}

	//Returns a list of races.
	public List<String> getRaces(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		return cfg.getConfigurationSection("Races-Classes").getStringList("Race-List");
	}

	//Returns a list of classes.
	public List<String> getClasses(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		return cfg.getConfigurationSection("Races-Classes").getStringList("Class-List");
	}
	
	//Sets the race list, if you want to add more just add them to the list.
	public void setRaceList(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		List<String> races = new ArrayList<String>();
		races.add("Human");
		races.add("Elf");
		races.add("Orc");
		races.add("Troll");
		cfg.getConfigurationSection("Races-Classes").set("Race-List", races);
		ConfigHandler.saveDefaultConfig(mcClasses, cfg);
	}
	
	//Sets the class list, if you want to add more just add them to the list.
	public void setClassList(){
		FileConfiguration cfg = ConfigHandler.getDefaultConfig(mcClasses);
		List<String> classes = new ArrayList<String>();
		classes.add("Warrior");
		classes.add("Priest");
		classes.add("Mage");
		classes.add("Archer");
		cfg.getConfigurationSection("Races-Classes").set("Class-List", classes);
		ConfigHandler.saveDefaultConfig(mcClasses, cfg);
	}



}
