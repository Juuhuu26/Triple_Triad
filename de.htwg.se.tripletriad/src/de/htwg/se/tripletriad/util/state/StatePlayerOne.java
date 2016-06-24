package de.htwg.se.tripletriad.util.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.se.tripletriad.aview.tui.TextUI;

public class StatePlayerOne {
	
	private static final Logger log4j = LogManager.getLogger(TextUI.class.getName());
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public void goPl1(Context context) {
		log4j.info(NEWLINE + "Player 1, it's your turn. Type something:");
	}

}