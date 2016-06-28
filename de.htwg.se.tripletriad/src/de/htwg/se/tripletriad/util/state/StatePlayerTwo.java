package de.htwg.se.tripletriad.util.state;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.htwg.se.tripletriad.aview.tui.TextUI;

public class StatePlayerTwo {
	
	private static final Logger LOGGER = LogManager.getLogger(TextUI.class.getName());
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public void goPl2(Context context) {
		LOGGER.info(NEWLINE + "Player 2, it's your turn. Type something:");
	}

}
