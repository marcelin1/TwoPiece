package com.thrs1.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.thrs1.entities.Ammo;
import com.thrs1.entities.Barril;
import com.thrs1.entities.Enemy;
import com.thrs1.entities.Entity;
import com.thrs1.entities.Katana;
import com.thrs1.entities.LifePack;
import com.thrs1.entities.Tree;
import com.thrs1.main.Game;






public class World {
	
	public static Tile[] tiles;
	public static int WIDTH,HEIGHT;
	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth()*map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			for(int xx = 0; xx < map.getWidth(); xx++) {
				for (int yy = 0; yy < map.getHeight(); yy++) {
					int pixelAtual = pixels[xx + (yy*map.getWidth())];
					tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 32, yy * 32, Tile.TILE_FLOOR);
					if(pixelAtual == 0xFFFFFFFF) {
						//floor
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 32, yy * 32, Tile.TILE_FLOOR);
					}
					else if(pixelAtual == 0xFF000000) {
						//wall
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 32, yy * 32, Tile.TILE_WALL);
					}
					else if(pixelAtual == 0xFF00137F) {
						//player
						Game.player.setX(xx*32);
						Game.player.setY(yy*32);
					}
					else if(pixelAtual == 0xFFFF0000 ) {
						//Enemy1
						Game.entities.add(new Enemy(xx*32,yy*32,32,32,Entity.ENEMY1_EN));
					}
					else if(pixelAtual == 0xFF57007F ) {
						//life pack
						Game.entities.add(new LifePack(xx*32,yy*32,32,32,Entity.LIFEPACK_EN));
					}
					else if(pixelAtual == 0xFFFFD800) {
						//ammo
						Game.entities.add(new Ammo(xx*32,yy*32,32,32,Entity.AMMO_EN));
					}
					else if(pixelAtual == 0xFF404040) {
						//katana
						Game.entities.add(new Katana(xx*32,yy*32,32,32,Entity.KATANA_EN));
					}
					else if(pixelAtual == 0xFF7F3300) {
						//barril
						Game.entities.add(new Barril(xx*32,yy*32,32,32,Entity.BARRIL_EN));
					}
					else if(pixelAtual == 0xFF0094FF) {
						//water
						tiles[xx + (yy * WIDTH)] = new WaterTile(xx * 32, yy * 32, Tile.TILE_WATER);
					}
					else if(pixelAtual == 0xFF808080) {
						//path
						tiles[xx + (yy * WIDTH)] = new PathTile(xx * 32, yy * 32, Tile.TILE_PATH);
					}
					else if(pixelAtual == 0xFF007F0E) {
						//tree
						Game.entities.add(new Tree(xx*32,yy*32,32,32,Entity.TREE_EN));
					}

				
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void render(Graphics g) {
		for(int xx = 0; xx < WIDTH; xx++) {
			for(int yy = 0; yy < HEIGHT; yy++) {
			    Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
				
			}
			
		}
		
	}

}
