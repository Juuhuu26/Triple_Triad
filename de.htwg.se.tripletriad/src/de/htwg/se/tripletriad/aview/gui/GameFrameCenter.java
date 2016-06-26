package de.htwg.se.tripletriad.aview.gui;


import de.htwg.se.tripletriad.aview.gui.GraphicalUI;
import de.htwg.se.tripletriad.util.collection.Collection;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class GameFrameCenter {
	
	public static JTextArea buildCenterFrame() {
		
		JTextArea center = new JTextArea(GraphicalUI.controller.toString());
		center.setBorder(BorderFactory.createEmptyBorder(20, 50, 70, 70));
		center.setEditable(true);
		center.setEditable(true);
		center.setFont(Collection.CENTER_FONT);
		return center;
		
	}
}
