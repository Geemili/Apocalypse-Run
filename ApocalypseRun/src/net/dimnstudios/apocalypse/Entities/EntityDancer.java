package net.dimnstudios.apocalypse.Entities;

import net.dimnstudios.apocalypse.Basic;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;

public class EntityDancer extends SimpleEntity {

	public EntityDancer(GameScreen game) {
		super(game);
	}

	private Animation sprDown;
	private Animation sprUp;
	private Animation sprLeft;
	private Animation sprRight;
	private float time;
	
	@Override
	public void init() {
		setSkin("template");
	}
	
	public void setSkin(String name) {
		sprDown = Basic.createAnimation("data/images/mobs/"+name+"_down.png", .1F);
		sprUp = Basic.createAnimation("data/images/mobs/"+name+"_up.png", .1F);
		sprRight = Basic.createAnimation("data/images/mobs/"+name+"_right.png", 0.1F);
		sprLeft = Basic.flipAnimation("data/images/mobs/"+name+"_right.png", 0.1F, true, false);
		time = 0F;
		
		sprite = sprDown;
		visible = true;
	}
	
	public void update() {
		time += Gdx.graphics.getDeltaTime();
		stateTime += Gdx.graphics.getDeltaTime();
		if(time > 0.5F) {
			
			if(sprite==sprDown) {sprite = sprLeft;}
			else if(sprite==sprUp) {sprite = sprRight;}
			else if(sprite==sprLeft) {sprite = sprUp;}
			else if(sprite==sprRight) {sprite = sprDown;}
			
			time = 0;
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
