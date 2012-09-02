package net.dimnstudios.apocalypse.Scripting;

import net.dimnstudios.apocalypse.World;

public interface Action {
	
	public void execute();
	public void giveArguments(World world, byte[] args);

}
