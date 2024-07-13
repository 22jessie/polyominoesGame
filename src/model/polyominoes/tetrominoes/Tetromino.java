package model.polyominoes.tetrominoes;

import model.Board;
import model.polyiominoes.Polyomino;
import model.polyiominoes.Square;

class Tetromino extends Polyomino{

	
	private static final int SIZE=4;
	
	private TetrominoType type;

	protected Tetromino(TetrominoType type, Board board) {
		super(SIZE,board);
		this.type=type;
		placeSquares(type);
		
	}

	private void placeSquares(TetrominoType type) {
		Square[] tiles;
		
		switch(type) {
		case L:			tiles=arrangeTilesAsLTetromino();			break;
		case SKEW:		tiles=arrangeTilesAsSkewTetromino();		break;
		case SQUARE:	tiles=arrangeTilesAsSquareTetromino();		break;
		case STRAIGHT: 	tiles=arrangeTilesAsStraightTetromino();	break;
		case T:			tiles=arrangeTilesAsTTetromino();			break;
		default:		tiles=arrangeTilesAsLTetromino();			break;
		
		}
		arrangeTiles(tiles);
		
	}

	private Square[] arrangeTilesAsTTetromino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(0,base+1),new Square(1,base)};
		return tiles;
		
	}

	private Square[] arrangeTilesAsStraightTetromino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-2),new Square(0,base-1),new Square(0,base),new Square(0,base+1)};
		return tiles;
		
	}

	private Square[] arrangeTilesAsSquareTetromino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base),new Square(1,base),new Square(0,base+1),new Square(1,base+1)};
		return tiles;
		
	}

	private Square[] arrangeTilesAsSkewTetromino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(1,base),new Square(1,base+1)};
		return tiles;
		
	}

	private Square[] arrangeTilesAsLTetromino() {
		int base=COLUMNS/2;
		
		Square tiles[]= {new Square(0,base-2),new Square(0,base-1),new Square(0,base),new Square(1,base)};
		return tiles;
		
	}

	public TetrominoType getType() {
		return type;
	}


}
