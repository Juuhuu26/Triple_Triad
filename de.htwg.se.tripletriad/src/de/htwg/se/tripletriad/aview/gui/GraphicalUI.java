package de.htwg.se.tripletriad.aview.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.htwg.se.tripletriad.controller.impl.TripleTriadController;
import de.htwg.se.tripletriad.util.collection.Collection;
import de.htwg.se.tripletriad.util.observer.Event;
import de.htwg.se.tripletriad.util.observer.IObserver;


public class GraphicalUI implements IObserver {
	
	public static TripleTriadController controller;

	public GraphicalUI() {
		
		/*---TOP_VIEW-------------------------------------------------------------------*/
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
	    /*-----------------------------------------------------------------------------*/
	    
	    /*---LEFT_SIDEBAR--------------------------------------------------------------*/
	    JTextArea pageLeft = new JTextArea(GraphicalUI.controller.getPlayer1().getName() + 
				"\n------------ \nDeck:\n\n" + GraphicalUI.controller.getPlayer1().getDeck().toString());
		pageLeft.setBackground(Collection.GAME_SIDEBAR_BACKGROUND_COLOR);
	    pageLeft.setForeground(Collection.FONT_COLOR_BLACK);
	    pageLeft.setFont(Collection.SIDEBAR_FONT);
	    pageLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageLeft.setEditable(false);
	    /*-----------------------------------------------------------------------------*/
	    
	    /*---RIGHT_SIDEBAR-------------------------------------------------------------*/
	    JTextArea pageRight = new JTextArea(GraphicalUI.controller.getPlayer2().getName() + 
				"\n------------ \nDeck:\n\n" + GraphicalUI.controller.getPlayer2().getDeck().toString());
		pageLeft.setBackground(Collection.GAME_SIDEBAR_BACKGROUND_COLOR);
	    pageLeft.setForeground(Collection.FONT_COLOR_BLACK);
	    pageLeft.setFont(Collection.SIDEBAR_FONT);
	    pageLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageLeft.setEditable(false);
	    /*-----------------------------------------------------------------------------*/
		
	    /*---CENTER--------------------------------------------------------------------*/
	    JTextArea center = new JTextArea(GraphicalUI.controller.toString());
		center.setBorder(BorderFactory.createEmptyBorder(20, 50, 70, 70));
		center.setEditable(true);
		center.setEditable(true);
		center.setFont(Collection.CENTER_FONT);
	    /*-----------------------------------------------------------------------------*/
		
		/*---BOTTOM_VIEW---------------------------------------------------------------*/
		JTextField pageBottom = new JTextField("Quit with -q, --quit | Delete and type here:");
		pageBottom.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
	    pageBottom.setForeground(Collection.FONT_COLOR_WHITE);
	    pageBottom.setFont(Collection.MAIN_FONT);
	    pageBottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageBottom.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageBottom.setEditable(true);
	    pageBottom.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		String line = pageBottom.getText();
	    		if (line.startsWith("-q")) {
	    			System.exit(0);
	    		} else if (line.startsWith("--quit")) {
	    			System.exit(0);
	    		}
	    	}
	    });
	    /*-----------------------------------------------------------------------------*/
	    
	    /*---MAIN_FRAME----------------------------------------------------------------*/
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pageTop, BorderLayout.PAGE_START);
		frame.getContentPane().add(center, BorderLayout.CENTER);
		frame.getContentPane().add(pageBottom, BorderLayout.PAGE_END);
		frame.getContentPane().add(pageLeft, BorderLayout.LINE_START);
		frame.getContentPane().add(pageRight, BorderLayout.LINE_END);				
		frame.setPreferredSize(new Dimension(Collection.GAME_FRAME_WIDTH, Collection.GAME_FRAME_HEIGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);	
		/*-----------------------------------------------------------------------------*/
		
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
		StartFrame startFrame = new StartFrame();
	}
}
