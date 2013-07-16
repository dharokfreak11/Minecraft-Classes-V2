package me.jestercraftgaming.classes.listeners;

import java.io.File;
import java.util.List;

import me.jestercraftgaming.classes.MinecraftClasses;
import me.jestercraftgaming.classes.config.PlayerConfigHandler;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener{
	MinecraftClasses main;
	//Constuctor
	public PlayerListener(MinecraftClasses main){
		this.main = main;
	}
	//Handeler
	@EventHandler
	public void playerFile(PlayerJoinEvent e) {
		File playerFiles = new File(main.getDataFolder(), "Players");
		File checkPlayer = new File(playerFiles, e.getPlayer().getName()
				+ ".yml");
		Player player = e.getPlayer();
		if (!checkPlayer.exists()) {
			FileConfiguration cfg = PlayerConfigHandler.getConfig(main,
					player);
			if (cfg.contains("Class")) {
				return;
			}
			PlayerConfigHandler.saveDefaultConfig(main, player);
			if (!cfg.contains("Race") || cfg == null) {
				cfg.set("Race", "**");
			}
			if (!cfg.contains("Class") || cfg == null) {
				cfg.set("Class", "**");
			}
			if (!cfg.contains("Specialization") || cfg == null) {
				cfg.set("Specialization", "**");
			}
			if (!cfg.contains("Level") || cfg == null) {
				cfg.set("Level", "1");
			}
			PlayerConfigHandler.saveConfig(main, player, cfg);
		}
	}
}
