package de.htwg.se.tripletriad.model;

public interface ICard {

/* Getter and Setter */
    
    /**
     * Get name of card.
     * 
     * @return name
     */
    String getName();
    
    /**
     * Get north value.
     * 
     * @return north value
     */
    int getUp();
    
    /**
     * Get south value.
     * 
     * @return south value
     */
    int getDown();
    
    /**
     * Get west value.
     * 
     * @return west value
     */
    int getLeft();
    
    /**
     * Get east value.
     * 
     * @return east value
     */
    int getRight();
    
    
    /**
     * Get current color of the card.
     * 
     * @return color
     */
    char getColor();
    
    /**
     * Set color of card.
     * 
     * @param color
     */
    void setColor(char color);
    
/* Methods */
    
    /**
     * Change the color of card when conquered by other player.
     */
    void changeColor();
    
    /**
     * @return Card as String
     */
    String toString();
}
