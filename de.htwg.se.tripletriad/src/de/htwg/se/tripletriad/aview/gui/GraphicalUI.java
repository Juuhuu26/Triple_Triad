package de.htwg.se.tripletriad.aview.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import de.htwg.se.tripletriad.controller.impl.TripleTriadController;
import de.htwg.se.tripletriad.util.collection.Collection;
import de.htwg.se.tripletriad.util.observer.Event;
import de.htwg.se.tripletriad.util.observer.IObserver;


public class GraphicalUI implements IObserver {
	
	public static TripleTriadController controller;

	public GraphicalUI() {
		
		// new Frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(GameFrameTop.buildTop(), BorderLayout.PAGE_START);
		frame.getContentPane().add(GameFrameCenter.buildCenterFrame(), BorderLayout.CENTER);
		frame.getContentPane().add(GameFrameBottom.buildBottom(), BorderLayout.PAGE_END);
		frame.getContentPane().add(GameFrameLeft.buildLeft(), BorderLayout.LINE_START);
		frame.getContentPane().add(GameFrameRight.buildRight(), BorderLayout.LINE_END);
							
		frame.setPreferredSize(new Dimension(Collection.GAME_FRAME_WIDTH, Collection.GAME_FRAME_HEIGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);	
		
	}
	
    public GraphicalUI(TripleTriadController controller) {
		GraphicalUI.controller = controller;
		controller.addObserver(this);
	}

    @Override
    public void update(Event e) {
        startGUI();
    }
    
	public static void startGUI() {
		StartFrame startF = new StartFrame();
	}
	
	public static void startGameGUI() {
		GraphicalUI graphicalUI = new GraphicalUI(); 
	}
}
