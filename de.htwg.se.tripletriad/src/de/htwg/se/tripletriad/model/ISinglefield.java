package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.impl.Card;

public interface ISinglefield {
	
	/**
	 * 
	 * @param: 
	 */
	void setCard(Card card);
	
	/**
	 * 
	 * @param: 
	 */
	Card getCard();
	
	/**
	 * 
	 * @param: 
	 */
	boolean isBusy();
	
}
