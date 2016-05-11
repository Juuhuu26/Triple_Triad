package de.htwg.tripletriad.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	private Card card;
	
	@Before
	public void setCard() throws Exception {
		card = new Card("Test", 1, 1, 1, 1);
	}
	
	@Test 
	public void testSetColor() {
		card.setColor('b');
		assertEquals('b', card.getColor());
	}
	@Test
	public void testGetName() {
		assertEquals("Test", card.getName());
	}
	
	@Test
	public void testGetUp() {
		assertEquals(1, card.getUp());
	}
	
	@Test
	public void testGetDown() {
		assertEquals(1, card.getDown());
	}
	
	@Test
	public void testGetLeft() {
		assertEquals(1, card.getLeft());
	}
	
	@Test
	public void testGetRight() {
        assertEquals(1, card.getRight());
	}
	
	@Test
	public void testChangeColor() {
		card.changeColor();
		assertEquals('r', card.getColor());
		card.changeColor();
		assertEquals('b', card.getColor());
	}
	
	@Test
	public void testToString() {
		String result = card.toString();
		System.out.println(result);
		String expected = "{";
		assertEquals(expected.substring(1, 1),result.subSequence(1, 1));
	}
}