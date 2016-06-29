package de.htwg.se.tripletriad.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.tripletriad.controller.impl.GameStatus;
import de.htwg.se.tripletriad.controller.impl.TripleTriadController;
import de.htwg.se.tripletriad.model.impl.*;
public class TripleTriadControllerTest {

    TripleTriadController controller;
    
    @Before
    public void setUp() {
        controller = new TripleTriadController(0);
        controller = new TripleTriadController(1);
    }
    
    @Test
    public void testGetStatus() {
        assertEquals(GameStatus.WELCOME, controller.getStatus());
    }
    
    @Test
    public void testSetPlayer() {
        controller.setPlayer();
        assertEquals(controller.getPlayer(), controller.getPlayer1());
    }
    
    @Test
    public void testSwitchP() {
        controller.setPlayer();
        controller.switchP();
        assertEquals(controller.getPlayer(), controller.getPlayer2());
        controller.switchP();
        assertEquals(controller.getPlayer(), controller.getPlayer1());
    }
    
    @Test
    public void testGetStatusText() {
        controller.getStatusText();
    }

    @Test
    public void testToString() {
        controller.toString();
    }
    
    @Test
    public void setCard() {
        
        Card c1 = new Card("c1", 1, 1, 1, 1);
        c1.setColor('b');
        Card c2 = new Card("c1", 1, 1, 1, 1);
        c2.setColor('b');
        Card c3 = new Card("c1", 9, 9, 9, 9);
        c3.setColor('b');
        Card c4 = new Card("c4", 5, 5, 5, 5);
        c4.setColor('r');
        Card c5 = new Card("c5", 5, 5, 5, 5);
        c5.setColor('r');
        controller.getPlayer1().getDeck().addCard(c1);
        controller.getPlayer1().getDeck().addCard(c2);
        controller.getPlayer1().getDeck().addCard(c3);
        controller.getPlayer2().getDeck().addCard(c4);
        controller.getPlayer2().getDeck().addCard(c5);

        controller.setPlayer();
        assertEquals(controller.getPlayer(), controller.getPlayer1());
        
        controller.getWinner();
        assertEquals(controller.getWinner(), "Tie");
        controller.setCard(0, 'A');
        assertEquals(controller.getPlayer1().getDeck().getHand().size(), 8);
        controller.setCard(9, 1);
        assertEquals(controller.getPlayer1().getDeck().getHand().size(), 8);
        controller.setCard(1, 10);
        assertEquals(controller.getPlayer1().getDeck().getHand().size(), 8);
        controller.setCard(1, 0);
        assertEquals(controller.getPlayer1().getDeck().getHand().size(), 8);
        controller.setCard(5, 1);
        assertEquals(controller.getPlayer1().getDeck().getHand().size(), 7);
        controller.setCard(5, 1);
        assertEquals(controller.getPlayer2().getDeck().getHand().size(), 7);
        controller.setCard(5, 2);
        assertEquals(controller.getWinner(), "Winner is:\t"+controller.getPlayer2().getName());
        controller.setCard(5, 3);
        controller.setCard(5, 8);
        controller.setCard(5, 5);
        assertEquals(controller.getWinner(), "Winner is:\t"+controller.getPlayer1().getName());
        controller.setCard(0, 4);
        controller.setCard(0, 6);
        controller.setCard(0, 7);
        assertFalse(controller.setCard(0, 9));
    }
}
