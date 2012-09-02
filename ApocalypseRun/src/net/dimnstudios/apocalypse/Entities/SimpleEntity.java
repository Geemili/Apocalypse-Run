package net.dimnstudios.apocalypse.Entities;

import net.dimnstudios.apocalypse.Blocks.Block;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class SimpleEntity implements Entity {
	
	protected boolean exists = true;
	
	protected Vector2 position;
	
	protected float width = 16;
	protected float height = 16;
	
	protected float motionX = 0;
	protected float motionY = 0;
	protected float stateTime = 0;
	protected Animation sprite;
	protected boolean visible = false;
	
	protected GameScreen game;
	
	public SimpleEntity(GameScreen game) {
		this.game = game;
		game.world.addEntity(this);
		position = new Vector2();
		init();
	}
	
	public abstract void init();
	
	public void update() {
		position.x += motionX;
		position.y += motionY;
	}
	
	public void draw(SpriteBatch batch) {
		if(visible) {
			batch.draw(sprite.getKeyFrame(stateTime, true), position.x-width/2, position.y-height/2);
		}
	}
	
	final Block[] block = new Block[4];;
	
	protected void collide() {
		if(motionX!=0||motionY!=0) {
			float nPosX = position.x+motionX;
			float nPosY = position.y;
			
			block[0] = game.chunkManager.getBlock(nPosX-width/3, nPosY-height/2.25f);
			block[1] = game.chunkManager.getBlock(nPosX+width/3, nPosY-height/2.25f);
			block[2] = game.chunkManager.getBlock(nPosX-width/3, nPosY+height/2.25f);
			block[3] = game.chunkManager.getBlock(nPosX+width/3, nPosY+height/2.25f);
			
			if(!(block[0].isSolid()||block[1].isSolid()||block[2].isSolid()||block[3].isSolid())) {
				position.x = nPosX;
				position.y = nPosY;
			}
			
			nPosX = position.x;
			nPosY = position.y+motionY;
			
			block[0] = game.chunkManager.getBlock(nPosX-width/3, nPosY-height/2.25f);
			block[1] = game.chunkManager.getBlock(nPosX+width/3, nPosY-height/2.25f);
			block[2] = game.chunkManager.getBlock(nPosX-width/3, nPosY+height/2.25f);
			block[3] = game.chunkManager.getBlock(nPosX+width/3, nPosY+height/2.25f);
			
			if(!(block[0].isSolid()||block[1].isSolid()||block[2].isSolid()||block[3].isSolid())) {
				position.x = nPosX;
				position.y = nPosY;
			}
		}
	}
	
	public float getX() {return position.x;}
	public float getY() {return position.y;}
	public float getMotionX() {return motionX;}
	public float getMotionY() {return motionY;}
	
	public Vector2 getPosition() {return position;}
	
	public void setX(float f) {position.x = f;}
	public void setY(float f) {position.y = f;}
	public void setMotionX(float f) {this.motionX = f;}
	public void setMotionY(float f) {this.motionY = f;}
	
	public boolean isExisting() {
		return exists;
	}
	
	public void setExisting(boolean exists) {
		this.exists = exists;
	}
}
