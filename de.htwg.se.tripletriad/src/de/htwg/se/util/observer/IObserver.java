package de.htwg.se.util.observer;

@FunctionalInterface
public interface IObserver {
    void update(Event e);
}
