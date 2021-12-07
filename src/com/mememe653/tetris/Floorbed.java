package com.mememe653.tetris;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.mememe653.tetrominoes.Tetrominoe;

public class Floorbed {

	private List<ArrayList<Brick>> bricks = new LinkedList<>();
	private final int ROW_LENGTH = 10;
	private final int WINDOW_HEIGHT = 19;
	
	public void add(Tetrominoe tetrominoe, int centre_coord_x, int centre_coord_y) {
		int coords[][] = tetrominoe.getCoords();
		Arrays.sort(coords, new Comparator<int[]>() {
			public int compare(int a[], int b[]) {
				return Integer.compare(b[1], a[1]);
			}
		});
		
		for (int i = 0; i < 4; i++) {
			if ((WINDOW_HEIGHT - coords[i][1] - centre_coord_y) >= bricks.size()) {
				bricks.add(new ArrayList<Brick>());
			}
			bricks.get(WINDOW_HEIGHT - coords[i][1] - centre_coord_y).add(new Brick(tetrominoe.getColor(),
					centre_coord_x + coords[i][0], centre_coord_y + coords[i][1]));
		}
		
		for (int i = 0; i < bricks.size(); i++) {
			if (bricks.get(i).size() >= ROW_LENGTH) {
				clearRow(i);
				i--;
			}
		}
	}
	
	public boolean checkHitFloor(Tetrominoe tetrominoe, int centre_coord_x, int centre_coord_y) {
		int rel_coords[][] = tetrominoe.getCoords();
		int abs_coords[][] = new int[4][2];
		for (int i = 0; i < abs_coords.length; i++) {
			abs_coords[i][0] = rel_coords[i][0] + centre_coord_x;
			abs_coords[i][1] = rel_coords[i][1] + centre_coord_y;
		}
		
		for (int i = 0; i < abs_coords.length; i++) {
			for (ArrayList<Brick> row : bricks) {
				for (Brick brick : row) {
					if ((brick.getX() == abs_coords[i][0]) && ((brick.getY() - 1) == abs_coords[i][1])) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkUnderFloor(Tetrominoe tetrominoe, int centre_coord_x, int centre_coord_y) {
		int rel_coords[][] = tetrominoe.getCoords();
		int abs_coords[][] = new int[4][2];
		for (int i = 0; i < abs_coords.length; i++) {
			abs_coords[i][0] = rel_coords[i][0] + centre_coord_x;
			abs_coords[i][1] = rel_coords[i][1] + centre_coord_y;
		}
		
		for (int i = 0; i < abs_coords.length; i++) {
			for (ArrayList<Brick> row : bricks) {
				for (Brick brick : row) {
					if ((brick.getX() == abs_coords[i][0]) && (brick.getY() <= abs_coords[i][1])) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public List<ArrayList<Brick>> getBricks() {
		return bricks;
	}
	
	private void clearRow(int idx) {
		bricks.remove(idx);
		while (idx < bricks.size()) {
			for (Brick brick : bricks.get(idx)) {
				brick.setY(brick.getY() + 1);
			}
			idx++;
		}
	}
}
