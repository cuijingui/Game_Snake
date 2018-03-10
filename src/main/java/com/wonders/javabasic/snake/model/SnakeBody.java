package com.wonders.javabasic.snake.model;

import java.awt.Color;

public class SnakeBody extends Element {
	//继承
	public SnakeBody(int x, int y) {
		super(Color.BLUE);
		this.setX(x);
		this.setY(y);
	}
}
