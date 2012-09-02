package net.dimnstudios.apocalypse.Scripting;

import java.util.LinkedList;

import net.dimnstudios.apocalypse.World;


public class Event {
	
	private LinkedList<Action> script;
	private World world;
	
	public Event(World world) {
		this.world = world;
	}
	
	public void setScript(LinkedList<Action> script) {
		this.script = script;
	}
	
	public static Event parse(World world, byte[] list) {
		LinkedList<Action> tmpScr = new LinkedList<Action>();
		
		int i = 0;
		while(i < list.length) {
			switch(list[i]) {
			case 0:
				
				break;
			}
		}
		
		Event ev = new Event(world);
		//ev.setScript(script);
		return ev;
	}

}
