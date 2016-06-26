package de.htwg.se.tripletriad.aview.gui;

import de.htwg.se.tripletriad.aview.gui.GraphicalUI;
import de.htwg.se.tripletriad.util.collection.Collection;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class GameFrameLeft {
	
	public static JTextArea buildLeft() {
		
		JTextArea pageLeft = new JTextArea(GraphicalUI.controller.getPlayer1().getName() + 
				"\n------------ \nDeck:\n\n" + GraphicalUI.controller.getPlayer1().getDeck().toString());
		pageLeft.setBackground(Collection.GAME_SIDEBAR_BACKGROUND_COLOR);
	    pageLeft.setForeground(Collection.FONT_COLOR_BLACK);
	    pageLeft.setFont(Collection.SIDEBAR_FONT);
	    pageLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageLeft.setEditable(false);
	    return pageLeft;
	    
	}

}
