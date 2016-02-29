public class Player {

	protected boolean isTurn; //TODO implement turn-taking system
	protected char[][] tempBoard; //copy of permBoard, used throughout turn, then set tempBoard to permBoard
	protected char piece; //X or O, chosen in Game class
	protected char oppPiece;
	protected int playerType; //TODO not yet implemented, Human: 0, RandomComp: 1, IntelligentComp: 2

    public Player () {
    	if(piece=='X') {oppPiece='O';} //if you are X, your opponent is O
    	if(piece=='O') {oppPiece='X';}
    }

    public void takeATurn() {
    	determinePossibleMoves(); 
    	selectAMove(); 
    }

    public void determinePossibleMoves() {
    	createTempBoard();
    	markPossibleMoves();
    }

    public void createTempBoard() { //copy the permBoard
    	tempBoard = Game.permBoard.getBoard();
    }
    
    public void markPossibleMoves() { //TODO not yet implemented, how will it be stored for computer players?
    	for(int rowIndex=0; rowIndex<=tempBoard.length-1; rowIndex++) { 
    		for(int colIndex=0; colIndex<=tempBoard.length-1; colIndex++) {
    			if(tempBoard[rowIndex][colIndex]==piece) { //if the space has your piece in it
    				/*for(tempBoard[rowIndex][colIndex]; //start at the space with your piece in it
    				!isInBounds(rowIndex, colIndex)|| //until it's out of bounds
    				tempBoard[rowIndex][colIndex]=='.'; //or it is a blank space
   					tempBoard[rowIndex--][colIndex]) //each turn, keep going in the direction you're going	
    				{ //search for places to put a _ }*/
    				//there will be 8 of these, one for each direction
    			}
    		}
    	}
	}

    public boolean isInBounds(int rows, int cols) //is the cell in bounds?
	{
		if(rows >= 0 && 
			rows < tempBoard.length && 
			cols >=0 && 
			cols < tempBoard[0].length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    public void selectAMove() { //overriden for each type of player
    }

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}

	public char[][] getTempBoard() {
		return tempBoard;
	}

	public void setTempBoard(char[][] tempBoard) {
		this.tempBoard = tempBoard;
	}

	public char getPiece() {
		return piece;
	}

	public void setPiece(char piece) {
		this.piece = piece;
	}

	public int getPlayerType() {
		return playerType;
	}

	public void setPlayerType(int playerType) {
		this.playerType = playerType;
	}
}