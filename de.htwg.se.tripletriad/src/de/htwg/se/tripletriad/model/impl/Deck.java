package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.IDeck;
import de.htwg.se.tripletriad.model.ICard;

import java.util.List;
import java.util.ArrayList;

public class Deck implements IDeck{

    CardCollection cardList = new CardCollection();
    private List<ICard> hand;
    private static final int MAX_CARD = 5;

    public Deck(char c){
        hand = new ArrayList<>();
        for(int i = 0; i < MAX_CARD; i++){
            Card card = cardList.pull();
            card.setColor(c);
            hand.add(card);
        }
    }

    @Override
    public List<ICard> getHand(){
        return hand;
    }
    
    @Override
    public void removeCard(int x) {
        hand.remove(x);
    }
    
    @Override
    public void addCard(ICard c) {
        hand.add(c);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Order of Values is: Up, Down, Left, Right\n\n");
        for(int i = 0; i < this.hand.size(); i++){
            sb.append(i + 1).append(") ").append(hand.get(i).toString());
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
