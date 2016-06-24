package de.htwg.se.tripletriad.util.singleton;

public class SingleObject {

	   private static SingleObject instance = new SingleObject();

	   private SingleObject(){
		   
	   }

	   public static SingleObject getInstance() {
	      return instance;
	   }

	   public String showMessage() {
	      return "Spielzug:";
	   }
	
	}