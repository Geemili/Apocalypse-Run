package net.dimnstudios.apocalypse.Blocks;

import net.dimnstudios.apocalypse.BlockType;
import net.dimnstudios.apocalypse.Screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class BlockChest extends Block {

	public BlockChest(int x, int y) {
		super(x, y, BlockType.CHEST);
		visible = true;
		solid = true;
	}

	@Override
	public void onPlayerCross(GameScreen game) {
		if(Gdx.input.isKeyPressed(Keys.Z)) {
			
		}
	}

}
