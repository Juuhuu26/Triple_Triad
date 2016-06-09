package de.htwg.se.tripletriad.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck('b');
    }

    @Test
    public void testGetHand() {
        assertEquals(5, deck.getHand().size());
    }
    
    @Test
    public void testRemoveCard() {
        deck.removeCard(3);
        assertEquals(deck.getHand().size(), 4);
    }

    @Test	
    public void testToString() {
        assertEquals(deck.toString(), deck.toString());
    }
}
