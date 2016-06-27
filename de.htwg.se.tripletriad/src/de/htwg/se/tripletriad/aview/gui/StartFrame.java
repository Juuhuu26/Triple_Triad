package de.htwg.se.tripletriad.aview.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import de.htwg.se.tripletriad.util.collection.Collection;

public class StartFrame {
	
	JFrame mainFrame;
	JButton startButton;
	JButton aboutButton;
	JButton quitButton;
	JFrame aboutFrame;
	
	public StartFrame() {
		
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
		mainFrame.setFont(Collection.MAIN_FONT);
		JPanel jP = new JPanel();
		jP.setBackground(Collection.MENU_GAME_BACKGROUND_COLOR);
		
		startButton = new JButton("Start Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				GraphicalUI graphicalUI = new GraphicalUI();
				mainFrame.dispose();
			}
		});
	
		aboutButton = new JButton("About");
		aboutButton.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		jP.add(startButton);
		jP.add(aboutButton);
		jP.add(quitButton);		
		jP.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainFrame.add(jP);
		mainFrame.setPreferredSize(new Dimension(Collection.MENU_FRAME_WIDTH, Collection.MENU_FRAME_HEIGHT));
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}

}
