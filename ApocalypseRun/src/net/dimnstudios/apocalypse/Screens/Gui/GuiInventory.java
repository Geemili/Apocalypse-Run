package net.dimnstudios.apocalypse.Screens.Gui;

import net.dimnstudios.apocalypse.Inventory.Inventory;
import net.dimnstudios.apocalypse.Screens.AbstractScreen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class GuiInventory extends Gui {
	
	private Inventory inv;

	public GuiInventory(AbstractScreen screen) {
		super(screen);
		
		Area exitButton = new Area(0, 8, 48, 20);
		exitButton.setText("Close");
		exitButton.setImage(new TextureRegion(Area.guis, 0, 0, 24, 24));
		exitButton.setClickListener(new ClickListener() {
			@Override
			public void click(Gui gui, int x, int y) {
				gui.screen.setGui(null);
			}
		});
		addArea(exitButton);
		
		pause = true;
	}
	
	public void setInventory(Inventory inventory) {
		inv = inventory;
	}
	
	@Override
	public void render() {
		super.render();
		
		SpriteBatch batch = screen.getBatch();
		Rectangle rect = new Rectangle();
		rect.width = inv.inventory.length*16;
		rect.height = inv.inventory[0].length*16;
		rect.x = -32;
		rect.y = -32;
		
		for(int row=0; row<inv.inventory.length; row++) {
			for(int column=0; column<inv.inventory[row].length; column++) {
				batch.draw(inv.get(row, column).getImage(), rect.x+24*row, rect.y+24*column);
			}
		}
	}

}
