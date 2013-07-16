package me.jestercraftgaming.classes;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Methods {
    Main main;
	private String Race;
	private String Class;
	private String subClass;
	//Constructor
	public Methods(Main main){
		this.main = main;
	}
	//Gets the race
	public void getRace(){
		Race = main.race;
		getAttributes(null);
	}
	//Applies the attributes
	public void getAttributes(CommandSender sender){
		Player player = (Player) sender;
		if(Race.equals("Human")){
			
		}
		if(Race.equals("Dwarf")){
			
		}
		if(Race.equals("Orc")){
			
		}
		if(Race.equals("Undead")){
			
		}
			
	}
	public void getUserClass() {
		Class = main.userClass;
		subClass = main.userSubClass;
		getClassAttributes();
	}
	public void getClassAttributes() {
		if(Class.equals("Warrior")){
			getClassSubAttributes(null);
		}
		
		if(Class.equals("Archer")){
			getClassSubAttributes(null);
		}
		
		if(Class.equals("Mage")){
			getClassSubAttributes(null);
		}
		
	}
	public void getClassSubAttributes(CommandSender sender) {
		Player player = (Player) sender;
		if(subClass.equals("Fury")){
			
		}
		
		if(subClass.equals("Guard")){
			
		}
		
		if(subClass.equals("Scout")){
			
		}
		
		if(subClass.equals("Sniper")){
			
		}

		if(subClass.equals("Light")){
			
		}
	
		if(subClass.equals("Dark")){
			
		}
		if(subClass.equals("**")){
			
		}
	}
	
}
