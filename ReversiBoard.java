public class ReversiBoard extends Board {

    public ReversiBoard() {
    	super(8,8);
    }
    
    public void createBoard() {
    	super.createBoard(8,8);	
    	setStartingPieces(); //TODO not currently overriding due to super constructor, does not impact functionality
    }
    
    public void setStartingPieces() { //currently implementing this functionality in the Board class
    	board[3][3]='X'; 
    	board[4][4]='X';
    	board[4][3]='O';
    	board[3][4]='O';
    }
    
    public void displayBoard() {
    	System.out.println(); //formatting space around the board
    	super.displayBoard();
    	System.out.println();
    }
}