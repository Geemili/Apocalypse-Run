package net.dimnstudios.apocalypse.Blocks;

import net.dimnstudios.apocalypse.BlockType;


public class BlockTree extends Block {

	public BlockTree(int x, int y) {
		super(x, y, BlockType.TREE);
		visible = true;
		solid = true;
	}

}
