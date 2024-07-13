package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Constants;
import model.PolyControl;

public class ShapePanel extends JPanel implements Constants{

	
	private static final long serialVersionUID = 1L;
	private ButtonTile tiles[];
	

	public ShapePanel(PolyControl control) {
		createShapeBoard();
			
	}
	
	private void createShapeBoard() {
		ButtonTile b;
		setLayout(new GridLayout(ROWS,COLUMNS));
		tiles=new ButtonTile[ROWS*COLUMNS];
		for(int i=0; i < ROWS; i++) {
			for(int j=0; j < COLUMNS; j++) {
				b=new ButtonTile();
				b.setSize(25,25 );
				tiles[i*COLUMNS+j]=b;
				b.setBackground(BASE_COLOR);
				add(b);
			}
		}
	}


	public void cleanTile(int x, int y) {
		int n=x*COLUMNS+y;
		
		tiles[n].setBackground(BASE_COLOR);
		tiles[n].makeEmpty(true);
		
		
	}

	public void colorTile(int x, int y, Color color) {
		tiles[x*COLUMNS+y].setBackground(color);
		
	}



	public boolean isAValidTile(int x, int y) {
		return x>=0 && x<ROWS && y >=0 && y<COLUMNS && tiles[x*COLUMNS+y].isEmpty();
	}

	public void markTileAsOccupied(int x, int y) {
		tiles[x*COLUMNS+y].makeEmpty(false);
		
	}

	public boolean tileIsEmpty(int x, int y) {
		return tiles[x*COLUMNS+y].isEmpty();
	}

	public void overwriteTile(int x, int y, int x1, int y1) {
		int n=x*COLUMNS+y;
		int n1=x1*COLUMNS+y1;
		colorTile(x, y,tiles[n1].getBackground());
		tiles[n].makeEmpty(tiles[n1].isEmpty());
	}
	
	
}
