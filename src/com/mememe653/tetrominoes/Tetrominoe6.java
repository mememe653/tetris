package com.mememe653.tetrominoes;

import java.awt.Color;

public class Tetrominoe6 implements Tetrominoe {
	
	private Color color;
	private int idx = 0;
	
	public static final int coords[][][] = {{{-1,-1}, {0,-1}, {0,0}, {-1,0}}};
	
	public Tetrominoe6(Color color) {
		this.color = color;
	}

	@Override
	public void rotateRight() {
		idx++;
		idx %= 1;
	}

	@Override
	public void rotateLeft() {
		idx--;
		if (idx < 0) {
			idx = coords.length - 1;
		}
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int[][] getCoords() {
		return coords[idx];
	}

}
