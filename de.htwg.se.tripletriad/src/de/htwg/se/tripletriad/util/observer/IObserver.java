package de.htwg.se.tripletriad.util.observer;

@FunctionalInterface
public interface IObserver {
    void update(Event e);
}
