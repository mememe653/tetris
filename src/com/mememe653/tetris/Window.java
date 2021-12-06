package com.mememe653.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.mememe653.tetrominoes.Tetrominoe;
import com.mememe653.tetrominoes.Tetrominoe1;

public class Window extends JPanel implements ActionListener {
	
	private final int DELAY = 100;
	
	private final int WIDTH = 300;
	private final int HEIGHT = 600;
	
	private final int DOT_PADDING = 2;
	private final int DOT_WIDTH = 30 - 2 * DOT_PADDING;
	
	private Tetrominoe shape = new Tetrominoe1(Color.pink);
	
	//private final Color SHAPE_COLOR = Color.pink;
	//private final int[][][] shape_coords = {{{-1,-1}, {0,-1}, {0,0}, {-1,0}}};
	
	private int centre_coord_x = WIDTH / DOT_WIDTH / 2;
	private int centre_coord_y = 0;
	
	private final Timer timer = new Timer(DELAY, this);
	
	public Window() {
		initWindow();
		
		timer.start();
		addKeyListener(new KeypressListener());
	}
	
	private void initWindow() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int shape_coords[][] = shape.getCoords();
		g.setColor(shape.getColor());
		for (int i = 0; i < 4; i++) {
			g.fillRect((centre_coord_x + shape_coords[i][0]) * (DOT_WIDTH + 2 * DOT_PADDING) + DOT_PADDING, (centre_coord_y + shape_coords[i][1]) * (DOT_WIDTH + 2 * DOT_PADDING) + DOT_PADDING, DOT_WIDTH, DOT_WIDTH);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		if (!checkHitFloor()) {
			centre_coord_y++;
		}
	}
	
	private boolean checkHitFloor() {
		int shape_coords[][] = shape.getCoords();
		for (int i = 0; i < 4; i++) {
			if ((centre_coord_y + shape_coords[i][1]) == (HEIGHT / (DOT_WIDTH + 2 * DOT_PADDING) - 1)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkHitLeftSide() {
		int shape_coords[][] = shape.getCoords();
		for (int i = 0; i < 4; i++) {
			if ((centre_coord_x + shape_coords[i][0]) == 0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkHitRightSide() {
		int shape_coords[][] = shape.getCoords();
		for (int i = 0; i < 4; i++) {
			if ((centre_coord_x + shape_coords[i][0]) == (WIDTH / (DOT_WIDTH + 2 * DOT_PADDING) - 1)) {
				return true;
			}
		}
		return false;
	}
	
	private class KeypressListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_A:
				if (!checkHitLeftSide()) {
					centre_coord_x--;
				}
				break;
			case KeyEvent.VK_D:
				if (!checkHitRightSide()) {
					centre_coord_x++;
				}
				break;
			case KeyEvent.VK_J:
				shape.rotateLeft();
				break;
			case KeyEvent.VK_L:
				shape.rotateRight();
				break;
			}
		}
		
		
	}

}
