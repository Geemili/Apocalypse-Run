package net.dimnstudios.apocalypse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.dimnstudios.apocalypse.Entities.Entity;
import net.dimnstudios.apocalypse.Entities.EntityEvent;
import net.dimnstudios.apocalypse.Scripting.Event;

import com.badlogic.gdx.Gdx;

public class Loader {
	
	private byte[] file;
	private Chunk[][] chunkMap = new Chunk[16][16];
	private List<byte[]> chunks;
	private List<Entity> entities = new LinkedList<Entity>();
	private byte[] ents;
	private Map<Short, Event> script = new HashMap<Short, Event>();
	
	private World happyPlace; //It's my happy place... /creepy-voice
	private int index = 0;
	
	public Loader(World world) {
		happyPlace = world;
	}
	
	public void importRoom(String name) {
		chunkMap = null;
		entities = null;
		script = null;
		file = Gdx.files.internal("data/world/"+name).readBytes();
		
		chunks = new ArrayList<byte[]>();
		
		index = 0;
		boolean eof = false;
		while(index<file.length && !eof) {
			switch(file[index++]) {
			case 0x00:
				eof = true;
				break;
			case 0x01:
				byte width = file[index++];
				byte height = file[index++];
				byte[] tmp = new byte[4+width*height];
				int tmpi = 0;
				tmp[tmpi++] = width;
				tmp[tmpi++] = height;
				tmp[tmpi++] = file[index++];
				tmp[tmpi++] = file[index++];
				for(byte x = 0; x<width; x++) {
					for(byte y = 0; y<height; y++) {
						tmp[tmpi++] = file[index++];
					}
				}
				break;
			
			case 0x02:
				getEnts();
				break;
			
			case 0x03:
				
				break;
			}
		}
	}
	
	private void getEnts() {
		boolean eof = false;
		while(!eof) {
			switch(file[index++]) {
			case 0x00:
				eof = true;
				break;
			case 0x01:
				EntityEvent newEnt = new EntityEvent(happyPlace);
				newEnt.setPosition(readInt(), readInt());
				newEnt.setDimensions(readInt(), readInt());
				newEnt.setActivationFlag(file[index++]);
				newEnt.setEvent(file[index++], file[index++]);
				entities.add(newEnt);
				break;
			}
		}
	}
	
	private void getScrs() {
		boolean eof = false;
		while(!eof) {
			Event newEvt = new Event(happyPlace);
			short event = readShort();
			while(file[index]!=0x00) {
				switch(file[index++]) {
				case 0x01:
					
				}
			}
		}
	}
	
	private int readInt() {
		byte one = file[index++];
		byte two = file[index++];
		byte three = file[index++];
		byte four = file[index++];
		int tmp = one;
		tmp = tmp << 8;
		tmp += two;
		tmp = tmp << 8;
		tmp += three;
		tmp = tmp << 8;
		tmp += four;
		
		return tmp;
	}
	
	private short readShort() {
		byte one = file[index++];
		byte two = file[index++];
		short tmp = one;
		tmp = (short) (tmp << 8);
		tmp += two;
		
		return tmp;
	}

}
