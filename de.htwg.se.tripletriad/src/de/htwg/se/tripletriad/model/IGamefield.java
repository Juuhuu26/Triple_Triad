package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.impl.Card;
import de.htwg.se.tripletriad.model.impl.Singlefield;

public interface IGamefield {
	
	/**
	 * 
	 * @param: 
	 */
	Singlefield[][] getField();
	
	/**
	 * 
	 * @param: 
	 */
	Card getCardField(int x, int y);
	
	/**
	 * 
	 * @param: 
	 */
	int setCardField(Card c, int pos);
	
	/**
	 * 
	 * @param: 
	 */
	void checkRight(Singlefield f, Card c);
	
	/**
	 * 
	 * @param: 
	 */
	void checkDown(Singlefield f, Card c);
	
	/**
	 * 
	 * @param: 
	 */
	void checkLeft(Singlefield f, Card c);
	
	/**
	 * 
	 * @param: 
	 */
	void checkUp(Singlefield f, Card c);
	
	/**
	 * 
	 * @param: 
	 */
	boolean compareUp(Card c, Card c2);
	
	/**
	 * 
	 * @param: 
	 */
	boolean compareDown(Card c, Card c2);
	
	/**
	 * 
	 * @param: 
	 */
	boolean compareLeft(Card c, Card c2);
	
	/**
	 * 
	 * @param: 
	 */
	boolean compareRight(Card c, Card c2);
	
	/**
	 * 
	 * @param: 
	 */
	String lineOne(Card c, Card c2, Card c3);
	
	/**
	 * 
	 * @param: 
	 */
	String lineTwo(Card c, Card c2, Card c3);
	
	/**
	 * 
	 * @param: 
	 */
	String lineThree(Card c, Card c2, Card c3);
	
	/**
	 * 
	 * @param: 
	 */
	@Override
	String toString();
	
}
