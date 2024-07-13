package model.polyiominoes;

import java.util.Random;

import model.Board;
import model.polyominoes.pentominoes.PentominoFactory;
import model.polyominoes.tetrominoes.TetrominoFactory;

public class PolyominoFactory {
	private TetrominoFactory tetroFact;
	private PentominoFactory pentoFact;
	
	
	public PolyominoFactory(Board board){
		tetroFact=new TetrominoFactory(board);
		pentoFact=new PentominoFactory(board);
	}
	
	
	public Polyomino generateRandomPolyomino() {
		Random rand=new Random();
		
		int type=rand.nextInt(1);
		switch(type) {
		case 0: return tetroFact.generateRandomPolyomino();
		case 1:	return pentoFact.generateRandomPolyomino();
		default:return pentoFact.generateRandomPolyomino();
		
		}
		
	}

}
