package de.htwg.se.tripletriad.aview.tui;

import java.util.*;

import de.htwg.se.tripletriad.controller.impl.GameStatus;

public class StatusMessage  {
	
	static Map<GameStatus, String> textSeMe = new Hashtable<GameStatus, String>();
	
	public StatusMessage(){
		textSeMe.put(GameStatus.WELCOME, "Triple Triad");
		textSeMe.put(GameStatus.CARD_SET, "Set Card succeed");
		textSeMe.put(GameStatus.ILLEGAL_CARD,"Card out of range");
		textSeMe.put(GameStatus.ILLEGAL_POS,"Slot out of range");
		textSeMe.put(GameStatus.CREATE,"Triple Triad has just begun");
		textSeMe.put(GameStatus.RESET,"Triple Triad has just been reset");
	}

}
