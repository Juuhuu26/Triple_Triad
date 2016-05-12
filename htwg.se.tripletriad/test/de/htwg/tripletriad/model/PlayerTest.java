package de.htwg.tripletriad.model;

import static org.junit.Assert.*;

import org.junit.Test;

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
		player.increasePoint();
		assertEquals(6, player.increasePoint());
	}
	
	@Test
	public void testDecreasePoint() {
		player.decreasePoint();
		assertEquals(4, player.decreasePoint());
	}

	@Test
	public void testGetDeck() {
		assertNotNull(player.getDeck());
	}

}
