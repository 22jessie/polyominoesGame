package model.polyiominoes;

public class Square {
	
	private int x;
	private int y;

	public Square(int x, int y) {
		
		this.x=x;
		this.y=y;
		
	}

	 public Square() {}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public void setPosition(int x, int y) {
		this.x=x;
		this.y=y;
		
	}

	public void moveRight() {
		y++;
	}

	public void moveLeft() {
		y--;
		
	}

	public void moveDown() {
		x++;
		
	}

}
