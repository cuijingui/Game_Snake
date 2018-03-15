package com.wonders.javabasic.snake.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.wonders.javabasic.snake.enumm.Direction;
import com.wonders.javabasic.snake.model.Sbean;
import com.wonders.javabasic.snake.model.Snake;
import com.wonders.javabasic.snake.thread.GameThread;


public class WindowEventListener implements MouseMotionListener, KeyListener, MouseListener{
	private GameWindow gameWindow;
	public WindowEventListener(GameWindow gameWindow) {
		super();
		this.gameWindow = gameWindow;
	}

	//按键
	@Override
	public void keyPressed(KeyEvent keyevent) {
		Snake snake = gameWindow.getSnake();
		//KeyEvent中各项属性的内容
		switch (keyevent.getKeyCode()) {
		case KeyEvent.VK_UP:
			if(!snake.getDirection().equals(Direction.DOWN)) {
				snake.turn(Direction.UP);
			}
			System.out.print("这是VK_UP");
			break;
		case KeyEvent.VK_DOWN:
			if(!snake.getDirection().equals(Direction.UP)) {
				snake.turn(Direction.DOWN);
			}
			System.out.print("这是VK_DOWN");
			break;
		case KeyEvent.VK_LEFT:
			if(!snake.getDirection().equals(Direction.RIGHT)) {
				snake.turn(Direction.LEFT);
			}
			System.out.print("这是VK_LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			if(!snake.getDirection().equals(Direction.LEFT)) {
				snake.turn(Direction.RIGHT);
			}
			System.out.print("这是VK_RIGHT");
			break;
		case KeyEvent.VK_ENTER:
			//开始游戏，造个新的蛇和豆
			if(GameThread.start == false){
				GameThread.start = true;
				Snake newsnake = new Snake();
				gameWindow.setSnake(newsnake);
				gameWindow.setSbean(new Sbean(newsnake));
			}
			System.out.print("这是VK_ENTER");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

	//鼠标
	@Override
	public void mouseClicked(MouseEvent mouseevent) {
		//MouseEvent中各项属性的内容
		switch (mouseevent.getButton()) {
		case MouseEvent.BUTTON1:
			System.out.print("这是BUTTON1");
			break;
		case MouseEvent.BUTTON3:
			System.out.print("这是BUTTON3");
			break;
		}
		System.out.println(" 位置{x:" + mouseevent.getX() + ",y:" + mouseevent.getY() + "}");
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
}
