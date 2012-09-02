package net.dimnstudios.apocalypse.Screens.Gui;

import java.util.LinkedList;

import net.dimnstudios.apocalypse.Screens.AbstractScreen;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

public class Gui extends InputAdapter {
	
	private LinkedList<Area> areas;
	public AbstractScreen screen;
	
	protected boolean pause = false; //Set to true to stop game logic
	
	public Gui(AbstractScreen screen) {
		this.screen = screen;
		areas = new LinkedList<Area>();
	}
	
	public void update() {
		int num = areas.size();
		for(int i=0;i<num; i++) {
			areas.get(i).update();
			if(areas.size()<num) {
				num = areas.size();
			}
		}
	}
	
	public void render() {
		int num = areas.size();
		
		for(int i=0;i<num; i++) {
			areas.get(i).render(screen);
		}
	}
	
	public void addArea(Area area) {
		areas.addLast(area);
	}
	
	final Vector3 tmp = new Vector3();
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int mouse) {
		screen.getGuiCam().unproject(tmp.set(x, y, 0));
		
		int guiX = (int) tmp.x+AbstractScreen.VIRTUAL_WIDTH/2;//(int) (tmp.x-(screen.getCam().position.x-AbstractScreen.VIRTUAL_WIDTH/2));
		int guiY = (int) tmp.y+AbstractScreen.VIRTUAL_HEIGHT/2;//(int) (tmp.y-(screen.getCam().position.y-AbstractScreen.VIRTUAL_HEIGHT/2));
		
		int num = areas.size();
		for(int i=0;i<num; i++) {
			if(areas.get(i).getClickListener()!=null) areas.get(i).click(this, guiX, guiY);
			if(areas.size()<num) {
				num = areas.size();
			}
		}
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		int num = areas.size();
		for(int i=0;i<num; i++) {
			if(areas.get(i).getEditable()) areas.get(i).edit(keycode);
			if(areas.size()<num) {
				num = areas.size();
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(areas.size()<1) {
			return true;
		}
		return false;
	}
	
	public void removeArea(Area area) {
		areas.remove(area);
	}
	
	public boolean shouldPause() {
		return pause;
	}
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}

}
