package de.htwg.se.tripletriad.model;

public class Singlefield {

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
