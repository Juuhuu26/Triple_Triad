package de.htwg.se.tripletriad.controller;

import de.htwg.se.tripletriad.controller.impl.GameStatus;
import de.htwg.se.tripletriad.model.impl.Player;

public interface ITripleTriadController {
	
	/**
	 * 
	 * @param: 
	 */
	Player getPlayer();
	
	/**
	 * 
	 * @param: 
	 */
	Player getPlayer1();
	
	/**
	 * 
	 * @param: 
	 */
	Player getPlayer2();
	
	/**
	 * 
	 * @param: 
	 */
	void setPlayer();
	
	/**
	 * 
	 * @param: 
	 */
	void switchP();
	
	/**
	 * 
	 * @param: 
	 */
	void updateStatus();
	
	/**
	 * 
	 * @param: 
	 */
	boolean setCard();
	
	/**
	 * 
	 * @param: 
	 */
	String getWinner();
	
	/**
	 * 
	 * @param: 
	 */
	GameStatus getStatus();
	
	/**
	 * 
	 * @param: 
	 */
	String getStatusText();
	
	/**
	 * 
	 * @param: 
	 */
	String toString();
	
}
