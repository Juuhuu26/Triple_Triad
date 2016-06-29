package de.htwg.se.tripletriad.model.impl;

public class GamefieldInverse extends Gamefield{

    @Override
    public boolean compareUp(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getUp() < c2.getDown()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    @Override
    public boolean compareDown(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getDown() < c2.getUp()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    @Override
    public boolean compareLeft(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getLeft() < c2.getRight()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    @Override
    public boolean compareRight(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getRight() < c2.getLeft()){
            c2.changeColor();
            return true;
        }
        return false;
    }
}
