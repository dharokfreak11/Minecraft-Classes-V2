package me.jestercraftgaming.classes.config;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import me.jestercraftgaming.classes.Main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class PlayerConfigHandler {

	/**
	 * Gets the config for the specified player
	 * 
	 * @param plugin
	 *            MinecraftClasses main class
	 * @param player
	 *            The player to get the config for
	 * @return The player's FileConfiguration
	 */
	public static FileConfiguration getConfig(Main plugin, Player player) {
		String fileName = player.getName() + ".yml";
		File dataFolder = new File(plugin.getDataFolder(), "Players");
		File configFile = new File(dataFolder, fileName);
		return YamlConfiguration.loadConfiguration(configFile);
	}

	/**
	 * Saves the config file for the specified player
	 * 
	 * @param plugin
	 *            MinecraftClasses main class
	 * @param player
	 *            The player to save the config for
	 */
	public static void saveConfig(Main plugin, Player player,
			FileConfiguration cfg) {
		String fileName = player.getName() + ".yml";
		File dataFolder = new File(plugin.getDataFolder(), "Players");
		dataFolder.mkdirs();
		File configFile = new File(dataFolder, fileName);
		try {
			cfg.save(configFile);
		} catch (IOException ex) {
			plugin.getLogger().log(Level.SEVERE,
					"Could not save config to " + configFile, ex);
		}
	}

	/**
	 * Saves a new file for the player
	 * 
	 * @param plugin
	 *            MinecraftClasses main class
	 * @param player
	 *            The player to save the default config for
	 */
	public static void saveDefaultConfig(Main plugin, Player player) {
		String fileName = player.getName() + ".yml";
		File dataFolder = new File(plugin.getDataFolder(), "Players");
		dataFolder.mkdirs();
		File configFile = new File(dataFolder, fileName);
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
			}
		}
	}

}
