package com.mememe653.tetris;

import java.awt.Color;

public class Brick {

	private Color color;
	private int x;
	private int y;
	
	public Brick(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
