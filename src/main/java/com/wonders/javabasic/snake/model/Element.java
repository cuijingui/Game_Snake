package com.wonders.javabasic.snake.model;

import java.awt.Color;
import java.awt.Graphics2D;

import com.wonders.javabasic.snake.ui.GameWindow;

public class Element {
	private int x;
	private int y;
	private Color color;
	private int width;
	private int height;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Element(int x, int y, Color color) {
		this(color);
		this.x = x;
		this.y = y;
	}

	public Element(Color color) {
		this.color = color;
		this.width = GameWindow.LEN - 1;
		this.height = GameWindow.LEN - 1;
	}

	public void show(Graphics2D g2d){
		g2d.setColor(color);
		g2d.fillRect(x, y, width, height);
	}
}
