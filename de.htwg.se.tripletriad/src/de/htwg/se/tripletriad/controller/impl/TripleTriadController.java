package de.htwg.se.tripletriad.controller.impl;

import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.model.impl.*;
import de.htwg.se.tripletriad.util.collection.Collection;
import de.htwg.se.tripletriad.util.observer.Observable;

import java.util.List;
import java.util.ArrayList;

public class TripleTriadController extends Observable implements ITripleTriadController {
	
	private GameStatus st = GameStatus.WELCOME;
	private String stText = "Quit with q";
	private Gamefield gameField;
	private List<Integer> usedSlot;
	
	private Player playerBlue;
	private Player playerRed;
	private Player currentP;
	
	private int counter = 0;
	
	public TripleTriadController(){
		gameField = new Gamefield();
		playerBlue = new Player("Player 1, b", 'b');
		playerRed = new Player("Player 2, r", 'r');
		usedSlot = new ArrayList<>();
	}
	
	public Player getPlayer(){
		return currentP;
	}
	
	public Player getPlayer1(){
		return playerBlue;
	}
	
	public Player getPlayer2(){
		return playerRed;
	}
	
	public void setPlayer(){
		currentP = playerBlue;	
		notifyObservers();
	}
	
	public void switchP(){
		if(currentP == playerBlue)
			currentP = playerRed;
		else
			currentP = playerBlue;
	}
	
	private void updateStatus(int c){
		for(int i = 0; i < c; i++)
			currentP.increasePoint();
		switchP();
		for(int i = 0; i < c; i++)
			currentP.decreasePoint();
	}
		
	public boolean setCard(int card, int pos){
		try{		
			if(usedSlot.contains(pos) || pos > 9){
				st = GameStatus.ILLEGAL_POS;
				stText = Integer.toString(pos);		
			} else {
				if(currentP.getDeck().getHand().size() < card){
					st = GameStatus.ILLEGAL_CARD;
					stText = Integer.toString(card);
				} else {
					usedSlot.add(pos);
					Card c = currentP.getDeck().getHand().get(card);
					int changes = gameField.setCardField(c, pos);
					currentP.getDeck().removeCard(card);
					updateStatus(changes);
					counter++;										
				}
				
				if(counter == Collection.MAX_ACTIONS)
					return false;
			}
		} catch(IllegalArgumentException e){
			st = GameStatus.ILLEGAL_ARUMENT;
			stText = e.getMessage();
			throw e;
		}
		notifyObservers();
		return true;
	}
	
	public String getWinner(){		
		String winner;
		int p1 = playerBlue.getTotalPoint();
		int p2 = playerRed.getTotalPoint();
		if(p1 == p2)
			winner = "Tie";
		else if(p1 < p2)
			winner = "Winner is:\t"+playerRed.getName();
		else
			winner = "Winner is:\t"+playerBlue.getName();
		return winner;
	}
	
	public GameStatus getStatus(){
		return st;
	}
	
	public String getStatusText(){
		return stText;
	}
	
	@Override
	public String toString(){
		return gameField.toString();
	}
}
