package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.ISinglefield;

public class Singlefield implements ISinglefield {

    private Card card;

    public Singlefield() {
       this.card = null;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return this.card;
    }

    public boolean isBusy(){
        return card != null;
    }
}
