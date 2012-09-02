package net.dimnstudios.apocalypse.Blocks;

import net.dimnstudios.apocalypse.BlockType;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Block {
	
	public static TextureRegion[][] terrain;
	protected boolean solid = false;
	protected boolean visible = false;
	protected int x = 0;
	protected int y = 0;
	public BlockType type;
	
	public Block(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Block(int x, int y, BlockType type)
	{
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public static void loadTexture() {
		terrain = TextureRegion.split(new Texture("data/images/tile_forest.png"), 16, 16);
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	//Events
	public void onPlayerCross(GameScreen screen) {}
	public void onPlayerStand(GameScreen screen) {}
}
