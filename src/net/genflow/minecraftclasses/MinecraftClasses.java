package net.genflow.minecraftclasses;

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
		
	}
	
	
	@Override
	public void onDisable() {
		this.getServer().getPluginManager();
		getLogger().info("Version " + getDescription().getVersion() + " has been disabled!");
	}
	
}
