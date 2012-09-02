package net.dimnstudios.apocalypse.Entities;

import net.dimnstudios.apocalypse.Basic;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

public class EntityFollower extends SimpleEntity {
	
	private Animation sprDown;
	private Animation sprUp;
	private Animation sprLeft;
	private Animation sprRight;
	private float speed = 1f;
	private SimpleEntity target;
	private int direction;
	private int distance = 15;
	
	private Vector2 point = new Vector2();
	
	public EntityFollower(GameScreen screen) {
		super(screen);
	}

	@Override
	public void init() {
		setSkin("template");
		target = game.world.getPlayer();
	}
	
	public void setSkin(String name) {
		sprDown = Basic.createAnimation("data/images/mobs/"+name+"_down.png", .1F);
		sprUp = Basic.createAnimation("data/images/mobs/"+name+"_up.png", .1F);
		sprRight = Basic.createAnimation("data/images/mobs/"+name+"_right.png", 0.1F);
		sprLeft = Basic.flipAnimation("data/images/mobs/"+name+"_right.png", 0.1F, true, false);
		stateTime = 0F;
		
		sprite = sprDown;
		visible = true;
	}
	
	public void setLeader(SimpleEntity leader) {
		target = leader;
	}
	
	public void update() {
		super.update();
		Vector2 target = point;
		motionX=0;
		motionY=0;
		
		if(position.y>target.y+distance) {
			motionY-=speed;
			direction = 270;
		}
		if(position.y<target.y-distance) {
			motionY+=speed;
			direction = 90;
		}
		if(position.x>target.x+distance) {
			motionX-=speed;
			direction = 180;
		}
		if(position.x<target.x-distance) {
			motionX+=speed;
			direction = 0;
		}
		
		collide();
			
		stateTime += Gdx.graphics.getDeltaTime();
		
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
		
		if(Basic.distance(position.x, position.y, target.x, target.y)<16) {
			updatePoint();
		}
	}
	
	public void updatePoint() {
		point.x = target.getX();
		point.y = target.getY();
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public void dispose() {
		
	}

}
