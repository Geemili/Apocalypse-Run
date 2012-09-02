package net.dimnstudios.apocalypse.Inventory;

import net.dimnstudios.apocalypse.TexturesOfItems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Item {
	
	public static TextureRegion[][] itemSheet;
	
	protected int var;
	
	public static void loadTexture() {
		Texture itemTexture = new Texture(Gdx.files.internal("data/images/items.png"));
		itemSheet = TextureRegion.split(itemTexture, 16, 16);
	}
	
	public abstract void init();
	
	public int getVarValue() {
		return var;
	}
	
	public abstract TexturesOfItems getImage();

}
