package de.htwg.se.tripletriad.aview.tui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.htwg.se.tripletriad.controller.TripleTriadController;
import de.htwg.se.util.observer.Event;
import de.htwg.se.util.observer.IObserver;

public class TextUI implements IObserver{

    private static final String NEWLINE = System.getProperty("line.separator");
 
    private TripleTriadController controller;

    public TextUI(TripleTriadController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public void update(Event e) {
        printTUI();
    }

    public boolean processInputLine(String line) {
        boolean continu = true;
        if (line.startsWith("q")) {
            continu = false;
        } else
            if (line.matches("[0-4][1-9]")) {
                int[] arg = readToArray(line);
                continu = controller.setCard(arg[0]-1, arg[1]);
            } else {
                System.out.println("Illegal command");
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
        System.out.println(NEWLINE + controller.toString());
        System.out.println(NEWLINE + StatusMessage.textSeMe.get(controller.getStatus()) + controller.getStatusText());
        System.out.println(NEWLINE + controller.getPlayer().getName() + " your turn");
        System.out.println(NEWLINE + "First choose a Card, then a Slot 1-9");
        System.out.println(NEWLINE + controller.getPlayer().getDeck().toString());
    }
}
