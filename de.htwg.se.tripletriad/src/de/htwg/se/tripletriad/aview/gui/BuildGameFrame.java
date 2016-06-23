package de.htwg.se.tripletriad.aview.gui;

import java.awt.Font;

public class BuildGameFrame {
	
	static Font f = new Font("HelveticaNeue", Font.PLAIN, 15);
	
	private BuildGameFrame() {
		GameFrameTop.buildTop();
		GameFrameBottom.buildBottom();
		GameFrameLeft.buildLeft();
		GameFrameLeft.buildLeft();
	}
}