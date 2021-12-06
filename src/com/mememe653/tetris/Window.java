package com.mememe653.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {
	
	private final int DELAY = 100;
	
	private final int WIDTH = 300;
	private final int HEIGHT = 600;
	
	private final int DOT_PADDING = 2;
	private final int DOT_WIDTH = 30 - 2 * DOT_PADDING;
	
	private final Color SHAPE_COLOR = Color.pink;
	private final int[][][] shape_coords = {{{-1,-1}, {0,-1}, {0,0}, {-1,0}}};
	
	private int centre_coord_x = WIDTH / DOT_WIDTH / 2;
	private int centre_coord_y = 0;
	
	private final Timer timer = new Timer(DELAY, this);
	
	public Window() {
		initWindow();
		
		timer.start();
	}
	
	private void initWindow() {
		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(SHAPE_COLOR);
		for (int i = 0; i < 4; i++) {
			g.fillRect((centre_coord_x + shape_coords[0][i][0]) * (DOT_WIDTH + 2 * DOT_PADDING) + DOT_PADDING, (centre_coord_y + shape_coords[0][i][1]) * (DOT_WIDTH + 2 * DOT_PADDING) + DOT_PADDING, DOT_WIDTH, DOT_WIDTH);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		centre_coord_y++;
	}

}
