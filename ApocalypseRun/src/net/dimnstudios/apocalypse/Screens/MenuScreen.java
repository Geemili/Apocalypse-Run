package net.dimnstudios.apocalypse.Screens;

import net.dimnstudios.apocalypse.ApocalypseRun;
import net.dimnstudios.apocalypse.Screens.Gui.Area;
import net.dimnstudios.apocalypse.Screens.Gui.ClickListener;
import net.dimnstudios.apocalypse.Screens.Gui.Gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuScreen extends AbstractScreen {

	public MenuScreen(ApocalypseRun game) {
		super(game);
	}
	
	@Override
	public void show() {
		super.show();
		
		TextureRegion reg = new TextureRegion(Area.guis, 0, 0, 24, 24);
		
		Area playButton = new Area(10, 200, 50, 20);
		playButton.setImage(reg);
		playButton.setText("Play");
		playButton.setClickListener(new ClickListener() {
			@Override
			public void click(Gui gui, int x, int y) {
				game.setScreen(game.getGameScreen());
			}
		});
		
		Area optionsButton = new Area(10, 160, 64, 20);
		optionsButton.setImage(reg);
		optionsButton.setText("Options");
		optionsButton.setClickListener(new ClickListener() {
			@Override
			public void click(Gui gui, int x, int y) {
				final Area text = new Area(128, 220, (int)getFont().getBounds("Options").width, (int)getFont().getBounds("Options").height);
				text.setText("Options");
				
				final Area closeButton = new Area(128, 10, 48, 20);
				closeButton.setImage(new TextureRegion(Area.guis, 0, 0, 24, 24));
				closeButton.setText("Close");
				closeButton.setClickListener(new ClickListener() {
					@Override
					public void click(Gui gui, int x, int y) {
						gui.removeArea(text);
						gui.removeArea(closeButton);
					}
				});
				
				gui.addArea(text);
				gui.addArea(closeButton);
			}
		});
		
		Area exitButton = new Area(10, 10, 50, 20);
		exitButton.setImage(reg);
		exitButton.setText("Quit");
		exitButton.setClickListener(new ClickListener() {
			@Override
			public void click(Gui gui, int x, int y) {
				Gdx.app.exit();
			}
		});
		
		getGui().addArea(optionsButton);
		getGui().addArea(playButton);
		getGui().addArea(exitButton);
	}

}
