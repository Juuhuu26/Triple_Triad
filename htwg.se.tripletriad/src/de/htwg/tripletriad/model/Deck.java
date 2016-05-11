package de.htwg.tripletriad.model;

import java.util.List;
import java.util.ArrayList;

public class Deck {
	
	private List<Card> hand;
	private static final int MAX_CARD = 5;
	
	public Deck(char c){
		hand = new ArrayList<>();
		for(int i = 0; i < MAX_CARD; i++){
			hand.add(new Card("Nataniel", 9, 9, 2, 5, c));
		}
	}
	
	public List<Card> getHand(){
		return hand;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("Order of Values is: Up, Down, Left, Right\n");
		for(int i = 0; i < this.hand.size(); i++){
			sb.append(i + 1).append(") ").append(hand.get(i).toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}

}
