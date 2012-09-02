package net.dimnstudios.apocalypse.Screens.Gui;

import net.dimnstudios.apocalypse.Screens.AbstractScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Area extends Rectangle {
	
	public float wait = 0;
	
	private TextureRegion image;
	private ClickListener clickListener;
	private WaitListener waitListener;
	private String text;
	private boolean editable;
	
	public Area(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setClickListener(ClickListener listener) {clickListener = listener;}
	public ClickListener getClickListener() {return clickListener;}
	
	public void setWaitListener(WaitListener listener) {waitListener = listener;}
	public WaitListener getWaitListener() {return waitListener;}
	
	public void setImage(TextureRegion region) {image = region;}
	public TextureRegion getImage() {return image;}
	
	public void setText(String message) {text = message;}
	public String getText() {return text;}
	
	public void setEditable(boolean editable) {this.editable = editable;}
	public boolean getEditable() {return editable;}
	
	public void click(Gui gui, int x, int y) {
		System.out.println(x+", "+y);
		if(contains(x, y)) {
			clickListener.click(gui, x, y);
		}
	}
	
	public void edit(int keycode) {
		switch(keycode) {
		
		}
	}
	
	public void update() {
		wait-=Gdx.graphics.getDeltaTime();
		if(wait<=0) {
			wait = 0;
			if(waitListener!=null) {
				waitListener.endOfWait();
			}
		}
	}
	
	public void render(AbstractScreen screen) {
		if(image!=null) {
			screen.getBatch().draw(image, x-128, y-128, width, height);
		}
		if(text!=null) {
			screen.getFont().setColor(Color.BLACK);
			screen.getFont().draw(screen.getBatch(), text, x+8-128, y+16-128);
		}
	}
	
	public static Texture guis;
	public static void loadImage() {
		guis = new Texture("data/gui/guiTileset.png");
	}

}
