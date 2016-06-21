package de.htwg.se.tripletriad.model.impl;

import de.htwg.se.tripletriad.model.IGamefield;

public class Gamefield implements IGamefield {

    private static final int HEIGHT = 3;
    private static final int WIDTH = 3;
    private static final String EMPTY = "       |";

    private Singlefield[][] field;
    private int changes = 0;

    public Gamefield() {

        field = new Singlefield[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                field[i][j] = new Singlefield();
            }
        }
    }

    public Singlefield[][] getField() {
        return this.field;
    }

    public Card getCardField(int x, int y) {
        return field[x][y].getCard();
    }
    
    public int setCardField(Card c, int pos){

        switch(pos) {
        case 1:
            field[0][0].setCard(c);
            checkRight(field[1][0], c);
            checkDown(field[0][1], c);
            break;
        case 2:
            field[1][0].setCard(c);
            checkLeft(field[0][0], c);
            checkRight(field[2][0], c);
            checkDown(field[1][1], c);
            break;
        case 3:
            field[2][0].setCard(c);
            checkLeft(field[1][0], c);
            checkDown(field[2][1], c);
            break;
        case 4:
            field[0][1].setCard(c);
            checkUp(field[0][0], c);
            checkRight(field[1][1], c);
            checkDown(field[0][2], c);
            break;
        case 5:
            field[1][1].setCard(c);
            checkUp(field[1][0], c);
            checkLeft(field[0][1], c);
            checkRight(field[2][1], c);
            checkDown(field[1][2], c);
            break;
        case 6:
            field[2][1].setCard(c);
            checkUp(field[2][0], c);
            checkLeft(field[1][1], c);
            checkDown(field[2][2], c);
            break;
        case 7:
            field[0][2].setCard(c);
            checkUp(field[0][1], c);
            checkRight(field[1][2], c);
            break;
        case 8:
            field[1][2].setCard(c);
            checkLeft(field[0][2], c);
            checkUp(field[1][1], c);
            checkRight(field[2][2], c);
            break;
        case 9:
            field[2][2].setCard(c);
            checkUp(field[2][1], c);
            checkLeft(field[1][2], c);
            break;
        default:
            break;
        }
        return changes;
    }

    public void checkRight(Singlefield f, Card c) {

        Card c2;
        if(f.isBusy()){
            c2 = f.getCard();
            if(compareRight(c, c2))
                changes++;
        }
    }

    public void checkDown(Singlefield f, Card c) {

        Card c2;
        if(f.isBusy()){
            c2 = f.getCard();
            if(compareDown(c, c2))
                changes++;
        }
    }

    public void checkLeft(Singlefield f, Card c) {

        Card c2;
        if(f.isBusy()){
            c2 = f.getCard();
            if(compareLeft(c, c2))
                changes++;
        }
    }

    public void checkUp(Singlefield f, Card c) {

        Card c2;
        if(f.isBusy()){
            c2 = f.getCard();
            if(compareUp(c, c2))
                changes++;
        }
    }

    public boolean compareUp(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getUp() > c2.getDown()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    public boolean compareDown(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getDown() > c2.getUp()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    public boolean compareLeft(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getLeft() > c2.getRight()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    public boolean compareRight(Card c, Card c2){

        if(c.getColor() != c2.getColor() && c.getRight() > c2.getLeft()){
            c2.changeColor();
            return true;
        }
        return false;
    }

    public String lineOne(Card c1, Card c2, Card c3){

        StringBuilder sb = new StringBuilder();
        if(c1 != null)
            sb.append("   " + c1.getUp() + "   |");
        else
            sb.append(EMPTY);
        if(c2 != null)
            sb.append("   " + c2.getUp() + "   |");
        else
            sb.append(EMPTY);
        if(c3 != null)
            sb.append("   " + c3.getUp() + "\n");
        else
            sb.append("\n");
        return sb.toString();
    }

    public String lineTwo(Card c1, Card c2, Card c3){

        StringBuilder sb = new StringBuilder();
        if(c1 != null)
            sb.append(" " + c1.getLeft() + " " + c1.getColor() + " " + c1.getRight() + " |");
        else
            sb.append(EMPTY);
        if(c2 != null)
            sb.append(" " + c2.getLeft() + " " + c2.getColor() + " " + c2.getRight() + " |");
        else
            sb.append(EMPTY);
        if(c3 != null)
            sb.append(" " + c3.getLeft() + " " + c3.getColor() + " " + c3.getRight() + "\n");
        else
            sb.append("\n");
        return sb.toString();
    }

    public String lineThree(Card c1, Card c2, Card c3){

        StringBuilder sb = new StringBuilder();
        if(c1 != null)
            sb.append("   " + c1.getDown() + "   |");
        else
            sb.append(EMPTY);
        if(c2 != null)
            sb.append("   " + c2.getDown() + "   |");
        else
            sb.append(EMPTY);
        if(c3 != null)
            sb.append("   " + c3.getDown() + "\n");
        else
            sb.append("\n");
        return sb.toString();
        }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("\n");
        for(int j = 1; j < 12; j++){
            int rest = j%4;
            int row = j/4;
            Card c1 = field[0][row].getCard();
            Card c2 = field[1][row].getCard();
            Card c3 = field[2][row].getCard();
            if(rest == 1)
                s.append(lineOne(c1,c2,c3));
            if(rest == 2)
                s.append(lineTwo(c1,c2,c3));
            if(rest == 3)
                s.append(lineThree(c1,c2,c3));
            if(rest == 0)
                s.append("-------+-------+-------\n");
        }
        return s.toString();
    }
}