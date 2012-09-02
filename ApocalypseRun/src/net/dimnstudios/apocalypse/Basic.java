package net.dimnstudios.apocalypse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Basic {
	
	public static Animation createAnimation(String path, float duration) {
		FileHandle file = Gdx.files.internal(path);
		Texture tex = new Texture(file);
		TextureRegion[][] textureRegion = TextureRegion.split(tex, 16, 16);
		TextureRegion[] frames = new TextureRegion[tex.getWidth()/16];
		
		int index = 0;
        for (int i = 0; i < tex.getHeight()/16; i++) {
                for (int j = 0; j < tex.getWidth()/16; j++) {
                        frames[index++] = textureRegion[i][j];
                }
        }
        
		return new Animation(duration, frames);
	}
	
	public static Animation flipAnimation(String path, float duration, boolean xb, boolean yb) {
		FileHandle file = Gdx.files.internal(path);
		Texture tex = new Texture(file);
		TextureRegion[][] textureRegion = TextureRegion.split(tex, 16, 16);
		TextureRegion[] frames = new TextureRegion[tex.getWidth()/16];
		
		int index = 0;
        for (int i = 0; i < tex.getHeight()/16; i++) {
                for (int j = 0; j < tex.getWidth()/16; j++) {
                		textureRegion[i][j].flip(xb, yb);
                        frames[index++] = textureRegion[i][j];
                }
        }
        
		return new Animation(duration, frames);
	}
	
	public static Pixmap[][] pixmapSplitter(Pixmap p, int tilewidth, int tileheight) {
		Pixmap[][] pix = new Pixmap[p.getWidth()/tilewidth][p.getHeight()/tileheight];
		Pixmap tmp = new Pixmap(tilewidth, tileheight, Pixmap.Format.RGBA8888);
		for(int x=0; x<p.getWidth()/tilewidth; x++) {
			for(int y=0; y<p.getHeight()/tileheight; y++) {
				tmp = new Pixmap(tilewidth, tileheight, Pixmap.Format.RGBA8888);
				tmp.drawPixmap(p, 0, 0, x*tilewidth, y*tileheight, tilewidth, tileheight);
				pix[x][y] = tmp;
			}
		}
		
		return pix;
	}

	public static Animation createAnimation(Texture tex, float duration) {
		TextureRegion[][] textureRegion = TextureRegion.split(tex, 16, 16);
		TextureRegion[] frames = new TextureRegion[tex.getWidth()/16];
		
		int index = 0;
        for (int i = 0; i < tex.getHeight()/16; i++) {
                for (int j = 0; j < tex.getWidth()/16; j++) {
                        frames[index++] = textureRegion[i][j];
                }
        }
        
		return new Animation(duration, frames);
	}
	
	public static Animation createAnimation(TextureRegion tex, float duration) {
		TextureRegion[][] textureRegion = tex.split(16, 16);
		TextureRegion[] frames = new TextureRegion[tex.getRegionWidth()/16];
		
		int index = 0;
        for (int i = 0; i < tex.getRegionHeight()/16; i++) {
                for (int j = 0; j < tex.getRegionWidth()/16; j++) {
                        frames[index++] = textureRegion[i][j];
                }
        }
        
		return new Animation(duration, frames);
	}
	
	public static float distance(float x, float y, float x1, float y1) {
		return (float) Math.sqrt(Math.pow((x1-x), 2)+Math.pow((y1-y), 2));
	}
}
