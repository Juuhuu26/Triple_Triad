package de.htwg.se.tripletriad.model.model;

public class Card {

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
    
    public String getName() {
        return this.name;
    }
    
    public int getUp() {
        return this.up;
	}
    
    public int getDown() {
        return this.down;
    }
    
    public int getLeft() {
        return this.left;
    }
    
    public int getRight() {
        return this.right;
    }
    
    public char getColor() {
        return this.color;
    }
    
    public void setColor(char c) {
        this.color = c;
    }
    
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