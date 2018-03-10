package com.wonders.javabasic.snake.thread;

import com.wonders.javabasic.snake.model.Sbean;
import com.wonders.javabasic.snake.model.Snake;
import com.wonders.javabasic.snake.ui.GameWindow;

public class GameThread extends Thread {
	private GameWindow gamewindow;
	private Snake snake;
	private Sbean sbean;
	public static boolean start = false;
	public GameThread() {
		this.snake = new Snake();
		this.sbean = new Sbean(snake);
		this.gamewindow = new GameWindow(this);
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			while(true){
				this.sleep(500);
				if(start){
					snake.move();
					if(snake.ifcaneat(sbean)){
						snake.growup();
						sbean = new Sbean(snake);
					}
					if(snake.ifdead()){
						start = false;
					}
				}
				gamewindow.gamestatus(start);
				gamewindow.freshWindow();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Sbean getSbean() {
		return sbean;
	}

	public void setSbean(Sbean sbean) {
		this.sbean = sbean;
	}
}
