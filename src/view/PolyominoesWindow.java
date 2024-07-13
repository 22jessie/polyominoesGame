package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;

import model.Board;
import model.Constants;
import model.PolyControl;



public class PolyominoesWindow extends JFrame implements Board,Constants{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int WINDOW_WIDTH_PX=350;
	public static int WINDOW_HEIGHT_PX=600;

	
	
	private ShapePanel board;
	private PolyControl control;
	
	
	public PolyominoesWindow(PolyControl control) {
		this.control=control;
		board = new ShapePanel(control);
		add(board);
		
		setSize(WINDOW_WIDTH_PX,WINDOW_HEIGHT_PX);
		setTitle("**Tetrominoes**");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configureKeyListener();
		setResizable(false);
		setFocusable(true);
		setVisible(true);

	}
	
	
	private class KeyHandlerThread extends Thread{
		private int keyCode;
		
		public KeyHandlerThread(int keyCode) {
			this.keyCode=keyCode;
		}

		public void run() {
			switch (keyCode) {
				case KeyEvent.VK_SPACE:	control.rotateCurrentPolyomino();		break;
				case KeyEvent.VK_LEFT:	control.moveCurrentPolyominoLeft();		break;
				case KeyEvent.VK_RIGHT:	control.moveCurrentPolyominoRight();	break;
				case KeyEvent.VK_DOWN:	control.moveCurrentPolyominoDownFast();	break;
				default: ;
			}
		}
	}

	private void configureKeyListener() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				new KeyHandlerThread(e.getKeyCode()).start();
			}
		});
		
	}

	@Override
	public void cleanTile(int x, int y) {
		board.cleanTile(x, y);
		
	}

	@Override
	public void colorTile(int x, int y, Color color) {
		board.colorTile(x, y, color);
		
	}

	@Override
	public boolean isAValidTile(int i, int j) {
		return board.isAValidTile(i, j);
	}

	@Override
	public void markTileAsOccupied(int x, int y) {
		board.markTileAsOccupied(x, y);
		
	}

	@Override
	public boolean tileIsEmpty(int i, int j) {
		return board.tileIsEmpty(i, j);
	}

	@Override
	public void overwriteTile(int row, int c, int i, int c2) {
		board.overwriteTile(row, c, i, c2);
		
	}
	
}
