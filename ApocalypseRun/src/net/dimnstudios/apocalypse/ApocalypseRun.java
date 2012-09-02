package net.dimnstudios.apocalypse;

import net.dimnstudios.apocalypse.Screens.*;
import net.dimnstudios.apocalypse.Screens.Gui.Area;

import com.badlogic.gdx.Game;

public class ApocalypseRun extends Game {
    
	@Override
	public void create()
	{
		Area.loadImage();
		//setScreen(getSplashScreen());
		setScreen(getMenuScreen());
	}

	@Override
	public void dispose()
	{
		Area.guis.dispose();
		super.dispose();
	}

	@Override
	public void pause()
	{
		super.pause();
	}

	@Override
	public void render()
	{
		super.render();
	}

	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);
	}

	@Override
	public void resume()
	{
		super.resume();
	}
	
	public SplashScreen getSplashScreen() {return new SplashScreen(this);}
	public MenuScreen getMenuScreen() {return new MenuScreen(this);}
	public GameScreen getGameScreen() {return new GameScreen(this);}
	public OptionsScreen getOptionsScreen() {return new OptionsScreen(this);}

}
