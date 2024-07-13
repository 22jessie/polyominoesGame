package model.polyiominoes;

import model.Board;
import model.Constants;

public abstract class Polyomino implements Constants{
	protected int size;
	protected Square[] squares;
	protected Board board;
	
	
	public enum Direction{
		LEFT,RIGHT,DOWN, ROTATION
	}
	
	
	protected Polyomino(int size,Board board) {
		this.size=size;
		squares=new Square[size];
		for(int i=0; i < size; i++) {
			squares[i]=new Square(0,0);
		}
		this.board=board;
		
	}
	
	public final void rotate90DegreesRight() {
		int baseX;
		int baseY;
		
		baseX=squares[0].getX();
		baseY=squares[0].getY();
		for(Square s : squares) {
			rotate90DegreesRight(s,baseX,baseY);
		}
		
	}

	private void rotate90DegreesRight(Square s,int baseX, int baseY) {
		Square rotated= calculateRotation(s,baseX,baseY);
		s.setPosition(rotated.getX(),rotated.getY());
	}
	
	private Square calculateRotation(Square s,int baseX, int baseY) {
		Square newSquare=new Square();
		
		Square relative=new Square(s.getX()-baseX,s.getY()-baseY);
		Square rotated=new Square(relative.getY(),relative.getX()*-1);
		newSquare.setPosition(rotated.getX()+baseX,rotated.getY()+baseY);
		return newSquare;
	}
	
	protected void arrangeTiles(Square[] tiles) {
		for(int i=0; i< size; i++) {
			squares[i].setPosition(tiles[i].getX(), tiles[i].getY());
		}
	}
	
	
	public void moveRight() {
		for(Square s : squares) {
			s.moveRight();
		}
	}
	
	public void moveLeft() {
		for(Square s : squares) {
			s.moveLeft();
		}
	}
	
	public void moveDown() {
		for(Square s : squares) {
			s.moveDown();
		}
	}

	public Square[] getSquares() {
		return squares;
	}

	public boolean canMove(Direction d) {
		int x,y;
		
		switch(d) {
		case DOWN:	y=0;	x=1;	break;
		case LEFT:	y=-1;	x=0;	break;
		case RIGHT:	y=1;	x=0;	break;
		default:	x=y=0;
		}
		for(Square s : squares) {
			if(!board.isAValidTile(s.getX()+x,s.getY()+y)) {
				return false;
			}
		}
		return true;

	}

	public boolean canRotate90DegreesRight() {
		int baseX,baseY;
		Square rotated;
		
		baseX=squares[0].getX();
		baseY=squares[0].getY();
		for(Square s : squares) {
			rotated=calculateRotation(s, baseX, baseY);
			if(!board.isAValidTile(rotated.getX(),rotated.getY())) {
				return false;
			}
		}
		return true;
	}

	public boolean canBePlaced() {
		for(Square s : squares) {
			if(!board.isAValidTile(s.getX(),s.getY())) {
				return false;
			}
		}
		return true;
	}
	
}
