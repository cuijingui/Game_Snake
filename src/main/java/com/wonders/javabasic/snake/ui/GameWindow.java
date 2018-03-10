package com.wonders.javabasic.snake.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.wonders.javabasic.snake.model.Element;
import com.wonders.javabasic.snake.model.Sbean;
import com.wonders.javabasic.snake.model.Snake;
import com.wonders.javabasic.snake.model.SnakeBody;
import com.wonders.javabasic.snake.thread.GameThread;

public class GameWindow {
	public final static int grid_x = 18;
	public final static int grid_y = 18;
	public final static int LEN = 20;
	private int width;
	private int height;
	private JFrame jframe;
	private JComponent component;
	private boolean gamestatus = true;
	private GameThread gameThread;

	
	public GameWindow(GameThread gameThread){
		this.gameThread = gameThread;
		jframe = new JFrame();
		width = grid_x * LEN + 10 * 2;
		height = grid_y * LEN + 30 + 10 * 2;
		jframe.setSize(width, height);

		jframe.setBackground(Color.gray);
		component = new Mycomponent();
		jframe.add(component);
		
		WindowEventListener mwel = new WindowEventListener(this);
		
		jframe.addKeyListener(mwel);
		jframe.addMouseMotionListener(mwel);
		jframe.addMouseListener(mwel);
		
		jframe.setVisible(true);
		jframe.repaint();
	}

	public void freshWindow(){
		jframe.repaint();
	}

	public void gamestatus(boolean gamestatus){
		this.gamestatus = gamestatus;
	}
	
	@SuppressWarnings("serial")
	class Mycomponent extends JComponent {

		@Override
		public void paint(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			int borderX = grid_x * LEN;
			int borderY = grid_y * LEN;
			g2d.drawLine(0, 0, borderX, 0);
			g2d.drawLine(0, 0, 0, borderY);
			g2d.drawLine(borderX, 0, borderX, borderY);
			g2d.drawLine(0, borderY, borderX, borderY);
			Snake snake = gameThread.getSnake();
			Sbean sbean = gameThread.getSbean();
			if(snake != null){
				snake.getHead().show(g2d);
				List<SnakeBody> bodys = snake.getBody();
				if ((bodys != null) && (!bodys.isEmpty())) {
					for (int i = 0; i < bodys.size(); i++) {
						Element e = bodys.get(i);
						e.show(g2d);
					}
				}
			}
			if(sbean != null){
				sbean.show(g2d);
			}
			
			if(!gamestatus){
				g2d.drawString("回车以开始新的游戏", grid_x * LEN / 2 - 100, grid_y * LEN / 5);
			}
		}

	}
	
	public Snake getSnake(){
		return gameThread.getSnake();
	}

	public void setSnake(Snake snake) {
		gameThread.setSnake(snake);
	}

	public void setSbean(Sbean sbean) {
		gameThread.setSbean(sbean);
	}
}
