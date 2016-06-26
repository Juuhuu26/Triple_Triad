package de.htwg.se.tripletriad.aview.gui;

import java.awt.ComponentOrientation;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

import de.htwg.se.tripletriad.util.collection.Collection;

public class GameFrameBottom {
	
	static JTextField pageBottom;
	static JButton enter;
	
	public static JTextField buildBottom() {
			
		pageBottom = new JTextField("Quit with q");

		pageBottom.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
	    pageBottom.setForeground(Collection.FONT_COLOR_WHITE);
	    pageBottom.setFont(Collection.MAIN_FONT);
	    
	    pageBottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageBottom.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageBottom.setEditable(true);
	    
	    return pageBottom;
	    
	}

}
