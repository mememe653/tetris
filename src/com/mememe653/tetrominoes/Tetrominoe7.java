package com.mememe653.tetrominoes;

import java.awt.Color;

public class Tetrominoe7 implements Tetrominoe {
	
	private Color color;
	private int idx = 0;
	
	public static final int coords[][][] = {{{-1,0}, {0,0}, {1,0}, {0,-1}},
											{{1,-2}, {1,-1}, {1,0}, {0,-1}},
											{{-1,-2}, {0,-2}, {1,-2}, {0,-1}},
											{{-1,-2}, {-1,-1}, {-1,0}, {0,-1}}};
	
	public Tetrominoe7(Color color) {
		this.color = color;
	}

	@Override
	public void rotateRight() {
		idx++;
		idx %= 4;
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
