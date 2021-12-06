package com.mememe653.tetris;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Tetris extends JFrame {
	
	public Tetris() {
		initUI();
	}
	
	private void initUI() {
		add(new Window());
		setResizable(false);
		pack();
		setTitle("Tetris");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new Tetris();
			frame.setVisible(true);
		});
	}
}
