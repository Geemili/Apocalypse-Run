package net.dimnstudios.apocalypse;

import net.dimnstudios.apocalypse.Inventory.Item;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public enum TexturesOfItems {
	
	CAKE (0, 0),
	BREAD (0, 1),
	BACON (0, 2),
	BLANK (3, 3),
	SOUP (0, 3);
	
	public TextureRegion image;
	TexturesOfItems(int x, int y) {
		image = Item.itemSheet[x][y];
	}

}
