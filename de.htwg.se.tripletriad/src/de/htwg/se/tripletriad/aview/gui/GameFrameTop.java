package de.htwg.se.tripletriad.aview.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import de.htwg.se.tripletriad.aview.gui.GraphicalUI;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class GameFrameTop {
	
	static Font f = new Font("HelveticaNeue", Font.PLAIN, 15);
	
	public static JTextArea buildTop() {
		
		JTextArea pageTop = new JTextArea(GraphicalUI.controller2.getPlayer().getName()  + 
				", it's your turn!"
				+ "\n-------------------------" + "\nCurrent Points: \n" + 
				GraphicalUI.controller2.getPlayer1().getName() + ":\t5 \n" + 
				GraphicalUI.controller2.getPlayer2().getName() + 
				"\t5 \n-------------------------");
		pageTop.setBackground(Color.BLACK);
	    pageTop.setForeground(Color.WHITE);
	    pageTop.setFont(f);
	    pageTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    pageTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageTop.setEditable(false);
	    return pageTop;
	    
	}

}
