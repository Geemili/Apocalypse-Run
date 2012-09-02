package net.dimnstudios.apocalypse;

import java.util.LinkedList;
import java.util.Map;

import net.dimnstudios.apocalypse.Entities.Entity;
import net.dimnstudios.apocalypse.Entities.EntityPlayer;
import net.dimnstudios.apocalypse.Screens.GameScreen;
import net.dimnstudios.apocalypse.Scripting.Event;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	
	private LinkedList<Entity> entities = new LinkedList<Entity>();
	private EntityPlayer player;
	private GameScreen game;
	
	private Map<Short, Event> script;

	public World(GameScreen screen) {
		this.game = screen;
	}
	
	public void update() {
		for(int i=0;i<entities.size(); i++) {
			entities.get(i).update();
		}
		
		int num = entities.size();
		for(int i=0;i<num; i++) {
			if(!entities.get(i).isExisting()) {
				entities.remove(i);
				num = entities.size();
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		for(Entity e: entities) {
			e.draw(batch);
		}
	}
	
	public void addEntity(Entity e) {
		entities.addLast(e);
		if(e instanceof EntityPlayer)player = (EntityPlayer) e;
	}
	
	public EntityPlayer getPlayer() {
		return player;
	}

}
