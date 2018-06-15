package model;

/**
 * This class represents the logic of a game where a board is updated on each
 * step of the game animation. The board can also be updated by selecting a
 * board cell.
 * 
 * @author Dept of Computer Science, UMCP
 */

public abstract class Game {
	protected BoardCell[][] board;
	protected int maxRows, maxCols;
	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	public Game(int maxRows, int maxCols) {
		this.maxRows=maxRows;
		this.maxCols=maxCols;
		
		board= new BoardCell[maxRows][maxCols];
		
		for(int x=0;x<maxRows;x++){
		for(int y=0;y<maxCols;y++){
			board[x][y]=BoardCell.EMPTY;
		}
		}
	}

	public int getMaxRows() {
		return maxRows;
	}

	public int getMaxCols() {
		return maxCols;
	}

	public void setBoardCell(int rowIndex, int colIndex, BoardCell boardCell) {
		board[rowIndex][colIndex]=boardCell;
	}

	public BoardCell getBoardCell(int rowIndex, int colIndex) {
		return board[rowIndex][colIndex];
	}

	/**
	 * Initializes row with the specified color.
	 * @param rowIndex
	 * @param cell
	 */
	public void setRowWithColor(int rowIndex, BoardCell cell) {
		for(int x=0;x<this.getMaxCols();x++){
			this.setBoardCell(rowIndex, x, cell);
		}
	}
	
	/**
	 * Initializes column with the specified color.
	 * @param colIndex
	 * @param cell
	 */
	public void setColWithColor(int colIndex, BoardCell cell) {
		for(int x=0;x<this.getMaxRows();x++){
			 this.setBoardCell(x, colIndex, cell);
		 }
	}
	
	/**
	 * Initializes the board with the specified color.
	 * @param cell
	 */
	public void setBoardWithColor(BoardCell cell) {
		for(int x=0;x<this.getMaxCols();x++){
			this.setColWithColor(x, cell);
		}
	}	
	protected BoardCell[] generateEmptyRow() {
		BoardCell[] newRow = new BoardCell[maxCols];

		for (int col = 0; col < maxCols; col++) {
			newRow[col] = BoardCell.EMPTY;
		}

		return newRow;
	}
	public abstract boolean isGameOver();

	public abstract int getScore();

	/**
	 * Advances the animation one step.
	 */
	public abstract void nextAnimationStep();

	/**
	 * Adjust the board state according to the current board state and the
	 * selected cell.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 */
	public abstract void processCell(int rowIndex, int colIndex);
}