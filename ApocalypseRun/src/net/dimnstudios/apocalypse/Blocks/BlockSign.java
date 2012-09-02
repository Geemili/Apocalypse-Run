package net.dimnstudios.apocalypse.Blocks;

import net.dimnstudios.apocalypse.BlockType;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class BlockSign extends Block {
	
	protected boolean show = false;
	protected String message = "";
	
	public BlockSign(int x, int y) {
		super(x, y, BlockType.SIGN);
		visible = true;
		solid = true;
	}
	
	/*public void setMessage(String[] message) {
		this.message = message;
	}*/
	
	public void setMessage(String message) {
		this.message = message.replace("&n", "\n");
	}

	@Override
	public void onPlayerCross(GameScreen game) {
		if(Gdx.input.isKeyPressed(Keys.Z)) {
			
		}
	}

}
