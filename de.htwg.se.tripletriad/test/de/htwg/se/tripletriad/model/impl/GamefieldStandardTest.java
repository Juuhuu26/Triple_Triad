package de.htwg.se.tripletriad.model.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.tripletriad.model.impl.Card;
import de.htwg.se.tripletriad.model.impl.Gamefield;

public class GamefieldStandardTest {
    
    private Gamefield gamefield;
    private Card card1, card2, card3, card4,
                 card5, card6, card7, card8, card9;

    @Before
    public void setUp() throws Exception {
        gamefield = new GamefieldStandard();
        card1 = new Card("A", 1, 1, 1, 1);
        card1.setColor('b');
        card2 = new Card("B", 1, 1, 1, 1);
        card2.setColor('b');
        card3 = new Card("C", 1, 1, 1, 1);
        card3.setColor('b');
        card4 = new Card("D", 1, 1, 1, 1);
        card4.setColor('b');
        card5 = new Card("E", 9, 9, 9, 9);
        card5.setColor('r');
        card6 = new Card("F", 9, 9, 9, 9);
        card6.setColor('r');
        card7 = new Card("G", 9, 9, 9, 9);
        card7.setColor('r');
        card8 = new Card("H", 9, 9, 9, 9);
        card8.setColor('r');
        card9 = new Card("I", 9, 9, 9, 9);
        card9.setColor('r');
    }

    @Test
    public void testGetField(){
        gamefield.getField();
        assertNotNull(gamefield);
    }

    @Test
    public void testSetCardField(){
        gamefield.setCardField(card1, 2);
        assertEquals(card1, gamefield.getCardField(1, 0));
        gamefield.setCardField(card2, 4);
        assertEquals(card2, gamefield.getCardField(0, 1));
        gamefield.setCardField(card3, 6);
        assertEquals(card3, gamefield.getCardField(2, 1));
        gamefield.setCardField(card4, 8);
        assertEquals(card4, gamefield.getCardField(1, 2));
        gamefield.setCardField(card5, 1);
        assertEquals(card5, gamefield.getCardField(0, 0));
        gamefield.setCardField(card6, 3);
        assertEquals(card6, gamefield.getCardField(2, 0));
        gamefield.setCardField(card7, 7);
        assertEquals(card7, gamefield.getCardField(0, 2));
        gamefield.setCardField(card8, 9);
        assertEquals(card8, gamefield.getCardField(2, 2));
        gamefield.setCardField(card9, 5);
        assertEquals(card9, gamefield.getCardField(1, 1));
        gamefield.setCardField(card1, 0);
    }
    @Test
    public void testCheckRight() {
        card1.setColor('b');
        gamefield.setCardField(card1, 3);
        card5.setColor('r');
        gamefield.setCardField(card5, 2);
        assertEquals(card1.getColor(), card5.getColor());
        card2.setColor('b');
        gamefield.setCardField(card2, 1);
        assertNotEquals(card2.getColor(), card5.getColor());
    }
    
    @Test
    public void testCheckLeft() {
        card1.setColor('b');
        gamefield.setCardField(card1, 1);
        card5.setColor('r');
        gamefield.setCardField(card5, 2);
        assertEquals(card1.getColor(), card5.getColor());
        card2.setColor('b');
        gamefield.setCardField(card2, 3);
        assertNotEquals(card2.getColor(), card5.getColor());
    }
    
    @Test
    public void testCheckUp() {
        card1.setColor('b');
        gamefield.setCardField(card1, 2);
        card5.setColor('r');
        gamefield.setCardField(card5, 5);
        assertEquals(card1.getColor(), card5.getColor());
        card2.setColor('b');
        gamefield.setCardField(card2, 8);
        assertNotEquals(card2.getColor(), card5.getColor());
    }
    
    @Test
    public void testCheckDown() {
        card1.setColor('b');
        gamefield.setCardField(card1, 8);
        card5.setColor('r');
        gamefield.setCardField(card5, 5);
        assertEquals(card1.getColor(), card5.getColor());
        card2.setColor('b');
        gamefield.setCardField(card2, 2);
        assertNotEquals(card2.getColor(), card5.getColor());
    }
    
    @Test
    public void testToString() {
        gamefield.toString();
        gamefield.setCardField(card1, 1);
        gamefield.setCardField(card2, 2);
        gamefield.setCardField(card3, 3);
        gamefield.setCardField(card4, 4);
        gamefield.setCardField(card5, 5);
        gamefield.setCardField(card6, 6);
        gamefield.setCardField(card7, 7);
        gamefield.setCardField(card8, 8);
        gamefield.setCardField(card9, 9);
        gamefield.setCardField(card1, 0);
        gamefield.toString();
    }
}
