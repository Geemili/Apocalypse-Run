package net.dimnstudios.apocalypse.Inventory;

import net.dimnstudios.apocalypse.TexturesOfItems;
import net.dimnstudios.apocalypse.Entities.EntityPlayer;


public class ItemBacon extends Item implements ItemFood {

	@Override
	public void eat(EntityPlayer player) {
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public TexturesOfItems getImage() {
		return TexturesOfItems.BACON;
	}

}
