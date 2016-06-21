package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.ICard;

public class Card implements ICard{

    private String name;
    private int up, down, left, right;
    private char color;

    public Card(String name, int up, int down, int left, int right) {
        
        this.name = name;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getUp() {
        return this.up;
	}
    
    @Override
    public int getDown() {
        return this.down;
    }
    
    @Override
    public int getLeft() {
        return this.left;
    }
    
    @Override
    public int getRight() {
        return this.right;
    }
    
    @Override
    public char getColor() {
        return this.color;
    }
    
    public void setColor(char c) {
        this.color = c;
    }
    
    @Override
    public void changeColor() {
        
        if(this.color == 'r')
            this.color = 'b';
        else
            this.color = 'r';
    }
    
    @Override
    public String toString(){
        return this.name + ": " + this.up + ", " + this.down + ", "
                + this.left + ", " + this.right;
    }
}