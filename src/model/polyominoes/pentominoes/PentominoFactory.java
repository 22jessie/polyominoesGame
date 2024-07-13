package model.polyominoes.pentominoes;

import java.util.Random;

import model.Board;

public class PentominoFactory {
	
private Board board;
	
	
	public PentominoFactory(Board board) {
		this.board=board;
	}

	public Pentomino generateRandomPolyomino() {
		Random rand=new Random();
		
		PentominoType type=PentominoType.valueOf(rand.nextInt(12));
		switch(type) {
		case F:return new Pentomino(PentominoType.F,board);
		case I:return new Pentomino(PentominoType.I,board);
		case L:return new Pentomino(PentominoType.L,board);
		case N:return new Pentomino(PentominoType.N,board);
		case P:return new Pentomino(PentominoType.P,board);
		case T:return new Pentomino(PentominoType.T,board);
		case U:return new Pentomino(PentominoType.U,board);
		case V:return new Pentomino(PentominoType.V,board);
		case W:return new Pentomino(PentominoType.W,board);
		case X:return new Pentomino(PentominoType.X,board);
		case Y:return new Pentomino(PentominoType.Y,board);
		case Z:return new Pentomino(PentominoType.Z,board);
		default:	return new Pentomino(PentominoType.L,board);
		}
		
	}

}
