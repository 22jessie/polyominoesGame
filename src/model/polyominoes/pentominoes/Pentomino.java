package model.polyominoes.pentominoes;

import model.Board;
import model.polyiominoes.Polyomino;
import model.polyiominoes.Square;

public class Pentomino extends Polyomino{
	
	private static final int SIZE=5;
	private PentominoType type;

	protected Pentomino(PentominoType type, Board board) {
		super(SIZE,board);
		this.type=type;
		placeSquares(type);
	}

	private void placeSquares(PentominoType type) {
		Square[] tiles;
		
		switch(type) {
			case F:   tiles=arrangeTilesAsFPentomino();	break;
			case I:   tiles=arrangeTilesAsIPentomino();	break;
			case L:   tiles=arrangeTilesAsLPentomino();	break;
			case N:   tiles=arrangeTilesAsNPentomino();	break;
			case P:   tiles=arrangeTilesAsPPentomino();	break;
			case T:   tiles=arrangeTilesAsTPentomino();	break;
			case U:   tiles=arrangeTilesAsUPentomino();	break;
			case V:   tiles=arrangeTilesAsVPentomino();	break;
			case W:   tiles=arrangeTilesAsWPentomino();	break;
			case X:   tiles=arrangeTilesAsXPentomino();	break;
			case Y:   tiles=arrangeTilesAsYPentomino();	break;
			case Z:   tiles=arrangeTilesAsZPentomino();	break;
			default:  tiles=arrangeTilesAsFPentomino();	break;
		}
		arrangeTiles(tiles);
		
	}

	
	private Square[] arrangeTilesAsZPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base+1),new Square(1,base+1),new Square(1,base),new Square(1,base-1),new Square(2,base-1)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsYPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(1,base),new Square(0,base+1),new Square(0,base+2)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsPPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(1,base-1),new Square(1,base),new Square(0,base+1)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsWPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(1,base),new Square(1,base+1),new Square(2,base+1)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsVPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-2),new Square(0,base-1),new Square(0,base),new Square(1,base),new Square(2,base)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsUPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(0,base+1),new Square(1,base-1),new Square(1,base+1)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsLPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(1,base-1),new Square(1,base),new Square(1,base+1),new Square(1,base+2)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsTPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(0,base+1),new Square(1,base),new Square(2,base)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsXPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base),new Square(1,base-1),new Square(1,base),new Square(1,base+1),new Square(2,base)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsNPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-1),new Square(0,base),new Square(1,base),new Square(1,base+1),new Square(1,base+2)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsFPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base),new Square(1,base),new Square(1,base+1),new Square(2,base),new Square(2,base-1)};
		return tiles;
		
	}





	private Square[] arrangeTilesAsIPentomino() {
		int base=COLUMNS/2;
		Square tiles[]= {new Square(0,base-2),new Square(0,base-1),new Square(0,base),new Square(0,base+1),new Square(0,base+2)};
		return tiles;
		
	}





	public PentominoType getType() {
		return type;
	}



}
