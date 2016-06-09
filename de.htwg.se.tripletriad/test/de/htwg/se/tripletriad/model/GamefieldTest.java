package de.htwg.se.tripletriad.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.tripletriad.model.Card;
import de.htwg.se.tripletriad.model.Gamefield;

public class GamefieldTest {
	
	private Gamefield gamefield;
	private Card carda, cardb;
	

	@Before
	public void setUp() throws Exception {
		gamefield = new Gamefield();
		carda = new Card("A", 1, 1, 1, 1);
		cardb = new Card("B", 1, 2, 3, 4);
		gamefield.setCardField(cardb, 1, 2);
	}
	
	@Test
	public void testGetField(){
		gamefield.getField();
	}
	
	@Test
	public void testSetCardField(){
		gamefield.setCardField(carda, 1, 1);
		assertEquals(carda, gamefield.getCardField(1, 1));
	}
	
}
