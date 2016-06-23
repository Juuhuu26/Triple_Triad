package de.htwg.se.tripletriad.aview.gui;

import java.awt.Color;
import java.awt.Font;
import de.htwg.se.tripletriad.aview.gui.GraphicalUI;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class GameFrameLeft {
	
	static Font f = new Font("HelveticaNeue", Font.PLAIN, 13);
	
	public static JTextArea buildLeft() {
		
		JTextArea pageLeft = new JTextArea(GraphicalUI.controller2.getPlayer1().getName() + 
				"\n------------ \nDeck:\n\n" + GraphicalUI.controller2.getPlayer1().getDeck().toString());
		pageLeft.setBackground(Color.LIGHT_GRAY);
	    pageLeft.setForeground(Color.BLACK);
	    pageLeft.setFont(f);
	    pageLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageLeft.setEditable(false);
	    return pageLeft;
	    
	}

}
