package de.htwg.se.tripletriad.model.model;

public class Player {
	
	private String name;
	private char color;
	private int point;
	private static final int START_POINTS = 5;
	private Deck hand;
	
	public Player(String player, char c) {
		
		name = player;
		color = c;
		hand = new Deck(c);
		point = START_POINTS;
	}
	
	public String getName(){
		return name;
	}	
	
	public char getColor(){
		return color;
	}
	
	public Deck getDeck(){
		return hand;
	}

	public int increasePoint(){
		return point++;
	}
	
	public int decreasePoint(){
		return point--;
	}
	
	public int getTotalPoint(){
		return point;
	}
}
