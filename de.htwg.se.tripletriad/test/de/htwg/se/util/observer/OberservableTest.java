package de.htwg.se.util.observer;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.util.observer.Event;
import de.htwg.se.util.observer.IObserver;
import de.htwg.se.util.observer.Observable;

public class OberservableTest {

    private boolean bing = false;
    private TestObserver testOb;
    private Observable testObservable;

    class TestObserver implements IObserver {
        public void update(Event e){
            bing = true;
        }
    }

    @Before
    public void setUp() throws Exception {
        testOb = new TestObserver();
        testObservable = new Observable();
        testObservable.addObserver(testOb);
    }

    @Test
    public void testNotify(){
        assertFalse(bing);
        testObservable.notifyObservers();
        assertTrue(bing);
    }

    @Test
    public void testRemove(){
        assertFalse(bing);
        testObservable.removeObserver(testOb);
        testObservable.notifyObservers();
        assertFalse(bing);
    }

    @Test
    public void testRemoveAll(){
        assertFalse(bing);
        testObservable.removeAllObservers();
        testObservable.notifyObservers();
        assertFalse(bing);
    }
}
