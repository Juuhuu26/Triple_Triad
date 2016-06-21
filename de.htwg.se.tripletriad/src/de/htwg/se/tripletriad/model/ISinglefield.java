package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.impl.Card;

public interface ISinglefield {
	
	/**
	 * 
	 * sets the current card
	 */
	void setCard(Card card);
	
	/**
	 * 
	 * @return: returns the current card 
	 */
	Card getCard();
	
	/**
	 * 
	 * @return: returns that the card is not disparate null
	 */
	boolean isBusy();
	
}
