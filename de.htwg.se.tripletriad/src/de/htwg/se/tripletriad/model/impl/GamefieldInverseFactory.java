package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.IGamefieldFactory;
import de.htwg.se.tripletriad.model.IGamefield;

public class GamefieldInverseFactory implements IGamefieldFactory {

    @Override
    public IGamefield creat() {
        
        return new GamefieldInverse();
    }
}
