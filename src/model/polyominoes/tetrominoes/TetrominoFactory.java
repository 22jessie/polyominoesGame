package model.polyominoes.tetrominoes;

import java.util.Random;

import model.Board;

public class TetrominoFactory {
	
	private Board board;
	
	
	public TetrominoFactory(Board board) {
		this.board=board;
	}

	public Tetromino generateRandomPolyomino() {
		Random rand=new Random();
		
		TetrominoType type=TetrominoType.valueOf(rand.nextInt(5));
		switch(type) {
		case L:			return new Tetromino(TetrominoType.L,board);
		case SKEW:		return new Tetromino(TetrominoType.SKEW,board);
		case SQUARE:	return new Tetromino(TetrominoType.SQUARE,board);
		case STRAIGHT:	return new Tetromino(TetrominoType.STRAIGHT,board);
		case T:			return new Tetromino(TetrominoType.T,board);
		default:		return new Tetromino(TetrominoType.T,board);
		}
		
	}
	
	
	
	
	
	
	

}
