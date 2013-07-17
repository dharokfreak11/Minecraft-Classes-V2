package me.jestercraftgaming.classes.listeners;

import me.jestercraftgaming.classes.MinecraftClasses;
import me.jestercraftgaming.classes.config.PlayerConfigHandler;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
	
	MinecraftClasses main;
	public String playerKilled;
	
	 
	
	public PlayerDeathListener(MinecraftClasses main){
		main = this.main;
	}
	
	@EventHandler
	public void PlayerDeathEvent(PlayerDeathEvent e){
		if(main.dieConfig.equals("true")){
			Player playerKilled = e.getEntity();
			FileConfiguration cfg = PlayerConfigHandler.getConfig(MinecraftClasses.getInstance(), playerKilled);
			cfg.set("Class", "**");
			cfg.set("Specialization", "**");
			PlayerConfigHandler.saveConfig(MinecraftClasses.getInstance(), playerKilled, cfg);
		}else{
			
		}
		
	}
	
}
