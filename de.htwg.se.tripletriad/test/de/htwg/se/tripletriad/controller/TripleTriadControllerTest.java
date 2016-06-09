package de.htwg.se.tripletriad.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripleTriadControllerTest {

    TripleTriadController controller;
    
    @Before
    public void setUp() {
        controller = new TripleTriadController();
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
}
