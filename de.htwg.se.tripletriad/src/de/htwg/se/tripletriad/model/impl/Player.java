package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.IPlayer;

public class Player implements IPlayer {
	
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
	
	@Override
	public String getName(){
		return name;
	}	
	
	@Override
	public char getColor(){
		return color;
	}
	
	@Override
	public Deck getDeck(){
		return hand;
	}

	@Override
	public int increasePoint(){
		return ++point;
	}
	
	@Override
	public int decreasePoint(){
		return --point;
	}
	
	@Override
	public int getTotalPoint(){
		return point;
	}
	
	public void addToDeck(Card c) {
	    hand.addCard(c);
	}
}
