package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.IDeck;

public interface IPlayer {
	
	/**
	 * 
	 * @return: returns the player's name
	 */
	String getName();
	
	/**
	 * 
	 * @return: returns the player's color
	 */
	char getColor();
	
	/**
	 * 
	 * @return: returns the player's current deck, consists of maximum five cards
	 */
	IDeck getDeck();
	
	/**
	 * 
	 * @return: increases the player's entire point value by one, after a winning process
	 */
	int increasePoint();
	
	/**
	 * 
	 * @return: decreases the player's entire point value by one, after a losing process
	 */
	int decreasePoint();
	
	/**
	 * 
	 * @param: returns the player's current point value
	 */
	int getTotalPoint();
	
}
