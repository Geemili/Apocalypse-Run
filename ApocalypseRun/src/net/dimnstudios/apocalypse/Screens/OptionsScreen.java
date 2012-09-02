package net.dimnstudios.apocalypse.Screens;

import net.dimnstudios.apocalypse.ApocalypseRun;
import net.dimnstudios.apocalypse.Screens.Gui.Area;
import net.dimnstudios.apocalypse.Screens.Gui.ClickListener;
import net.dimnstudios.apocalypse.Screens.Gui.Gui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class OptionsScreen extends AbstractScreen {

	public OptionsScreen(ApocalypseRun game) {
		super(game);
	}
	
	@Override
	public void show() {
		super.show();
		
		Area text = new Area(10, 220, (int)getFont().getBounds("Options").width, (int)getFont().getBounds("Options").height);
		text.setText("Options");
		
		Area exitButton = new Area(10, 10, 48, 20);
		exitButton.setImage(new TextureRegion(Area.guis, 0, 0, 24, 24));
		exitButton.setText("Exit");
		exitButton.setClickListener(new ClickListener() {
			@Override
			public void click(Gui gui, int x, int y) {
				game.setScreen(game.getMenuScreen());
			}
		});
		
		getGui().addArea(text);
		getGui().addArea(exitButton);
	}

}
