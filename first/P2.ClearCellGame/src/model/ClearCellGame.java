package model;

import java.util.Random;

/* This class must extend Game */
public class ClearCellGame extends Game {

	private int score,strategy;
	Random random;
	
	
	
	public ClearCellGame(int maxRows, int maxCols,Random random,int strategy){
		super(maxRows,maxCols);
		this.score=0;
		this.random=random;
		
		this.strategy=strategy;
		for(int x=0;x<maxRows;x++){
			for(int y=0;y<maxCols;y++){
				this.setBoardCell(x, y, BoardCell.EMPTY);
			}
		}
	}

	@Override
	public boolean isGameOver() {
		for(int x=0;x<this.getMaxCols();x++){
			if(!this.getBoardCell(this.getMaxRows()-1,x).equals(BoardCell.EMPTY)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int getScore() {
		
		return score;
	}

	@Override
	public void nextAnimationStep() {
		
			
		if(isGameOver()!=true){
			for(int x=this.maxRows-2;x>=0;x--){
				for(int y=0; y<this.maxCols;y++){
					BoardCell tempCell= this.getBoardCell(x, y);
					tempCell=this.getBoardCell(x, y);
					this.setBoardCell(x+1, y, tempCell);
				}
			}
			
			for (int x=0;x<this.getMaxCols();x++){
				this.board[0][x]=BoardCell.getNonEmptyRandomBoardCell(random);
			}
		}
	}

	
	@Override
	public void processCell(int rowIndex, int colIndex){
		
		if(this.getBoardCell(rowIndex, colIndex).equals(BoardCell.EMPTY)){
           return;
    
           
		}
		
		processCellmain(rowIndex,colIndex);
	
	}
	private void processCellmain(int rowIndex, int colIndex)	
	{
		
		for(int row=rowIndex-1; row>=0; row--){
            if(board[row][colIndex]==board[rowIndex][colIndex] && row!=rowIndex){
                    this.setBoardCell(row, colIndex, BoardCell.EMPTY);
                    score++;
            }
            else{
                    break;
            }
    }
   
    for(int col = colIndex+1; col<this.getMaxCols(); col++){
            if(board[rowIndex][col]==board[rowIndex][colIndex] && col!=colIndex){
                    this.setBoardCell(rowIndex, col, BoardCell.EMPTY);
                    score++;
            }
            else{
                    break;
            }
    }
   
    for(int col = colIndex-1; col>=0; col--){
            if(board[rowIndex][col]==board[rowIndex][colIndex] && col!=colIndex){
                    this.setBoardCell(rowIndex, col, BoardCell.EMPTY);
                    score++;
            }
            else{
                    break;
            }
    }
   
		for(int row=rowIndex+1; row<this.getMaxRows(); row++){
            if(board[row][colIndex]==board[rowIndex][colIndex] && row!=rowIndex){
                    this.setBoardCell(row, colIndex, BoardCell.EMPTY);
                    score++;
            }
            else{
                    break;
            }
    }

		
		int LineRow = rowIndex+1;
    for(int col=colIndex+1; col<this.getMaxCols(); col++){
            if(LineRow<this.getMaxRows()){
                    if(board[LineRow][col]==board[rowIndex][colIndex]){
                            this.setBoardCell(LineRow, col, BoardCell.EMPTY);
                            score++;
                            LineRow++;
                    }
                    else{
                            break;
                    }
                   
            }
           
    }
			
    LineRow = rowIndex+1;
    for(int col=colIndex-1; col>=0; col--){
            if(LineRow<this.getMaxRows()){
                    if(board[LineRow][col]==board[rowIndex][colIndex]){
                            this.setBoardCell(LineRow, col, BoardCell.EMPTY);
                            score++;
                            LineRow++;
                    }
                    else{
                            break;
                    }
            }
           
    }
    LineRow = rowIndex-1;
    for(int col=colIndex+1; col<this.getMaxCols(); col++){
            if(LineRow>=0){
                    if(board[LineRow][col]==board[rowIndex][colIndex]){
                            this.setBoardCell(LineRow, col, BoardCell.EMPTY);
                            score++;
                            LineRow--;
                    }
                    else{
                            break;
                    }
            }
           
    }
   
    LineRow = rowIndex-1;
    for(int col=colIndex-1; col>=0; col--){
            if(LineRow>=0){
                    if(board[LineRow][col]==board[rowIndex][colIndex]){
                            this.setBoardCell(LineRow, col, BoardCell.EMPTY);
                            score++;
                            LineRow--;
                    }
                    else{
                            break;
                    }
            }
           
    }
    this.setBoardCell(rowIndex, colIndex, BoardCell.EMPTY);
    score++;
    
	for(int row= this.getMaxRows()-1; row>=0; row--){
        if(checkEmpty(row) != -1){
                for(int row2 = row+1; row2<this.getMaxRows();row2++){
                        for(int col = 0; col<this.getMaxCols(); col++){
                                board[row2-1][col] = board[row2][col];
                        }
                }
        }
}
    
   
   
	}
	
private int checkEmpty(int Row){
            for(int col=0; col<this.getMaxCols();col++){
                    if(board[Row][col]!= BoardCell.EMPTY){
                            return -1;
                    }
            }
            return Row;
   
}
}