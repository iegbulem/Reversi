import java.util.Arrays;

public class Board {

	protected int rowSize; //total num of rows
	protected int colSize;
    protected int rowIndex; //max index of rows
    protected int colIndex;

    protected char[][] board;

    public Board(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        rowIndex = rowSize-1;
        colIndex = colSize-1;
        createBoard(rowSize,colSize);
    }

    public void createBoard(int rowSize, int colSize) {
        board = new char[rowSize][colSize]; //make empty array
        for(char[] row: board) {
            Arrays.fill(row, '.'); //fill with '.'
        }
        board[3][3]='X'; //place starting pieces
    	board[4][4]='X';
    	board[4][3]='O';
    	board[3][4]='O';
    }

    public void displayBoard() {
        System.out.print("  "); //space before top row of col numbers
        for(int col=0; col<=colIndex; col++) { //print col number & space
            System.out.print((col+1) + " ");
        }
        System.out.println("");

        for(int row=0; row<=rowIndex; row++) {
            for(int col=0; col<=colIndex; col++) {
                if(col==0) { //print row number if first column
                    System.out.print((row+1) + " ");
                }
                System.out.print(board[row][col] + " "); //print what's in the array & space
            }
            System.out.println(""); //row break
        }
    }

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}

	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}
}