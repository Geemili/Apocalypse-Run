package net.dimnstudios.apocalypse.Screens;

import net.dimnstudios.apocalypse.ApocalypseRun;
import net.dimnstudios.apocalypse.Screens.Gui.Area;
import net.dimnstudios.apocalypse.Screens.Gui.WaitListener;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashScreen extends AbstractScreen {
	
	private TextureRegion splashTexture;
	Texture tex;

	public SplashScreen(ApocalypseRun game) {
		super(game);
	}
	
	@Override
	public void show() {
		super.show();
		
		tex = new Texture("data/images/splash.png");
		splashTexture = new TextureRegion(tex);
		Area image = new Area(0, 0, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
		image.setImage(splashTexture);
		image.wait = 5;
		image.setWaitListener(new WaitListener() {
			@Override
			public void endOfWait() {
				game.setScreen(game.getMenuScreen());
			}
		});
		
		getGui().addArea(image);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		tex.dispose();
	}

}
