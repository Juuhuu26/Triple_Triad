package de.htwg.se.tripletriad.util.singleton;

public class SingleObject {

	   private static SingleObject instance = new SingleObject();
	   private static SingleObject aboutInstance = new SingleObject();

	   private SingleObject(){
		   
	   }

	   public static SingleObject getInstance() {
	      return instance;
	   }
	   
	   public static SingleObject getInstanceAbout() {
		  return aboutInstance;
	   }

	   public String showMessage() {
	      return "Quit with q! TYPE '13' for Card 1 on position 3";
	   }
	   
	   public String showMessageAbout() {
		   return "Triple Triad is a card game from Final Fantasy. "
		   		+ "\n\nThis is a HTWG Konstanz project for the lesson Software Engineering.";
	   }
	
	}