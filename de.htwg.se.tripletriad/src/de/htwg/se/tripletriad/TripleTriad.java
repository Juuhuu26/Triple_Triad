package de.htwg.se.tripletriad;

import java.util.Scanner;

import de.htwg.se.tripletriad.aview.tui.TextUI;
import de.htwg.se.tripletriad.aview.gui.GraphicalUI;
import de.htwg.se.tripletriad.controller.ITripleTriadController;
import org.apache.logging.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.apache.logging.log4j.LogManager;


public final class TripleTriad {
		
	private static Scanner scanner;
	private static TextUI tui;
//	private final static int mode = 1;
	private static TripleTriad instance = null;
	protected static ITripleTriadController controller;
    private static final String NEWLINE = System.getProperty("line.separator");
	private static final Logger LOGGER = LogManager.getLogger(TripleTriad.class.getName());

	private TripleTriad() { 
		
	    // Use TripleTriadeStrandardModule or TripleTriadInverseModul
	    Injector injector = Guice.createInjector(new TripleTriadStandardModule());
	    
	    controller = injector.getInstance(ITripleTriadController.class);
	    
	    @SuppressWarnings("unused")
	    GraphicalUI gui = injector.getInstance(GraphicalUI.class);
	    tui = injector.getInstance(TextUI.class);
	    
	    gui = new GraphicalUI(controller);
	    tui = new TextUI(controller);
	    tui.printTUI();

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
