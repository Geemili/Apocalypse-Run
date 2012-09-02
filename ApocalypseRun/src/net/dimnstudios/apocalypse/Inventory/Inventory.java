package net.dimnstudios.apocalypse.Inventory;

import net.dimnstudios.apocalypse.Screens.AbstractScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Inventory {
	
	public ItemStack inventory[][];
	
	public Inventory(int columns, int rows) {
		inventory = new ItemStack[columns][rows];
		clear(null);
	}
	
	public void clear(Item item) {
		for(int row=0; row<inventory.length; row++) {
			for(int column=0; column<inventory[row].length; column++) {
				inventory[row][column] = new ItemStack(item);
			}
		}
	}
	
	public ItemStack get(int x, int y) {
		return inventory[x][y];
	}
	
	public boolean add(Item item) {
		for(ItemStack[] inv: inventory) {
			for(ItemStack i: inv) {
				if(i.getItem()==null) {
					i.setItem(item);
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * 
	 * 
	 */
	public void drawGeneral(SpriteBatch batch) {
		Rectangle rect = new Rectangle();
		rect.width = inventory.length*16;
		rect.height = inventory[0].length*16;
		rect.x = AbstractScreen.VIRTUAL_WIDTH/2-rect.width/2;
		rect.y = AbstractScreen.VIRTUAL_HEIGHT/2-rect.height/2;
		
		for(int row=0; row<inventory.length; row++) {
			for(int column=0; column<inventory[row].length; column++) {
				batch.draw(inventory[row][column].getImage(), rect.x+16*row, rect.y+16*column);
			}
		}
	}

}
