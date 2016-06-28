package de.htwg.se.tripletriad;

import java.util.Scanner;

import de.htwg.se.tripletriad.aview.tui.TextUI;
import de.htwg.se.tripletriad.aview.gui.*;
import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.controller.impl.TripleTriadController; 
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public final class TripleTriad {
		
	private static Scanner scanner;
	private static TextUI tui;
	private static GraphicalUI gui;
	private static TripleTriad instance = null;
	private static ITripleTriadController controller;
	
    private static final String NEWLINE = System.getProperty("line.separator");
	private static final Logger log4j = LogManager.getLogger(TripleTriad.class.getName());

	/* 
	 * Implementation of the Singleton Design Pattern to create a new instance if no ones built
	 */
	public static TripleTriad getInstance() {
		if (instance == null) {
			log4j.info(NEWLINE + "Spiel wird aufgebaut..");
			instance = new TripleTriad();
		}
		return instance;
	}
	
	private TripleTriad() { 
	
	    controller = new TripleTriadController();
	    controller.setPlayer();

	    tui = new TextUI(controller);
	    tui.printTUI();
	    
	    gui = new GraphicalUI(controller);
	    gui.startGUI();
	    
	}
	
	
	public TextUI getTUI() {
		return tui;
	}

	public static void main(String[] args) {

		TripleTriad.getInstance();
				
	    boolean continu = true;
	    scanner = new Scanner(System.in);
	    while (continu) {
	        continu = tui.processInputLine(scanner.next());
	    }
	    System.out.println("FINAL BOARD\n" + controller.toString());
	    System.out.println("Score:\nPlayer 1:\t"+controller.getPlayer1().getTotalPoint());
	    System.out.println("Player 2:\t"+controller.getPlayer2().getTotalPoint());
	    System.out.println(controller.getWinner());
	    
	}
}
