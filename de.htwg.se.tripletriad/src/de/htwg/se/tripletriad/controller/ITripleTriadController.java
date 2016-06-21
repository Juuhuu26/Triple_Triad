package de.htwg.se.tripletriad.controller;

import de.htwg.se.tripletriad.controller.impl.GameStatus;
import de.htwg.se.tripletriad.model.impl.Player;

public interface ITripleTriadController {
	
	/**
	 * 
	 * @return: returns the current player 
	 */
	Player getPlayer();
	
	/**
	 * 
	 * @return: returns player one with allocated color blue 
	 */
	Player getPlayer1();
	
	/**
	 * 
	 * @return: returns player two with allocated color red 
	 */
	Player getPlayer2();
	
	/**
	 * 
	 * sets player x as current player
	 */
	void setPlayer();
	
	/**
	 * 
	 * the method switchP switches between the two players
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
	@Override
	String toString();
	
}
