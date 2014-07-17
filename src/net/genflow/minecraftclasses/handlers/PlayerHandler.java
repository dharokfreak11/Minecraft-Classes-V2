package net.genflow.minecraftclasses.handlers;

import net.genflow.minecraftclasses.MinecraftClasses;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class PlayerHandler{


	MinecraftClasses mcClasses;

	public PlayerHandler(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}

	//Returns player class.
	public String getPlayerClass(Player player){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		return cfg.getConfigurationSection("Player-Stats").getString("Class");
	}

	//Returns player race.
	public String getPlayerRace(Player player){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		return cfg.getConfigurationSection("Player-Stats").getString("Race");
	}

	//Returns amount of player kills.
	public int getPlayerKills(Player player){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		return cfg.getConfigurationSection("Player-Stats").getInt("Kills");
	}

	//Returns amount of player deaths.
	public int getPlayerDeaths(Player player){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		return cfg.getConfigurationSection("Player-Stats").getInt("Deaths");
	}

	//Returns player level.
	public int getPlayerLevel(Player player){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		return cfg.getConfigurationSection("Player-Stats").getInt("Level");
	}

	//Sets player class.
	public void setPlayerClass(Player player, String className){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		cfg.getConfigurationSection("Player-Stats").set("Class", className);
		ConfigHandler.savePlayerConfig(mcClasses, player.getName(), cfg);
	}

	//Sets player race.
	public void setPlayerRace(Player player, String raceName){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		cfg.getConfigurationSection("Player-Stats").set("Race", raceName);
		ConfigHandler.savePlayerConfig(mcClasses, player.getName(), cfg);
	}

	//Sets the amount of player kills.
	public void setPlayerKills(Player player, int amount){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		cfg.getConfigurationSection("Player-Stats").set("Kills", amount);
		ConfigHandler.savePlayerConfig(mcClasses, player.getName(), cfg);
	}

	//Sets the amount of player deaths.
	public void setPlayerDeaths(Player player, int amount){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		cfg.getConfigurationSection("Player-Stats").set("Deaths", amount);
		ConfigHandler.savePlayerConfig(mcClasses, player.getName(), cfg);
	}

	//Sets player level.
	public void setPlayerLevel(Player player, int amount){
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		cfg.getConfigurationSection("Player-Stats").set("Level", amount);
		ConfigHandler.savePlayerConfig(mcClasses, player.getName(), cfg);
	}


}
