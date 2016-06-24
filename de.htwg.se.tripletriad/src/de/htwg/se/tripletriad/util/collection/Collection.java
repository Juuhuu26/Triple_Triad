package de.htwg.se.tripletriad.util.collection;

import java.awt.Color;
import java.awt.Font;

public final class Collection {

    private Collection() {
    	
    }
    
    public static final int GAME_FRAME_WIDTH = 1000;
    public static final int GAME_FRAME_HEIGHT = 700;
    
    public static final int ABOUT_FRAME_WIDTH = 380;
    public static final int ABOUT_FRAME_HEIGHT = 300;
    
    public static final int MENU_FRAME_WIDTH = 200;
    public static final int MENU_FRAME_HEIGHT = 200;
    
    public static final Color MENU_GAME_BACKGROUND_COLOR = new Color(145, 163, 176);
    public static final Color GAME_SIDEBAR_BACKGROUND_COLOR = new Color(245,245,245);
    
    public static final Color FONT_COLOR_WHITE = new Color(255, 255, 255);
    public static final Color FONT_COLOR_BLACK = new Color(105, 105, 105);

    public static final Font MAIN_FONT = new Font("HelveticaNeue", Font.PLAIN, 15);
    public static final Font SIDEBAR_FONT = new Font("HelveticaNeue", Font.PLAIN, 13);
    
    public static final int MAX_ACTIONS = 9;
   
}