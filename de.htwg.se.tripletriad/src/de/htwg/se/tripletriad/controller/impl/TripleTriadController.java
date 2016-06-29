package de.htwg.se.tripletriad.controller.impl;

import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.model.*;
import de.htwg.se.tripletriad.model.impl.Player;
import de.htwg.se.tripletriad.util.collection.Collection;
import de.htwg.se.tripletriad.util.observer.Observable;
import java.util.List;
import com.google.inject.Inject;

import java.util.ArrayList;

public class TripleTriadController extends Observable implements ITripleTriadController {
		
	private GameStatus st = GameStatus.WELCOME;
	private String stText = "Quit with q";
	private IGamefield gameField;
	@SuppressWarnings("unused")
	private IGamefieldFactory gFactory;
	private List<Integer> usedSlot;
	private IPlayer playerBlue, playerRed, currentP;
	
	private int counter = 0;
	
	@Inject
	public TripleTriadController(IGamefieldFactory gFactory){
	    this.gFactory = gFactory;
	    this.gameField = gFactory.creat();
	    
	    playerRed = new Player("Player 1, b", 'b');
	    playerBlue = new Player("Player 2, r", 'r');

	    setPlayer();
		usedSlot = new ArrayList<>();
	}
	
	@Override
	public IPlayer getPlayer(){
		return currentP;
	}
	
	@Override
	public IPlayer getPlayer1(){
		return playerBlue;
	}
	
	@Override
	public IPlayer getPlayer2(){
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

		if(usedSlot.contains(pos) || pos > 9 || pos < 1){
			st = GameStatus.ILLEGAL_POS;
			stText = Integer.toString(pos);		
		} else {
			if(currentP.getDeck().getHand().size() < card){
				st = GameStatus.ILLEGAL_CARD;
				stText = Integer.toString(card);
			} else {
			    usedSlot.add(pos);
				int changes = gameField.setCardField(currentP.getDeck().getHand().get(card), pos);
				currentP.getDeck().removeCard(card);
				updateStatus(changes);
				counter++;
			}
			
			if(counter == Collection.MAX_ACTIONS)
				return false;
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
	
	@Override
	public String getStatusText(){
		return stText;
	}
	
	@Override
	public String toString(){
		return gameField.toString();
	}
}
