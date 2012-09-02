package net.dimnstudios.apocalypse.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public interface Entity extends Disposable {
	
	public void update();
	public void draw(SpriteBatch batch);
	
	public boolean isExisting();
	public void setExisting(boolean exists);

}
