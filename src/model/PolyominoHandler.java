package model;

import java.awt.Color;
import java.util.Random;

import model.polyiominoes.Polyomino;
import model.polyiominoes.Square;

public class PolyominoHandler extends Thread {
	
	private Polyomino polyomino;
	private Board board;
	private Color color;
	private final Color[] validColors= {new Color(255, 153, 204),
			new Color(255, 204, 153),new Color(204, 153, 255),new Color(153, 204, 255),
			new Color(153, 255, 204),new Color(204, 255, 153),new Color(255, 255, 204)};
	private boolean polyominoCanMoveForward;
	private boolean tilesMarkedAsOccupied;
	private boolean lose;
	private int velocityMilliSeconds;
	private PolyControl control;
	
	
	public PolyominoHandler(Board board, PolyControl control) {
		this.board=board;
		this.control=control;
		polyominoCanMoveForward=true;
		tilesMarkedAsOccupied=true;
		lose=false;
	}
	
	public void run() {
		
		while(true) {
			synchronized(board) {
				if(polyomino!= null) {
					if(!lose) {
						if(polyomino.canMove(Polyomino.Direction.DOWN)) {
							cleanPreviousSquares();
							polyomino.moveDown();
							placePolyominoInBoard();
						}else if(!tilesMarkedAsOccupied) {
							markTilesAsOccupied();
							polyominoCanMoveForward=false;
						}
					}else {
						System.out.println("Game over!");
						break;
					}
				}
			}
			try {
				sleep(velocityMilliSeconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void markTilesAsOccupied() {
		Square[] squares=polyomino.getSquares();
		
		tilesMarkedAsOccupied=true;
		control.checkForFullRows();
		for(Square s :squares) {
			board.markTileAsOccupied(s.getX(),s.getY());
		}
	}

	private void cleanPreviousSquares() {
		Square[] squares=polyomino.getSquares();
		for(Square s :squares) {
			board.cleanTile(s.getX(),s.getY());
		}
	}
	
	private void placePolyominoInBoard() {
		Square[] squares=polyomino.getSquares();
		for(Square s :squares) {
			board.colorTile(s.getX(),s.getY(),color);
		}
	}
	
	public void setPolyomino(Polyomino p) {
		polyomino=p;
		if(polyomino.canBePlaced()) {
			tilesMarkedAsOccupied=false;
			int rand=new Random().nextInt(validColors.length);
			color=validColors[rand];
			polyominoCanMoveForward=true;
			placePolyominoInBoard();
			velocityMilliSeconds=3000;
		}else {
			lose=true;
		}
		
		
	}

	public void rotatePolyomino90DegreesRight() {
		if(polyomino.canRotate90DegreesRight()) {
			cleanPreviousSquares();
			polyomino.rotate90DegreesRight();
			placePolyominoInBoard();
		}

	}

	public void movePolyominoLeft() {
		if(polyomino.canMove(Polyomino.Direction.LEFT)) {
			cleanPreviousSquares();
			polyomino.moveLeft();
			placePolyominoInBoard();
		}
		
	}

	public void movePolyominoRight() {
		if(polyomino.canMove(Polyomino.Direction.RIGHT)) {
			cleanPreviousSquares();
			polyomino.moveRight();
			placePolyominoInBoard();
		}

	}

	public boolean canHandleNewPolyomino() {
		return polyomino==null || (!polyominoCanMoveForward);
		
	}

	public void movePolyominoDownFast() {
		velocityMilliSeconds=50;
	}

}
