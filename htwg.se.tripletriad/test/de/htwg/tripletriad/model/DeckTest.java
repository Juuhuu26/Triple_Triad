package de.htwg.tripletriad.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	private Deck deck;

/* Setup */
	@Before
	public void setUp() throws Exception {
		deck = new Deck('b');
	}
	
/* Test */
	@Test
	public void testGetHand() {
		assertEquals(5, deck.getHand().size());
	}

	@Test
	public void testToString() {
		assertEquals(deck.toString(), deck.toString());
	}
}
