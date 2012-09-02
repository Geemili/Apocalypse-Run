package net.dimnstudios.apocalypse.Entities;

import net.dimnstudios.apocalypse.Basic;
import net.dimnstudios.apocalypse.Inventory.Inventory;
import net.dimnstudios.apocalypse.Inventory.ItemBacon;
import net.dimnstudios.apocalypse.Screens.GameScreen;
import net.dimnstudios.apocalypse.Screens.Gui.GuiInventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Animation;

public class EntityPlayer extends SimpleEntity {
	
	private float speed = 1.5f;
	private Animation sprDown;
	private Animation sprUp;
	private Animation sprLeft;
	private Animation sprRight;
	private int direction;
	
	private Inventory inventory;
	
	public EntityPlayer(GameScreen screen) {
		super(screen);
	}

	@Override
	public void init() {
		sprDown = Basic.createAnimation("data/images/mobs/jack_down.png", .05F);
		sprUp = Basic.createAnimation("data/images/mobs/jack_up.png", .05F);
		sprRight = Basic.createAnimation("data/images/mobs/jack_right.png", 0.05F);
		sprLeft = Basic.flipAnimation("data/images/mobs/jack_right.png", 0.05F, true, false);
		stateTime = 0F;
		
		sprite = sprDown;
		visible = true;
		direction = 0;
		
		inventory = new Inventory(3, 3);
	}

	public void update() {
		Input in = Gdx.app.getInput();
		
		motionX = 0;
		motionY = 0;
		if(in.isKeyPressed(Input.Keys.UP)) {
			motionY += speed;
			if(!(in.isKeyPressed(Input.Keys.SHIFT_LEFT)))
				direction = 90;
		}
		
		if(in.isKeyPressed(Input.Keys.DOWN)) {
			motionY -= speed;
			if(!(in.isKeyPressed(Input.Keys.SHIFT_LEFT)))
				direction = 270;
		}
		
		if(in.isKeyPressed(Input.Keys.LEFT)) {
			motionX -= speed;
			if(!(in.isKeyPressed(Input.Keys.SHIFT_LEFT)))
				direction = 180;
		}
		
		if(in.isKeyPressed(Input.Keys.RIGHT)) {
			motionX += speed;
			if(!(in.isKeyPressed(Input.Keys.SHIFT_LEFT)))
				direction=0;
		}
		
		if(in.isKeyPressed(Input.Keys.X)) {
			GuiInventory invScreen = new GuiInventory(game);
			invScreen.setInventory(inventory);
			game.setGui(invScreen);
		}
		
		if(in.isKeyPressed(Input.Keys.Z)) {
			EntityItem bacon = new EntityItem(game.world, new ItemBacon());
			bacon.x = (int) (position.x+16);
			bacon.y = (int) position.y;
		}
		
		
		collide();
		moveCamera(game.getCam());
		
		if(motionX!=0||motionY!=0)stateTime += Gdx.graphics.getDeltaTime();
		else stateTime = 0;
			
		switch(direction) {
		case 0:
			sprite = sprRight;
			break;
		case 90:
			sprite = sprUp;
			break;
		case 180:
			sprite = sprLeft;
			break;
		case 270:
			sprite = sprDown;
			break;
		}
	}
	
	private float cameraSpeed = 1;
	private void moveCamera(Camera camera) {
		/*if(x>camera.position.x+1) {
			camera.position.x += cameraSpeed;
		} else if(x<camera.position.x-1) {
			camera.position.x -= cameraSpeed;
		}
		if(y>camera.position.y+1) {
			camera.position.y += cameraSpeed;
		} else if(y<camera.position.y-1) {
			camera.position.y -= cameraSpeed;
		}
		
		float distance = (float) (Math.sqrt(
				Math.pow((camera.position.x-x), 2)+Math.pow((camera.position.y-y), 2)
				));
		
		if(distance>64)cameraSpeed = 2f;
		else cameraSpeed = distance/32;*/
		camera.position.x = position.x;//+AbstractScreen.VIRTUAL_WIDTH/2;
		camera.position.y = position.y;//+AbstractScreen.VIRTUAL_HEIGHT/2;
		camera.update();
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	@Override
	public void dispose() {
		sprite = null;
	}
}
