package net.genflow.minecraftclasses.events;

import java.io.File;

import net.genflow.minecraftclasses.MinecraftClasses;
import net.genflow.minecraftclasses.handlers.ConfigHandler;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ServerJoinEvent implements Listener{
	
	MinecraftClasses mcClasses;

	public ServerJoinEvent(MinecraftClasses mcClasses){
		this.mcClasses = mcClasses;
	}
	
	@EventHandler
	public void onServerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		FileConfiguration cfg = ConfigHandler.getPlayerConfig(mcClasses, player.getName());
		checkConfig(player, cfg);
	}

	//Checks if player file exists, if not creates default file.
	private void checkConfig(Player player, FileConfiguration cfg){
		File playerFiles = new File(MinecraftClasses.getInstance().getDataFolder(), "Players");
		File checkPlayer = new File(playerFiles, player.getName() + ".yml");
		if(checkPlayer.exists()){
			
		}else{
			cfg.createSection("Player-Stats");
			cfg.getConfigurationSection("Player-Stats").set("Kills", 0);
			cfg.getConfigurationSection("Player-Stats").set("Deaths", 0);
			cfg.getConfigurationSection("Player-Stats").set("Race", "**");
			cfg.getConfigurationSection("Player-Stats").set("Class", "**");
			cfg.getConfigurationSection("Player-Stats").set("Level", 1);
			ConfigHandler.savePlayerConfig(mcClasses, player.getName(), cfg);
		}
	}

}
