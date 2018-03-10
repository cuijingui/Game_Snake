package com.wonders.javabasic.snake.model;

import java.util.ArrayList;
import java.util.List;

import com.wonders.javabasic.snake.enumm.Direction;
import com.wonders.javabasic.snake.ui.GameWindow;

public class Snake {
	//包含
	private SnakeBody head;
	private List<SnakeBody> body;
	private Direction direction;

	public Snake() {
		super();
		//初始化蛇身
		this.body = new ArrayList<SnakeBody>();
		//初始方向为向右
		direction = Direction.RIGHT;
		//蛇头为第0个元素，其他的为蛇身
		head = new SnakeBody(GameWindow.LEN * 5, GameWindow.LEN);
		for (int i = 0; i < 5; i++) {
			this.body.add(new SnakeBody(GameWindow.LEN * (4 - i), GameWindow.LEN));
		}
	}

	public boolean ifdead(){
		//头撞到身体，死
		for (int i = 0; i < body.size(); i++) {
			SnakeBody snakebody = body.get(i);
			if(head.getX() == snakebody.getX() && head.getY() == snakebody.getY()){
				return true;
			}
		}
		//头超出边界，死
		return head.getX() < 0
				|| head.getX() > ((GameWindow.grid_x - 1) * GameWindow.LEN)
				|| head.getY() < 0
				|| head.getY() > ((GameWindow.grid_y - 1) * GameWindow.LEN);
	}

	public boolean ifcaneat(Sbean bean){
		System.out.println(head.getX() +"."+head.getY());
//		System.out.println(bean.getX() +"."+bean.getY());
		return head.getX() == bean.getX() && head.getY() == bean.getY();
	}

	public void turn(Direction direction){
		this.direction = direction;
	}

	public void move(){
		movebody();
		switch (this.direction) {
		case UP:
			head.setY(head.getY() - GameWindow.LEN);
			break;

		case DOWN:
			head.setY(head.getY() + GameWindow.LEN);
			break;

		case LEFT:
			head.setX(head.getX() - GameWindow.LEN);
			break;

		case RIGHT:
			head.setX(head.getX() + GameWindow.LEN);
			break;
		}
	}
	
	public void growup(){
		SnakeBody lastbody = body.get(body.size() - 1);
		SnakeBody addbody = new SnakeBody(lastbody.getX(), lastbody.getY());
		body.add(addbody);
	}
	
	private void movebody(){
		//先移动最后一个身体，移动到前一个身体的位置
		for (int i = body.size() - 1; i > 0; i--) {
			SnakeBody snakebody = body.get(i);
			SnakeBody previousbody = body.get(i - 1);
			snakebody.setX(previousbody.getX());
			snakebody.setY(previousbody.getY());
		}
		//靠近头的第二个身体跟着蛇头
		SnakeBody snakebody = body.get(0);
		snakebody.setX(head.getX());
		snakebody.setY(head.getY());
	}

	public List<SnakeBody> getBody() {
		return body;
	}

	public SnakeBody getHead() {
		return head;
	}
}
