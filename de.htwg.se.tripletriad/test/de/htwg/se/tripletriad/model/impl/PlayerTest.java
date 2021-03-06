package de.htwg.se.tripletriad.model.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import de.htwg.se.tripletriad.model.impl.Player;

import org.junit.Before;

public class PlayerTest {
	
	private Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("Denis", 'r');
	}
	
	@Test 
	public void testGetName(){
		assertEquals("Denis", player.getName());
	}
	
	@Test
	public void testGetColor(){
		assertEquals('r', player.getColor());
	}
	
	@Test
	public void testGetTotalPoint(){
		assertNotNull(player.getTotalPoint());
	}
	
	@Test
	public void testIncreasePoint() {
		assertEquals(6, player.increasePoint());
	}
	
	@Test
	public void testDecreasePoint() {
		assertEquals(4, player.decreasePoint());
	}

	@Test
	public void testGetDeck() {
		assertNotNull(player.getDeck());
	}
	
	@Test
	public void testAddToDeck() {
	    Card newC = new Card("new", 1, 1, 1, 1);
	    player.addToDeck(newC);
	    assertEquals(player.getDeck().getHand().size(), 6);
	}

}
