package de.htwg.se.tripletriad.model.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.tripletriad.model.impl.Card;
import de.htwg.se.tripletriad.model.impl.Singlefield;

public class SinglefieldTest {

    private Singlefield field;

    @Before
    public void setUp() throws Exception {

        field = new Singlefield();
    }

    @Test
    public void testIsBusy() {
    	assertFalse(field.isBusy());
    }

    @Test
    public void testSetCard() {
        Card cardc = new Card("abc", 1, 2, 3, 4);
        field.setCard(cardc);
        assertEquals(field.getCard(), cardc);
        assertTrue(field.isBusy());
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
}
