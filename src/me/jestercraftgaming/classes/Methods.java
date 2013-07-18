package me.jestercraftgaming.classes;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Methods {
    MinecraftClasses main;
	private String Race;
	private String Class;
	private String subClass;
	//Constructor
	public Methods(MinecraftClasses main){
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
	//Gets the players class
	public void getUserClass() {
		Class = main.userClass;
		subClass = main.userSubClass;
		getClassAttributes();
	}
	//Gets the classes stats/abilities
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
	//Gets the sub-classes abilities
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
	public void levelUp(){
		
	}
	public void getPlayerLevel(){
		
	}
	
}
