package com.thrs1.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


import com.thrs1.main.Game;

public class Tile {
	public static BufferedImage TILE_FLOOR = Game.spritesheet.getSprite(32*9, 0, 32, 32);
	public static BufferedImage TILE_WALL = Game.spritesheet.getSprite(32*9, 32*3, 32, 32);
	public static BufferedImage TILE_WATER = Game.spritesheet.getSprite(32*6, 32*3, 32, 32);
	public static BufferedImage TILE_PATH = Game.spritesheet.getSprite(32, 32*4, 32, 32);
	
	private BufferedImage sprite;
	private int x,y;
	
	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
		
	}

}
