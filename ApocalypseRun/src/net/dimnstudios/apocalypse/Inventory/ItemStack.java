package net.dimnstudios.apocalypse.Inventory;

import net.dimnstudios.apocalypse.TexturesOfItems;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ItemStack {
	
	protected Item item;
	
	public ItemStack() {
		setItem(null);
	}
	
	public ItemStack(Item item) {
		setItem(item);
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public TextureRegion getImage() {
		if(item!=null)return item.getImage().image;
		return TexturesOfItems.BLANK.image;
	}

}
