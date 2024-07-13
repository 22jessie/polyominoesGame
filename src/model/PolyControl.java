package model;

import model.polyiominoes.Polyomino;
import view.PolyominoesGenerator;
import view.PolyominoesWindow;

public class PolyControl {
	
	private PolyominoHandler polyHandler;
	private BoardCleanerThread boardCleaner;
	private Board board;
	
	
	public PolyControl() {
		board=new PolyominoesWindow(this);
		
		
		polyHandler=new PolyominoHandler(board,this);
		polyHandler.start();
		(new PolyominoesGenerator(board,this)).start();
		boardCleaner=new BoardCleanerThread(board);
		boardCleaner.start();
	}
	
	
	public boolean canPlacePolyomino() {
		return polyHandler.canHandleNewPolyomino();
	}
	
	public void checkForFullRows() {
		boardCleaner.lookForFullRows();
	}

	
	public void moveCurrentPolyominoDownFast() {
		polyHandler.movePolyominoDownFast();
	}

	public void setPolyomino(Polyomino p) {
		polyHandler.setPolyomino(p);
		
	}


	public void rotateCurrentPolyomino() {
		polyHandler.rotatePolyomino90DegreesRight();
		
	}


	public void moveCurrentPolyominoLeft() {
		polyHandler.movePolyominoLeft();
		
	}


	public void moveCurrentPolyominoRight() {
		polyHandler.movePolyominoRight();
		
	}

}
