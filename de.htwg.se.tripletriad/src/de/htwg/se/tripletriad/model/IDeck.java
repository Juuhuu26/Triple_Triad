package de.htwg.se.tripletriad.model;

import java.util.List;

import de.htwg.se.tripletriad.model.ICard;

public interface IDeck {

/* Getter and Setter */
    
    /**
     * Get cards from player's hand.
     * 
     * @return List of cards
     */
    List<ICard> getHand();
    
/* Methods */
    
    /**
     * Remove played cards from player's hand.
     * 
     * @param card at index
     */
    void removeCard(int index);
    
    /**
     * Add a Card to player's hand
     * @param Card
     */
    void addCard(ICard c);
    
    /**
     * Get player's hand as String
     */
    @Override
    String toString();
}
