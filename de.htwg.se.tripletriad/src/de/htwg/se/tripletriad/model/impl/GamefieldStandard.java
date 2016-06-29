package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.ICard;

public class GamefieldStandard extends Gamefield{

    @Override
    public boolean compareUp(ICard c, ICard c2){

        if(c.getColor() != c2.getColor() && c.getUp() > c2.getDown()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    @Override
    public boolean compareDown(ICard c, ICard c2){

        if(c.getColor() != c2.getColor() && c.getDown() > c2.getUp()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    @Override
    public boolean compareLeft(ICard c, ICard c2){

        if(c.getColor() != c2.getColor() && c.getLeft() > c2.getRight()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    @Override
    public boolean compareRight(ICard c, ICard c2){

        if(c.getColor() != c2.getColor() && c.getRight() > c2.getLeft()){
            c2.changeColor();
            return true;
        }
        return false;
    }
}
