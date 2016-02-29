import java.util.Scanner;

public class HumanPlayer extends Player {

	private Scanner scanner;
	private int inputRowIndex; //first argument
	private int inputColIndex; //second argument
	
    public HumanPlayer() {
    	scanner = new Scanner(System.in);
    }
    
    public void takeATurn() {
    	determinePossibleMoves(); //from the Player class
    	displayPossibleMoves(); //specific to human player, computer player does not need to see possible moves
    	System.out.print("Enter your move, player " + piece + ": "); //specific to human player, computer player is not prompted
    	selectAMove();
    }
    
    public void displayPossibleMoves() { //TODO displays permBoard, switch to tempBoard so _ will show
    	Game.permBoard.displayBoard();
    }
    
    public void selectAMove() {
    	takeInput();
    	processInput();
    }

    public void takeInput() //need to restrict to only spots that are valid moves
	{    	    	
    	String inputLine = scanner.nextLine(); //takes the full line of input

		Scanner tokenizer = new Scanner(inputLine); //reads the line up input and breaks it up
		if(tokenizer.hasNext()) { //if there is a first argument [row]
			inputRowIndex = Integer.parseInt(tokenizer.next()); //get that argument and turn it into an integer
			try {				
				if(inputRowIndex>7) { //TODO make index not specific to Reversi, if it's out of bounds, say no
					System.out.println();
					System.out.println("Invalid row index!");
					System.out.println("Please enter another command.");
					System.out.println();
					takeATurn();
				}
			} 
			catch (NumberFormatException nfe) {	//if it's not an integer, say no
				System.out.println();
				System.out.println("Invalid row index! Value must be an integer.");
				System.out.println("Please enter another command.");
				System.out.println();
				takeATurn();
			}
		}	

		if(tokenizer.hasNext()) { //if there is a second argument [col]
			inputColIndex = Integer.parseInt(tokenizer.next()); //get that argument and turn it into an integer
			try {
				if(inputColIndex>7) { //if it's out of bounds, say no
					System.out.println();
					System.out.println("Invalid column index!");
					System.out.println("Please enter another command.");
					System.out.println();
					takeATurn();
				}
			} 
			catch (NumberFormatException nfe) { //if it's not an integer, say no
				System.out.println();
				System.out.println("Invalid column index! Value must be an integer.");
				System.out.println("Please enter another command.");
				System.out.println();
				takeATurn();
			}
		}
		
		else {
			System.out.println("Please enter 2 arguments: [row] [col]"); //if less than two arguments, say no
			takeATurn();
		}
		tokenizer.close();	
	}

    public void processInput() { //consider moving to player
    	tempBoard[inputRowIndex-1][inputColIndex-1]=piece; //set the chosen cell to the piece of the current player
    	Game.permBoard.setBoard(tempBoard); //set this tempBoard with the new turn on it to the permBoard
    	
    	//TODO implement quit
    }
}