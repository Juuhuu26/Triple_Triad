package de.htwg.se.tripletriad.aview.gui;

import java.awt.ComponentOrientation;
import de.htwg.se.tripletriad.aview.gui.GraphicalUI;
import de.htwg.se.tripletriad.util.collection.Collection;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class GameFrameTop {
	
	public static JTextArea buildTop() {
		
		JTextArea pageTop = new JTextArea(GraphicalUI.controller.getPlayer().getName()  + 
				", it's your turn!"
				+ "\n-------------------------" + "\nCurrent Points: \n" + 
				GraphicalUI.controller.getPlayer1().getName() + ":\t"+ GraphicalUI.controller.getPlayer1().getTotalPoint() + "\n" + 
				GraphicalUI.controller.getPlayer2().getName() + "\t"+ GraphicalUI.controller.getPlayer2().getTotalPoint() + "\n-------------------------");
		pageTop.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
	    pageTop.setForeground(Collection.FONT_COLOR_WHITE);
	    pageTop.setFont(Collection.MAIN_FONT);
	    pageTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    pageTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageTop.setEditable(false);
	    return pageTop;
	    
	}

}
