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


public class TripleTriad {
		
	private static Scanner scanner;
	private static TextUI tui;
	private static GraphicalUI gui;
	private static TripleTriad instance = null;
	private static TripleTriadController controller;
	
    private static final String NEWLINE = System.getProperty("line.separator");
	private static final Logger log4j = LogManager.getLogger(TripleTriad.class.getName());

	/* Implementation of Singleton Desing Pattern
	 * Falls keine Instanz angelegt wurde, neues Spiel aufbauen.
	 *  */
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
	    
	    controller = new TripleTriadController();
	    controller.setPlayer();

	    tui = new TextUI(controller);
	    tui.printTUI();
	    
	    gui = new GraphicalUI(controller);
	    GraphicalUI.startGUI();
	    
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
	    
	}
}
