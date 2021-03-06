package de.htwg.se.tripletriad.controller;

import de.htwg.se.tripletriad.controller.impl.GameStatus;
import de.htwg.se.tripletriad.model.IPlayer;
import de.htwg.se.tripletriad.util.observer.IObservable;

public interface ITripleTriadController extends IObservable {
	
	/**
	 * 
	 * @return: returns the current player 
	 */
	IPlayer getPlayer();
	
	/**
	 * 
	 * @return: returns player one with allocated color blue 
	 */
	IPlayer getPlayer1();
	
	/**
	 * 
	 * @return: returns player two with allocated color red 
	 */
	IPlayer getPlayer2();
	
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
	void updateStatus(int c);
	
	/**
	 * 
	 * @param: 
	 */
	boolean setCard(int card, int pos);
	
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
