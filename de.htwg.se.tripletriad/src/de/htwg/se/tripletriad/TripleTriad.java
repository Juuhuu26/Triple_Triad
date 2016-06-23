package de.htwg.se.tripletriad;

import java.util.Scanner;

import de.htwg.se.tripletriad.aview.tui.*;
import de.htwg.se.tripletriad.aview.gui.*;
import de.htwg.se.tripletriad.controller.impl.*;

public class TripleTriad {
		
	private static Scanner scanner;
	private static TextUI tui;
	private static GraphicalUI gui;
	private static TripleTriadController controller;
	private static TripleTriadController controller2;

	private TripleTriad() { 
		
	}

	public static void main(String[] args) {

	    controller = new TripleTriadController();
	    controller.setPlayer();
	    
	    controller2 = new TripleTriadController();
	    controller2.setPlayer();

	    tui = new TextUI(controller);
	    tui.printTUI();
	    
	    gui = new GraphicalUI(controller2);
	    GraphicalUI.startGUI();
	    
	    boolean continu = true;
	    scanner = new Scanner(System.in);
	    while (continu) {

	        continu = tui.processInputLine(scanner.next());
	        System.out.println("Score:\nPlayer 1:\t"+controller.getPlayer1().getTotalPoint());
		    System.out.println("Player 2:\t"+controller.getPlayer2().getTotalPoint());
		    
	    }
	    
	    System.out.println("FINAL BOARD\n" + controller.toString());
	    System.out.println("Score:\nPlayer 1:\t"+controller.getPlayer1().getTotalPoint());
	    System.out.println("Player 2:\t"+controller.getPlayer2().getTotalPoint());
	    System.out.println(controller.getWinner());
	    
	}
}
