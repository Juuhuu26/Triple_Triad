package de.htwg.se.tripletriad.aview.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class GameFrameRight {
	
	static Font f = new Font("HelveticaNeue", Font.PLAIN, 13);
	
	public static JTextArea buildRight() {
		
		JTextArea pageRight = new JTextArea(GraphicalUI.controller2.getPlayer2().getName() + 
				"\n------------ \nDeck:\n\n" + GraphicalUI.controller2.getPlayer2().getDeck().toString());
		pageRight.setBackground(Color.LIGHT_GRAY);
	    pageRight.setForeground(Color.BLACK);
	    pageRight.setFont(f);
	    pageRight.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pageRight.setEditable(false);
		return pageRight;
		
	}

}
