package de.htwg.tripletriad.model;

public class Gamefield {

    private static final int HEIGHT = 3;
    private static final int WIDTH = 3;
    private static final String EMPTY = "       |";

    private Singlefield[][] field;

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
	
	public void setCardField(Card c, int pos_x, int pos_y){
		field[pos_x-1][pos_y-1].setCard(c);
	}
	
	public Card getCardField(int pos_x, int pos_y) {
		return field[pos_x-1][pos_y-1].getCard();
	}
/*
	private static String lineOne(Card c1, Card c2, Card c3){
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
	
	private static String lineTwo(Card c1, Card c2, Card c3){
		
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

	private static String lineThree(Card c1, Card c2, Card c3){
	
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
*/
}