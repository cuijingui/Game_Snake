package com.wonders.javabasic.snake.model;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import com.wonders.javabasic.snake.ui.GameWindow;

public class Sbean extends Element {
	//继承
	public Sbean(Snake snake) {
		//随机位置
		super(Color.RED);
		Random r = new Random();
		int x = 0;
		int y = 0;
		boolean ifinsnake = true;
		while (ifinsnake) {
			//豆不会生在蛇身上
			ifinsnake = false;
			x = (r.nextInt(GameWindow.grid_x)) * GameWindow.LEN;
			y = (r.nextInt(GameWindow.grid_y)) * GameWindow.LEN;
			if(snake != null){
				if(snake.getHead().getX() == x
						&& snake.getHead().getY() == y){
					ifinsnake = true;
					break;
				}
				List<SnakeBody> bodys = snake.getBody();
				if ((bodys != null) && (!bodys.isEmpty())) {
					for (int i = 0; i < bodys.size(); i++) {
						Element e = bodys.get(i);
						if(e.getX() == x && e.getY() == y){
							ifinsnake = true;
							break;
						}
					}
				}
			}
		}
		
		this.setX(x);
		this.setY(y);
	}
	
	public static void main(String[] args) {
		//测试一下随机类
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(r.nextInt(2));
		}
		
	}
}
