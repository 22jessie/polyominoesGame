package model;

import java.awt.Color;

public interface Board {

	void cleanTile(int x, int y);

	void colorTile(int x, int y, Color color);

	boolean isAValidTile(int i, int j);

	void markTileAsOccupied(int x, int y);

	boolean tileIsEmpty(int i, int j);

	void overwriteTile(int row, int c, int i, int c2);
}
