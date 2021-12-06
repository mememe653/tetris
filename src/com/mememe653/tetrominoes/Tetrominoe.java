package com.mememe653.tetrominoes;

import java.awt.Color;

public interface Tetrominoe {

	public void rotateRight();
	public void rotateLeft();
	public int[][] getCoords();
	public Color getColor();
}
