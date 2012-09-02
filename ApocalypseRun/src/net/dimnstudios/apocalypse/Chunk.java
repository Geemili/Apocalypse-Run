package net.dimnstudios.apocalypse;

import java.io.DataInputStream;
import java.io.IOException;

import net.dimnstudios.apocalypse.Blocks.*;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Chunk {
	
	public static final int chunksize = 16;
	protected Block[][] blocks;
	protected String saveName;
	protected int x;
	protected int y;
	protected byte width;
	protected byte height;
	
	public static Texture background;
	
	public Chunk(int x, int y, String name) {
		saveName = "data/world/chunks/chunkx"+x+'y'+y+".lvl";
		blocks = new Block[16][16];
		this.x = x;
		this.y = y;
		
		load();
	}
	
	public static void loadTexture() {
		background = new Texture("data/images/bg_forest.png");
	}
	
	public Block getBlock(int x, int y) {
		return blocks[x][y];
	}
	
	public int getX() {return x;}
	public int getY() {return y;}

	public void render(SpriteBatch batch) {
		for(int xx=0; xx<blocks.length; xx++) {
			for(int yy=0; yy<blocks[xx].length; yy++) {
				if(xx%2==0 && yy%2==0)batch.draw(background, (x*chunksize*16)+xx*16, (y*chunksize*16)+yy*16);
				if(blocks[xx][yy].isVisible())batch.draw(blocks[xx][yy].type.image, (x*chunksize*16)+xx*16, (y*chunksize*16)+yy*16);
			}
		}
		
	}

	public void hasPlayer(GameScreen screen) {
		ChunkManager chunkm = screen.chunkManager;
		int originx = (int) screen.world.getPlayer().getX();
		int originy = (int) screen.world.getPlayer().getY();
		
		chunkm.getBlock(originx, originy).onPlayerCross(screen);
		chunkm.getBlock(originx+16, originy).onPlayerCross(screen);
		chunkm.getBlock(originx-16, originy).onPlayerCross(screen);
		chunkm.getBlock(originx, originy+16).onPlayerCross(screen);
		chunkm.getBlock(originx, originy-16).onPlayerCross(screen);
	}
	
	private void load() {
		FileHandle file = Gdx.files.internal(saveName);
		DataInputStream doi = new DataInputStream(file.read());
		
		try {
			width = doi.readByte();
			height = doi.readByte();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		for(int posX=0; posX<width; posX++) {
			for(int posY=0; posY<height; posY++) {
				try {
					switch(doi.readByte()) {
					case BlockType.tree:
						blocks[posX][posY] = new BlockTree(posX, posY);
						break;
					case BlockType.sign:
						blocks[posX][posY] = new BlockSign(posX, posY);
						break;
					case BlockType.chest:
						blocks[posX][posY] = new BlockChest(posX, posY);
						break;
					default:
						blocks[posX][posY] = new Block(posX, posY);
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void update(Screen screen) {
		
	}

}
