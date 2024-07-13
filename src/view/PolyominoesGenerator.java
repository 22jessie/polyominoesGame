package view;

import model.Board;
import model.PolyControl;
import model.polyiominoes.Polyomino;
import model.polyiominoes.PolyominoFactory;

public class PolyominoesGenerator extends Thread {
	
	private static final int PAUSE_IN_MILLISECONDS=1000;
	
	private PolyominoFactory polyoFact;
	
	private Board board;
	private PolyControl control;
	
	
	
	public PolyominoesGenerator(Board board, PolyControl control) {
		polyoFact=new PolyominoFactory(board);
		this.board=board;
		this.control=control;
	}
	
	
	public void run() {
		
		Polyomino p;
		
		while(true) {
			synchronized(board) {
				if(control.canPlacePolyomino()) {
					p=polyoFact.generateRandomPolyomino();
					control.setPolyomino(p);
				}
			}
			try {
				sleep(PAUSE_IN_MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
