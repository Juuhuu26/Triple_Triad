package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.ISinglefield;

public class Singlefield implements ISinglefield {

    private Card card;

    public Singlefield() {
       this.card = null;
    }

    @Override
    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public Card getCard() {
        return this.card;
    }

    @Override
    public boolean isBusy(){
        return card != null;
    }
}
