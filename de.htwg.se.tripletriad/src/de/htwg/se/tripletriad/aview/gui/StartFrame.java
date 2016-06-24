package de.htwg.se.tripletriad.aview.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import de.htwg.se.tripletriad.util.singleton.*;

public class StartFrame implements ActionListener {
	
	JFrame mainFrame;
	JButton startButton;
	JButton aboutButton;
	JButton quitButton;
	JFrame aboutFrame;
	JFrame modeFrame;
	Font f = new Font("HelveticaNeue", Font.PLAIN, 15);
	
	public StartFrame() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
		mainFrame.setFont(f);
		
		JPanel jP = new JPanel();
		jP.setBackground(Color.GRAY);
		
		startButton = new JButton("Start Game");
		startButton.addActionListener(this);
		
		aboutButton = new JButton("About");
		aboutButton.addActionListener(this);
		
		quitButton = new JButton("Quit Game");
		quitButton.addActionListener(this);
		
		jP.add(startButton);
		jP.add(aboutButton);
		jP.add(quitButton);
		
		jP.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		mainFrame.add(jP);
		mainFrame.setPreferredSize(new Dimension(200,200));
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
	}
	
	public void aboutFrame() {
		
		modeFrame = new JFrame();
		modeFrame.setTitle("About");
		modeFrame.setSize(480, 300);
		SingleObject object = SingleObject.getInstanceAbout();
		
		JTextArea label = new JTextArea(object.showMessageAbout());
		label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));
		label.setEditable(false);
		label.setBackground(new Color(107, 106, 104));
		label.setForeground(Color.WHITE);
		
		modeFrame.add(label);
		modeFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed (ActionEvent in){
		if(in.getSource() == this.startButton) {
			GraphicalUI.startGameGUI();
			mainFrame.dispose();
		}
		if(in.getSource() == this.aboutButton) {
            aboutFrame();
		}
		if(in.getSource() == this.quitButton) {
			System.exit(0);
		}
    }

}
