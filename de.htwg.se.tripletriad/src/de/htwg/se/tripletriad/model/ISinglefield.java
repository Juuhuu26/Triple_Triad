package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.ICard;

public interface ISinglefield {
	
	/**
	 * 
	 * sets the current card
	 */
	void setCard(ICard card);
	
	/**
	 * 
	 * @return: returns the current card 
	 */
	ICard getCard();
	
	/**
	 * 
	 * @return: returns that the card is not disparate null
	 */
	boolean isBusy();
	
}
