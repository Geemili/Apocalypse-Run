package net.dimnstudios.apocalypse.Entities;

import net.dimnstudios.apocalypse.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class EntityEvent implements Entity {
	
	private byte eventGroup = 0x00;
	private byte event = 0x00;
	private byte activationFlag = 0x00;
	private boolean exists = true;
	private World world;
	private Rectangle rect;

	public EntityEvent(World world) {
		this.world = world;
		rect = new Rectangle(0, 0, 16, 16);
	}
	
	@Override
	public void update() {
		if((activationFlag & 0x01)==1) { //00000001
			if(rect.contains(world.getPlayer().getPosition().x, world.getPlayer().getPosition().y)) {
				
			}
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		// No drawing here
		
	}

	@Override
	public boolean isExisting() {
		return exists;
	}

	@Override
	public void setExisting(boolean exists) {
		this.exists = exists;
	}

	@Override
	public void dispose() {
		
	}
	
	public void setPosition(int x, int y) {
		rect.x = x;
		rect.y = y;
	}
	
	public void setDimensions(int width, int height) {
		rect.width = width;
		rect.height = height;
	}
	
	public void setActivationFlag(byte flag) {
		activationFlag = flag;
	}
	
	public void setEvent(byte group, byte event) {
		eventGroup = group;
		this.event = event;
	}

}
