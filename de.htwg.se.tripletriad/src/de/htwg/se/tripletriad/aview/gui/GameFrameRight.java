package de.htwg.se.tripletriad.aview.gui;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import de.htwg.se.tripletriad.util.collection.Collection;

public class GameFrameRight {
	
	public static JTextArea buildRight() {
		
		JTextArea pageRight = new JTextArea(GraphicalUI.controller.getPlayer2().getName() + 
				"\n------------ \nDeck:\n\n" + GraphicalUI.controller.getPlayer2().getDeck().toString());
		pageRight.setBackground(Collection.GAME_SIDEBAR_BACKGROUND_COLOR);
	    pageRight.setForeground(Collection.FONT_COLOR_BLACK);
	    pageRight.setFont(Collection.SIDEBAR_FONT);
	    pageRight.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pageRight.setEditable(false);
		return pageRight;
		
	}

}
