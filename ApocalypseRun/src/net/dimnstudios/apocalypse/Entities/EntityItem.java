package net.dimnstudios.apocalypse.Entities;

import net.dimnstudios.apocalypse.World;
import net.dimnstudios.apocalypse.Inventory.Item;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityItem implements Entity {
	
	private Item item;
	public int x;
	public int y;
	public int time = 0;
	private World world;
	
	private boolean exists;

	public EntityItem(World world, Item item) {
		world.addEntity(this);
		this.item = item;
		this.world = world;
		exists = true;
	}
	
	@Override
	public void update() {
		time += 1;
		if(time > 600)exists = false;
		
		EntityPlayer player = world.getPlayer();
		if(player.getX()>=x-4 && player.getX()<=x+4 && player.getY()>=y-4 && player.getY()<=y+4) {
			if(player.getInventory().add(item)) {
				exists = false;
			}
		}
	}
	
	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(item.getImage().image, x, y, 8, 8);
	}

	@Override
	public void dispose() {}

	@Override
	public boolean isExisting() {
		return exists;
	}

	@Override
	public void setExisting(boolean exists) {
		this.exists = exists;
	}

}
