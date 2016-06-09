package de.htwg.tripletriad.model;

import java.util.Collections;
import java.util.LinkedList;

public class CardCollection {
	
    private LinkedList<Card> list = new LinkedList<Card>();

    public CardCollection() {
    	
    this.list.add(new Card("Dodo", 4, 3, 4, 2));
    this.list.add(new Card("Tonberry", 2, 7, 2, 2));
    this.list.add(new Card("Sabotender", 2, 3, 3, 3));
    this.list.add(new Card("Spriggan", 2, 4, 4, 3));
    this.list.add(new Card("Pudding", 2, 3, 5, 4));
    this.list.add(new Card("Bomb", 3, 3, 3, 4));
    this.list.add(new Card("Mandragora", 4, 5, 3, 2));
    this.list.add(new Card("Coblyn", 3, 3, 4, 3));
    this.list.add(new Card("Morbol", 5, 5, 2, 2));
    this.list.add(new Card("Coeurl", 2, 2, 5, 5));
    this.list.add(new Card("Ahriman", 5, 2, 2, 5));
    this.list.add(new Card("Goobboue", 2, 5, 2, 5));
    this.list.add(new Card("Chocobo", 1, 7, 1, 4));

    Collections.shuffle(list);
    }
    
    public Card pull() {
    	return this.list.poll();
    }
}
