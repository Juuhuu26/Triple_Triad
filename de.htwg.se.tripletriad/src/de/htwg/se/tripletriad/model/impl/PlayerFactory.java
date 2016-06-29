package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.IPlayer;
import de.htwg.se.tripletriad.model.IPlayerFactory;

public class PlayerFactory implements IPlayerFactory {

    @Override
    public IPlayer creat(String name, char color) {
        return new Player(name, color);
    }

}
