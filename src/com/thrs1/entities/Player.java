package com.thrs1.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.thrs1.main.Game;



public class Player extends Entity {
	
	public boolean right,left,up,down;
	public int dir_right = 0,dir_left = 1;
	public int dir = dir_right;
	public double speed = 1.5;
	
	private boolean moved = false;
	
	private int frames = 0,maxFrames = 5,index = 0,maxIndex = 2;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		
		for(int i = 0; i<4; i++){
			rightPlayer[i] = Game.spritesheet.getSprite(0 + (i*32), 0, 32, 32);
			}
			
			for(int i = 0; i<4; i++){
				leftPlayer[i] = Game.spritesheet.getSprite(96 + (32*i), 0, 32, 32);
				}

	}
	public void tick() {
		moved = false;
		if(right) {
			moved = true;
			dir = dir_right;
			x+=speed;
		}
		else if(left) {
			moved = true;
			dir = dir_left;
			x-=speed;
		}
		if(up) { 
			moved = true;
			y-=speed;
		}
		else if(down) { 
			moved = true;
			y+=speed;
		}
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
		
	}
	public void render(Graphics g) {
		if(dir == dir_right) {
		g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		}else if(dir == dir_left) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}
	}

}
