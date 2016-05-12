package de.htwg.tripletriad.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SinglefieldTest {

/* Fields */
	private Singlefield field;
	
/* Setup */	
	@Before
	public void setUp() throws Exception {
		
		field = new Singlefield();
	}
	
	@Test
	public void testGetCard() {
		field.setCard(new Card("abc", 1, 2, 3, 4));
		assertEquals("abc", field.getCard().getName());
		assertEquals(1, field.getCard().getUp());
		assertEquals(2, field.getCard().getDown());
		assertEquals(3, field.getCard().getLeft());
		assertEquals(4, field.getCard().getRight());
	}
	
	@Test
	public void testSetCard() {
		Card cardc = new Card("abc", 1, 2, 3, 4);
		field.setCard(cardc);
		assertEquals(field.getCard(), cardc);
	}
	
}
