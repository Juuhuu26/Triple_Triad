package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.impl.Card;
import de.htwg.se.tripletriad.model.impl.Singlefield;

public interface IGamefield {
	
	/**
	 * 
	 * @return: returns the current field of type Singlefield
	 */
	Singlefield[][] getField();
	
	/**
	 * 
	 * @return: returns the current card on a field x, y 
	 */
	Card getCardField(int x, int y);
	
	/**
	 * 
	 * places a card with values from one to nine on a field x, y
	 */
	int setCardField(Card c, int pos);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2 
	 */
	void checkRight(Singlefield f, Card c);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2 
	 */
	void checkDown(Singlefield f, Card c);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2  
	 */
	void checkLeft(Singlefield f, Card c);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2  
	 */
	void checkUp(Singlefield f, Card c);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c up value with Card c2 down value, 
	 * then changes the winning card's color
	 */
	boolean compareUp(Card c, Card c2);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c down value with Card c2 up value, 
	 * then the method changes the winning card's color 
	 */
	boolean compareDown(Card c, Card c2);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c left value with Card c2 right value, 
	 * then the method changes the winning card's color 
	 */
	boolean compareLeft(Card c, Card c2);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c right value with Card c2 left value, 
	 * then the method changes the winning card's color
	 */
	boolean compareRight(Card c, Card c2);
	
	/**
	 * 
	 * prints Card c, Card c2 and Card 3 with position one, two and three to console 
	 */
	String lineOne(Card c, Card c2, Card c3);
	
	/**
	 * 
	 * prints Card c, Card c2 and Card 3 with position four, five and six to console
	 */
	String lineTwo(Card c, Card c2, Card c3);
	
	/**
	 * 
	 * prints Card c, Card c2 and Card 3 with position seven, eight and nine to console
	 */
	String lineThree(Card c, Card c2, Card c3);
	
	/**
	 * 
	 * prints methods lineOne, lineTwo and lineThree with delimiters 
	 */
	@Override
	String toString();
	
}
