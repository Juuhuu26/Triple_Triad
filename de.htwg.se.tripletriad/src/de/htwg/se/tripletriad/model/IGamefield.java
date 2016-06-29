package de.htwg.se.tripletriad.model;

import de.htwg.se.tripletriad.model.ICard;
import de.htwg.se.tripletriad.model.ISinglefield;

public interface IGamefield {
	
	/**
	 * 
	 * @return: returns the current field of type Singlefield
	 */
	ISinglefield[][] getField();
	
	/**
	 * 
	 * @return: returns the current card on a field x, y 
	 */
	ICard getCardField(int x, int y);
	
	/**
	 * 
	 * places a card with values from one to nine on a field x, y
	 */
	int setCardField(ICard c, int pos);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2 
	 */
	void checkRight(ISinglefield f, ICard c);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2 
	 */
	void checkDown(ISinglefield f, ICard c);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2  
	 */
	void checkLeft(ISinglefield f, ICard c);
	
	/**
	 * 
	 * checks whether Singlefield f is empty, if not - it compares Card c with Card c2  
	 */
	void checkUp(ISinglefield f, ICard c);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c up value with Card c2 down value, 
	 * then changes the winning card's color
	 */
	abstract boolean compareUp(ICard c, ICard c2);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c down value with Card c2 up value, 
	 * then the method changes the winning card's color 
	 */
	abstract boolean compareDown(ICard c, ICard c2);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c left value with Card c2 right value, 
	 * then the method changes the winning card's color 
	 */
	abstract boolean compareLeft(ICard c, ICard c2);
	
	/**
	 * 
	 * compares Card c color with Card c2 color, compares Card c right value with Card c2 left value, 
	 * then the method changes the winning card's color
	 */
	abstract boolean compareRight(ICard c, ICard c2);
	
	/**
	 * 
	 * prints Card c, Card c2 and Card 3 with position one, two and three to console 
	 */
	String lineOne(ICard c, ICard c2, ICard c3);
	
	/**
	 * 
	 * prints Card c, Card c2 and Card 3 with position four, five and six to console
	 */
	String lineTwo(ICard c, ICard c2, ICard c3);
	
	/**
	 * 
	 * prints Card c, Card c2 and Card 3 with position seven, eight and nine to console
	 */
	String lineThree(ICard c, ICard c2, ICard c3);
	
	/**
	 * 
	 * prints methods lineOne, lineTwo and lineThree with delimiters 
	 */
	@Override
	String toString();
	
}
