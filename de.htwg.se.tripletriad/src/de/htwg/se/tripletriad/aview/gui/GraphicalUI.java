package de.htwg.se.tripletriad.aview.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import de.htwg.se.tripletriad.controller.impl.TripleTriadController;
import de.htwg.se.tripletriad.util.observer.Event;
import de.htwg.se.tripletriad.util.observer.IObserver;


public class GraphicalUI implements IObserver {
	
	public static TripleTriadController controller2;

	public GraphicalUI() {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(GameFrameTop.buildTop(), BorderLayout.PAGE_START);
		frame.getContentPane().add(GameFrameCenter.buildCenterFrame(), BorderLayout.CENTER);
		frame.getContentPane().add(GameFrameBottom.buildBottom(), BorderLayout.PAGE_END);
		frame.getContentPane().add(GameFrameLeft.buildLeft(), BorderLayout.LINE_START);
		frame.getContentPane().add(GameFrameRight.buildRight(), BorderLayout.LINE_END);
							
		frame.setPreferredSize(new Dimension(1000,700));
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);	
		
	}
	
    public GraphicalUI(TripleTriadController controller2) {
		this.controller2 = controller2;
		controller2.addObserver(this);
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