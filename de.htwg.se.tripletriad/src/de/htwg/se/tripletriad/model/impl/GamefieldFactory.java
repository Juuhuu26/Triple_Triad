package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.IGamefieldFactory;
import de.htwg.se.tripletriad.model.IGamefield;

public class GamefieldFactory implements IGamefieldFactory{

    @Override
    public IGamefield creat() {
        
        return new Gamefield();
    }
}
