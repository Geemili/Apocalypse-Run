package net.dimnstudios.apocalypse;

import net.dimnstudios.apocalypse.Blocks.Block;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum BlockType {
	
	TREE (0, 0),
	SIGN (0, 0),
	CHEST (0, 0);
	
	public TextureRegion image;
	BlockType(int x, int y) {
		image = Block.terrain[x][y];
	}
	
	public static final byte empty = 0;
	public static final byte tree = 1;
	public static final byte sign = 2;
	public static final byte chest = 3;

}
