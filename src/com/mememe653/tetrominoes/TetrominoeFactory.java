package com.mememe653.tetrominoes;

import java.awt.Color;

public class TetrominoeFactory {
	
	private static final Color TETROMINOE_COLORS[] = { Color.pink,
		  											   Color.red,
		  											   Color.blue,
		  											   Color.green,
		  											   Color.yellow,
		  											   Color.orange,
		  											   Color.cyan };
	
	private static int color_idx = 0;

	public static Tetrominoe createTetrominoe(int id) {
		color_idx++;
		color_idx %= TETROMINOE_COLORS.length;
		
		switch (id) {
		case 1:
			return new Tetrominoe1(TETROMINOE_COLORS[color_idx]);
		case 2:
			return new Tetrominoe2(TETROMINOE_COLORS[color_idx]);
		case 3:
			return new Tetrominoe3(TETROMINOE_COLORS[color_idx]);
		case 4:
			return new Tetrominoe4(TETROMINOE_COLORS[color_idx]);
		case 5:
			return new Tetrominoe5(TETROMINOE_COLORS[color_idx]);
		case 6:
			return new Tetrominoe6(TETROMINOE_COLORS[color_idx]);
		case 7:
			return new Tetrominoe7(TETROMINOE_COLORS[color_idx]);
		default:
			return null;
		}
	}
}
