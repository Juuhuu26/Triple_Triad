package de.htwg.se.tripletriad.controller.impl;

import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.model.impl.*;
import de.htwg.se.tripletriad.util.collection.Collection;
import de.htwg.se.tripletriad.util.observer.Event;
import de.htwg.se.tripletriad.util.observer.IObservable;
import de.htwg.se.tripletriad.util.observer.IObserver;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;

@Singleton
public class TripleTriadController implements IObservable, ITripleTriadController {
		
	
	private GameStatus st = GameStatus.WELCOME;
	private String stText = "Quit with q";
	private Gamefield gameField;
	private List<Integer> usedSlot;
	private Player playerBlue;
	private Player playerRed;
	private Player currentP;
	
	private int counter = 0;
	
	@Inject
	public TripleTriadController(){
		gameField = new Gamefield();
		playerBlue = new Player("Player 1, b", 'b');
		playerRed = new Player("Player 2, r", 'r');
		usedSlot = new ArrayList<>();
	}
	
	@Override
	public Player getPlayer(){
		return currentP;
	}
	
	@Override
	public Player getPlayer1(){
		return playerBlue;
	}
	
	@Override
	public Player getPlayer2(){
		return playerRed;
	}
	
	@Override
	public void setPlayer(){
		currentP = playerBlue;	
		notifyObservers();
	}
	
	@Override
	public void switchP(){
		if(currentP == playerBlue)
			currentP = playerRed;
		else
			currentP = playerBlue;
	}
	
	@Override
	public void updateStatus(int c){
		for(int i = 0; i < c; i++)
			currentP.increasePoint();
		switchP();
		for(int i = 0; i < c; i++)
			currentP.decreasePoint();
	}
		
	@Override
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
	
	@Override
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
	
	@Override
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

	@Override
	public void addObserver(IObserver s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(IObserver s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers(Event e) {
		// TODO Auto-generated method stub
		
	}
}
