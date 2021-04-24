package com.thrs1.entities;

import java.awt.image.BufferedImage;

import com.thrs1.main.Game;



public class Player extends Entity {
	
	public boolean right,left,up,down;
	public double speed = 1.5;
	
	private int frames = 0,maxFrames = 5,index = 0,maxIndex = 3;
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
				leftPlayer[i] = Game.spritesheet.getSprite(32 + (16*i), 16, 16, 16);
				}

	}
	public void tick() {
		if(right) {
			x+=speed;
		}
		else if(left) {
			x-=speed;
		}
		if(up) { 
			y-=speed;
		}
		else if(down) { 
			y+=speed;
		}
		
	}

}
