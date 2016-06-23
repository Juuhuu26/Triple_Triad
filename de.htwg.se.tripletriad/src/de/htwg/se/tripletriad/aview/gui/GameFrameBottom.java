package de.htwg.se.tripletriad.aview.gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.htwg.se.tripletriad.util.singleton.SingleObject;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GameFrameBottom implements ActionListener {
	
	static Font f = new Font("HelveticaNeue", Font.PLAIN, 13);
	static JTextField pageBottom;
	static JButton enter;
	
	public static JTextField buildBottom() {
		
		SingleObject object = SingleObject.getInstance();
	
		pageBottom = new JTextField(object.showMessage());

		pageBottom.setBackground(Color.BLACK);
	    pageBottom.setForeground(Color.WHITE);
	    pageBottom.setFont(f);
	    
	    pageBottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    pageBottom.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pageBottom.setEditable(true);
	    
	    return pageBottom;
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
