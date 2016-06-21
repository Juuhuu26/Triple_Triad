package de.htwg.se.tripletriad;

import java.util.Scanner;

import de.htwg.se.tripletriad.aview.tui.*;
import de.htwg.se.tripletriad.controller.impl.*;

public class TripleTriad {
		
	private static Scanner scanner;
	private static TextUI tui;
	private static TripleTriadController controller;

	/* Constructor */
	private TripleTriad(){}

	/* Methods */
	public static void main(String[] args) {

	    // Build up the application
	    controller = new TripleTriadController();
	    controller.setPlayer();

	    tui = new TextUI(controller);
	    tui.printTUI();
	    

	    // continue to read user input on the tui until the user decides to quit
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
