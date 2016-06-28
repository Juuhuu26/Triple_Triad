package de.htwg.se.tripletriad;

import java.util.Scanner;

import de.htwg.se.tripletriad.aview.tui.TextUI;
import de.htwg.se.tripletriad.aview.gui.*;
import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.controller.impl.TripleTriadController; 
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public final class TripleTriad {
		
	private static Scanner scanner;
	private static TextUI tui;
	private static GraphicalUI gui;
	private static TripleTriad instance = null;
	private static ITripleTriadController controller;
    private static final String NEWLINE = System.getProperty("line.separator");
	private static final Logger LOGGER = LogManager.getLogger(TripleTriad.class.getName());

	private TripleTriad() { 
		
	    controller = new TripleTriadController();
	    controller.setPlayer();

	    tui = new TextUI(controller);
	    tui.printTUI();
	    
	    gui = new GraphicalUI(controller);
	    gui.startGUI();
	    
	}
	
	/* 
	 * Implementation of the Singleton Design Pattern to create a new instance if no ones built
	 */
	public static TripleTriad getInstance() {
		if (instance == null) {
			LOGGER.info(NEWLINE + "Spiel wird aufgebaut..");
			instance = new TripleTriad();
		}
		return instance;
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
	    LOGGER.info(NEWLINE + "FINAL BOARD\n" + controller.toString());
	    LOGGER.info(NEWLINE + "Score:\nPlayer 1:\t"+controller.getPlayer1().getTotalPoint());
	    LOGGER.info(NEWLINE + "Player 2:\t"+controller.getPlayer2().getTotalPoint());
	    LOGGER.info(NEWLINE + controller.getWinner());
	    
	}
}
