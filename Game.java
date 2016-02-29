public class Game {

	public static ReversiBoard permBoard; 
	private Player playerX;
    private Player playerO;
    private boolean isWon;
    
    public static void main(String[] args) 
	{
    	switch (args.length) {
		case 2: //2 parameters entered
			Game game = new Game(createPlayer(args[0]), createPlayer(args[1])); //create a new game with 2 players
	    	game.play(); //start the game
	    	break;
	    		
		default: //not 2 parameters entered
			System.out.println("Please try again with two players of the following types:");
			System.out.println("HumanPlayer   RandomComputerPlayer   IntelligentComputerPlayer");
			System.exit(0);
		}
	}
    
    public static Player createPlayer(String playerType) {
		if(playerType.equals("HumanPlayer")) {
			return new HumanPlayer();
		}
		if(playerType.equals("RandomComputerPlayer")) {
			return new RandomComputerPlayer();
		}
		if(playerType.equals("IntelligentComputerPlayer")) {
			return new IntelligentComputerPlayer();
		}
		else {
    		System.out.println("Please try again with valid player types:");
    		System.out.println("HumanPlayer   RandomComputerPlayer   IntelligentComputerPlayer");
    		System.exit(0);
    	}
		return null;
	}
    
    public Game(Player tempPlayerX, Player tempPlayerO) {
    	permBoard = new ReversiBoard();
    	playerX = tempPlayerX;
    	playerX.setPiece('X');
    	playerO = tempPlayerO;
    	playerO.setPiece('O');
    }
    
    public void play() {
    	System.out.println("Welcome to Reversi! Moves should be entered in \"[row] [column]\" format.");
    	playerX.takeATurn();
    	checkIsWon();
    	playerO.takeATurn();
    	checkIsWon();
    	playerX.takeATurn();
    	checkIsWon();
    	playerO.takeATurn();
    	checkIsWon();
    	playerX.takeATurn();
    	checkIsWon();
    	playerO.takeATurn();
    	checkIsWon();
    }

    public void checkIsWon() {
    	if(isWon==true) {
    		displayWinner();
    	}
    }
    
    public void displayWinner() {
    	System.out.println("Congratulations, player _!"); //TODO
    	System.out.println("You have won the game!");
    	System.exit(0);
    }

    public void displayQuit() {
    	System.out.println("You are quitting the game.");
    	System.exit(0);
    }

	public static ReversiBoard getPermBoard() {
		return permBoard;
	}

	public static void setPermBoard(ReversiBoard permBoard) {
		Game.permBoard = permBoard;
	}

	public Player getPlayerX() {
		return playerX;
	}

	public void setPlayerX(Player playerX) {
		this.playerX = playerX;
	}

	public Player getPlayerO() {
		return playerO;
	}

	public void setPlayerO(Player playerO) {
		this.playerO = playerO;
	}

	public boolean isWon() {
		return isWon;
	}

	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}
}