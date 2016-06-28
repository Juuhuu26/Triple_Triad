package de.htwg.se.tripletriad.aview.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.util.collection.Collection;
import de.htwg.se.tripletriad.util.observer.Event;
import de.htwg.se.tripletriad.util.observer.IObserver;

public class GraphicalUI implements IObserver {
	
	public static ITripleTriadController controller;
	JFrame menuFrame;
	JButton startButton;
	JButton aboutButton;
	JButton quitButton;
	JFrame aboutFrame;
	JFrame gameFrame;
	JTextArea center,pageLeft, pageRight, pageTop;
	JTextField pageBottom;

	public GraphicalUI(final ITripleTriadController controller) {
		
		GraphicalUI.controller = controller;
        controller.addObserver(this);
		
		menuFrame = new JFrame();
		menuFrame.setTitle("Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setLayout(new BoxLayout(menuFrame.getContentPane(), BoxLayout.Y_AXIS));
		menuFrame.setFont(Collection.MAIN_FONT);
		JPanel jP = new JPanel();
		jP.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
		
		startButton = new JButton("Start Game");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				gameFrame.setVisible(true);
				menuFrame.setVisible(false);
			}
		});
	
		aboutButton = new JButton("About");
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				aboutFrame = new JFrame();
				aboutFrame.setTitle("About");
				aboutFrame.setSize(Collection.ABOUT_FRAME_WIDTH, Collection.ABOUT_FRAME_HEIGHT);
				
				JTextArea label = new JTextArea("Triple Triad is a card game from Final Fantasy."
						+ "\nIt was created for the lesson Software Engineering.");
				label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
				label.setEditable(false);
				label.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
				label.setForeground(Collection.FONT_COLOR_WHITE);
				aboutFrame.add(label);
				aboutFrame.setVisible(true);
			}
		});
		
		quitButton = new JButton("Quit Game");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Runtime.getRuntime().halt(0);
			}
		});
		
		jP.add(startButton);
		jP.add(aboutButton);
		jP.add(quitButton);		
		jP.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		menuFrame.add(jP);
		menuFrame.setPreferredSize(new Dimension(Collection.MENU_FRAME_WIDTH, Collection.MENU_FRAME_HEIGHT));
		menuFrame.pack();
		menuFrame.setVisible(true);
		menuFrame.setResizable(false);
		
		/*---TOP_VIEW-------------------------------------------------------------------*/
		pageTop = new JTextArea(controller.getPlayer().getName()  + 
				", it's your turn!"
				+ Collection.EMPTY_LINE + "\nCurrent Points: \n" + 
				controller.getPlayer1().getName() + ":\t"+ controller.getPlayer1().getTotalPoint() + "\n" + 
				controller.getPlayer2().getName() + "\t"+ controller.getPlayer2().getTotalPoint() + Collection.EMPTY_LINE);
		pageTop.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
	    pageTop.setForeground(Collection.FONT_COLOR_WHITE);
	    pageTop.setFont(Collection.MAIN_FONT);
	    pageTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    pageTop.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageTop.setEditable(false);
	    /*-----------------------------------------------------------------------------*/
	    
	    /*---LEFT_SIDEBAR--------------------------------------------------------------*/
	    pageLeft = new JTextArea(controller.getPlayer1().getName() + 
				Collection.DECK_LINE + controller.getPlayer1().getDeck().toString());
		pageLeft.setBackground(Collection.GAME_SIDEBAR_BACKGROUND_COLOR);
	    pageLeft.setForeground(Collection.FONT_COLOR_BLACK);
	    pageLeft.setFont(Collection.SIDEBAR_FONT);
	    pageLeft.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageLeft.setEditable(false);
	    /*-----------------------------------------------------------------------------*/
	    
	    /*---RIGHT_SIDEBAR-------------------------------------------------------------*/
	    pageRight = new JTextArea(controller.getPlayer2().getName() + 
				Collection.DECK_LINE + controller.getPlayer2().getDeck().toString());
		pageRight.setBackground(Collection.GAME_SIDEBAR_BACKGROUND_COLOR);
	    pageRight.setForeground(Collection.FONT_COLOR_BLACK);
	    pageRight.setFont(Collection.SIDEBAR_FONT);
	    pageRight.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageRight.setEditable(false);
	    /*-----------------------------------------------------------------------------*/
		
	    /*---CENTER--------------------------------------------------------------------*/
	    center = new JTextArea(controller.toString());
		center.setBorder(BorderFactory.createEmptyBorder(70, 50, 70, 70));
		center.setEditable(true);
		center.setFont(Collection.CENTER_FONT);
	    /*-----------------------------------------------------------------------------*/
		
		/*---BOTTOM_VIEW---------------------------------------------------------------*/
		pageBottom = new JTextField("Quit with -q, --quit | Delete and type here:");
		pageBottom.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
	    pageBottom.setForeground(Collection.FONT_COLOR_WHITE);
	    pageBottom.setFont(Collection.MAIN_FONT);
	    pageBottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageBottom.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageBottom.setEditable(true);
	    pageBottom.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent event) {
	    		String line = pageBottom.getText();
	    		if (line.startsWith("-q")) {
	    			Runtime.getRuntime().halt(0);
	    		} else if (line.startsWith("--quit")) {
	    			Runtime.getRuntime().halt(0);
	    		} else if (line.startsWith("-u")) {
	    			updateStatus();
	    		} else if (line.matches("[1-5][1-9]")) {
	                int[] arg = readToArray(line);
	                controller.setCard(arg[0]-1, arg[1]);
	                updateStatus();
	            } else {
	                pageBottom.setText("Illegal command");
	            }
	    	}
	    });
	    /*-----------------------------------------------------------------------------*/
	    
	    /*---MAIN_FRAME----------------------------------------------------------------*/
		gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("Triple Triad");
		gameFrame.getContentPane().add(pageTop, BorderLayout.PAGE_START);
		gameFrame.getContentPane().add(center, BorderLayout.CENTER);
		gameFrame.getContentPane().add(pageBottom, BorderLayout.PAGE_END);
		gameFrame.getContentPane().add(pageLeft, BorderLayout.LINE_START);
		gameFrame.getContentPane().add(pageRight, BorderLayout.LINE_END);				
		gameFrame.setPreferredSize(new Dimension(Collection.GAME_FRAME_WIDTH, Collection.GAME_FRAME_HEIGHT));
		gameFrame.pack();
		gameFrame.setVisible(false);
		gameFrame.setResizable(false);	
		/*-----------------------------------------------------------------------------*/
		
	}
	
	private static int[] readToArray(String line) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(line);
        int[] result = new int[line.length()];
        for (int i = 0; i < result.length; i++) {
            m.find();
            result[i] = Integer.parseInt(m.group());
        }
        return result;
    }
	
	public void updateStatus() {
		center.setText(controller.toString());
        pageRight.setText(controller.getPlayer2().getName() + 
                Collection.DECK_LINE + controller.getPlayer2().getDeck().toString());
        pageLeft.setText(controller.getPlayer1().getName() + 
                Collection.DECK_LINE + controller.getPlayer1().getDeck().toString());
        pageTop.setText(controller.getPlayer().getName()  + 
	", it's your turn!"
	+ Collection.EMPTY_LINE + "\nCurrent Points: \n" + 
	controller.getPlayer1().getName() + ":\t"+ controller.getPlayer1().getTotalPoint() + "\n" + 
	controller.getPlayer2().getName() + "\t"+ controller.getPlayer2().getTotalPoint() + Collection.EMPTY_LINE);
	}
	
    @Override
    public void update(Event e) {
        center.setText(controller.toString());
    }
    
	public static void startGUI() {
		new GraphicalUI(controller);
	}
}
