package com.thrs1.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.thrs1.main.Game;
import com.thrs1.world.Camera;


public class Entity {
	
	public static BufferedImage LIFEPACK_EN = Game.spritesheet.getSprite(32*5, 32*2, 32, 32);
	public static BufferedImage KATANA_EN = Game.spritesheet.getSprite(32*6, 32*2, 32, 32);
	public static BufferedImage AMMO_EN = Game.spritesheet.getSprite(32*8, 32*3, 32, 32);
	public static BufferedImage ENEMY1_EN = Game.spritesheet.getSprite(32*4, 32, 32, 32);
	public static BufferedImage BARRIL_EN = Game.spritesheet.getSprite(32*5, 32*3, 32, 32);
	public static BufferedImage TREE_EN = Game.spritesheet.getSprite(32*7, 32*3, 32, 32);
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	private BufferedImage sprite;
	
	private int xmask,ymask,wmask,hmask;
	
	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;
		
		this.xmask = 0;
		this.ymask = 0;
		this.wmask = width;
		this.hmask = height;
	}
	public void setMask(int xmask,int ymask,int wmask,int hmask) {
		this.xmask = xmask;
		this.ymask = ymask;
		this.wmask = wmask;
		this.hmask = hmask;
		
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	
	public int getX() {
		return (int)this.x;
	}
	public int getY() {
		return (int)this.y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
		//g.setColor(Color.red);
		//g.fillRect(this.getX() + xmask - Camera.x, this.getY() + ymask - Camera.y, wmask, hmask);
		
	}
}
