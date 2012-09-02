package net.dimnstudios.apocalypse;

import java.util.ArrayList;

import net.dimnstudios.apocalypse.Blocks.Block;
import net.dimnstudios.apocalypse.Entities.EntityPlayer;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ChunkManager {
	
	private ArrayList<Chunk> activeChunks = new ArrayList<Chunk>();
	private Chunk[][] chunks;
	public String saveName = "default";
	public static final int worldWidth = 3;
	public static final int worldHeight = 3;
	
	public void update(Screen screen) {
		for(Chunk c: activeChunks) {
			c.update(screen);
		}
		
		EntityPlayer player = ((GameScreen) screen).world.getPlayer();
		if(player!=null)getChunk(player.getX(), player.getY()).hasPlayer((GameScreen) screen);
	}
	
	public void draw(SpriteBatch batch) {
		for(Chunk c: activeChunks) {
			c.render(batch);
		}
	}

	public void loadWorld() {
		chunks = new Chunk[worldWidth][worldHeight];
		for(int x=0; x<worldWidth; x++) {
			for(int y=0; y<worldHeight; y++) {
				chunks[x][y] = new Chunk(x, y, saveName);
			}
		}
		activeChunks.add(chunks[0][0]);
		activeChunks.add(chunks[0][1]);
		activeChunks.add(chunks[1][0]);
		activeChunks.add(chunks[1][1]);
		
		activeChunks.add(chunks[2][0]);
		activeChunks.add(chunks[2][1]);
		activeChunks.add(chunks[2][2]);
		activeChunks.add(chunks[1][2]);
		activeChunks.add(chunks[0][2]);
	}

	public ArrayList<Chunk> getActiveChunks() {
		return activeChunks;
	}
	
	public Chunk getChunk(float x, float y) {
		int rx = (int) Math.floor(x/(Chunk.chunksize*16));
		int ry = (int) Math.floor(y/(Chunk.chunksize*16));
		return chunks[rx][ry];
	}
	
	public Block getBlock(float x, float y) {
		Chunk c = getChunk(x, y);
		
		int bx = (int) Math.floor((x%256)/16);
		int by = (int) Math.floor((y%256)/16);
		
		try {
			return chunks[c.getX()][c.getY()].getBlock(bx, by);
		} catch(Exception e) {
			return chunks[0][0].getBlock(0, 0);
		}
	}

}
