package de.htwg.se.tripletriad.aview.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.htwg.se.tripletriad.controller.ITripleTriadController;
import de.htwg.se.tripletriad.util.observer.Event;
import de.htwg.se.tripletriad.util.observer.IObserver;
import de.htwg.se.tripletriad.util.state.Context;
import de.htwg.se.tripletriad.util.state.StatePlayerOne;
import de.htwg.se.tripletriad.util.state.StatePlayerTwo;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;

import org.apache.logging.log4j.LogManager;

public class TextUI implements IObserver{

    private static final String NEWLINE = System.getProperty("line.separator");
    private static final Logger LOGGER = LogManager.getLogger(TextUI.class.getName());
 
    private ITripleTriadController controller;
    
    @Inject
    public TextUI(ITripleTriadController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public void update(Event e) {
        printTUI();
    }

    public boolean processInputLine(String line) {
        boolean continu = true;
        if (line.startsWith("--quit")) {
            continu = false;
        } else
            if (line.matches("[1-5][1-9]")) {
                int[] arg = readToArray(line);
                continu = controller.setCard(arg[0]-1, arg[1]);
                printTUI();
            } else {
                LOGGER.info("Illegal command");
            }
        return continu;
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
    
    public void printTUI() {
    	
    	Context context = new Context();
    	StatePlayerOne pl1 = new StatePlayerOne();
    	StatePlayerTwo pl2 = new StatePlayerTwo();
    	
	    LOGGER.info(NEWLINE + controller.toString());
	    LOGGER.info(NEWLINE + controller.getStatusText());
	    LOGGER.info(NEWLINE + "First choose a Card, then a Slot 1-9");
	    LOGGER.info(NEWLINE + controller.getPlayer().getDeck().toString());
	    LOGGER.info(NEWLINE + "Score:");
	    LOGGER.info(NEWLINE + "Player 1, b:\t" + controller.getPlayer1().getTotalPoint());
	    LOGGER.info(NEWLINE + "Player 2, r:\t" + controller.getPlayer2().getTotalPoint());
	    
	    if (controller.getPlayer().getName() == "Player 1, b") {
	    	pl1.goPl1(context);
	    } else if (controller.getPlayer().getName() == "Player 2, r") {
	    	pl2.goPl2(context);
	    }
    }
}

