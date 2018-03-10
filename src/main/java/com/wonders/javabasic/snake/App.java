package com.wonders.javabasic.snake;

import com.wonders.javabasic.snake.thread.GameThread;

/**
 *
 */
public class App {

	public static void main(String[] args) {
		GameThread gt = new GameThread();
		gt.start();
	}
}
