package net.dimnstudios.apocalypse.Screens;

import net.dimnstudios.apocalypse.ApocalypseRun;
import net.dimnstudios.apocalypse.Chunk;
import net.dimnstudios.apocalypse.ChunkManager;
import net.dimnstudios.apocalypse.World;
import net.dimnstudios.apocalypse.Blocks.Block;
import net.dimnstudios.apocalypse.Entities.EntityPlayer;
import net.dimnstudios.apocalypse.Inventory.Item;

import com.badlogic.gdx.graphics.Color;

public class GameScreen extends AbstractScreen {
	
	public World world;
	public ChunkManager chunkManager;

	public GameScreen(ApocalypseRun game) {
		super(game);
	}
	
	@Override
	public void show() {
		Block.loadTexture();
		Chunk.loadTexture();
		Item.loadTexture();
		
		chunkManager = new ChunkManager();
		chunkManager.loadWorld();
		world = new World(this);
		//world.load();
		
		EntityPlayer jack = new EntityPlayer(this);
		jack.setX(32);
		jack.setY(32);
	}
	
	@Override
	public void update() {
		if(!getGui().shouldPause()) {
			world.update();
			chunkManager.update(this);
		}
		super.update();
	}
	
	@Override
	public void draw() {
		if(getGui().shouldPause()) {
			getBatch().setColor(Color.DARK_GRAY);
		}
		chunkManager.draw(getBatch());
		world.render(getBatch());
		getBatch().setColor(Color.WHITE);
	}

}
