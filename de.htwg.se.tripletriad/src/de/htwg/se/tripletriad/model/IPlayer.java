package de.htwg.se.tripletriad.model;
import de.htwg.se.tripletriad.model.impl.Deck;

public interface IPlayer {
	
	/**
	 * 
	 * @param: 
	 */
	String getName();
	
	/**
	 * 
	 * @param: 
	 */
	char getColor();
	
	/**
	 * 
	 * @param: 
	 */
	Deck getDeck();
	
	/**
	 * 
	 * @param: 
	 */
	int increasePoint();
	
	/**
	 * 
	 * @param: 
	 */
	int decreasePoint();
	
	/**
	 * 
	 * @param: 
	 */
	int getTotalPoint();
	
}
