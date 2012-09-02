package net.dimnstudios.apocalypse.Screens;

import net.dimnstudios.apocalypse.ApocalypseRun;
import net.dimnstudios.apocalypse.Screens.Gui.Gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractScreen implements Screen {
	
	protected final ApocalypseRun game;
	
	private BitmapFont font;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private OrthographicCamera guiCamera;
	private Gui gui;
	
	public static final int VIRTUAL_WIDTH = 320;
    public static final int VIRTUAL_HEIGHT = 240;
    private static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
    private Rectangle viewport = new Rectangle(0, 0, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
	
	public AbstractScreen(ApocalypseRun game) {
		this.game = game;
		
		getBatch();
		getFont();
		getCam();
		getGuiCam();
	}

	protected String getName() {
		return getClass().getSimpleName();
	}
	
	public BitmapFont getFont()
	{
		if( font == null ) {
			FileHandle fontFile = Gdx.files.internal("data/gui/ubuntumono.fnt");
			FileHandle pngFile = Gdx.files.internal("data/gui/ubuntumono.png");
			font = new BitmapFont(fontFile, pngFile, false);
		}
		return font;
	}

	public SpriteBatch getBatch()
	{
		if( batch == null ) {
			batch = new SpriteBatch();
		}
		return batch;
	}
	
	public OrthographicCamera getCam()
	{
		if( camera == null ) {
			camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
			camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
		}
		return camera;
	}
	
	public OrthographicCamera getGuiCam()
	{
		if( guiCamera == null ) {
			guiCamera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
			guiCamera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
		}
		return guiCamera;
	}
	
	public Gui getGui()
	{
		if( gui == null ) {
			gui = new Gui(this);
			Gdx.input.setInputProcessor(gui);
		}
		return gui;
	}

	@Override
	public void dispose() {
		if(font!=null)font.dispose();
		if(batch!=null)batch.dispose();
	}

	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		camera.apply(Gdx.gl10);
		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
                (int) viewport.width, (int) viewport.height);
		batch.setProjectionMatrix(camera.combined);
		
		update();
		batch.begin();
		draw();
		batch.end();
		
		batch.setProjectionMatrix(guiCamera.combined);
		batch.begin();
		drawGui();
		batch.end();
	}
	
	public void update() {
		getGui().update();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	public void draw() {
		
	}
	
	public void drawGui() {
		gui.render();
	}

	@Override
	public void resize(int width, int height)
	{
        float aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        
        if(aspectRatio > ASPECT_RATIO)
        {
            scale = (float)height/(float)VIRTUAL_HEIGHT;
            crop.x = (width - VIRTUAL_WIDTH*scale)/2f;
        }
        else if(aspectRatio < ASPECT_RATIO)
        {
            scale = (float)width/(float)VIRTUAL_WIDTH;
            crop.y = (height - VIRTUAL_HEIGHT*scale)/2f;
        }
        else
        {
            scale = (float)width/(float)VIRTUAL_WIDTH;
        }

        float w = (float)VIRTUAL_WIDTH*scale;
        float h = (float)VIRTUAL_HEIGHT*scale;
        viewport = new Rectangle(crop.x, crop.y, w, h);
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void show() {
		
	}
	
	public ApocalypseRun getGameMainFrame() {
		return game;
	}
	
	public void setGui(Gui gui) {
		this.gui = gui;
		Gdx.input.setInputProcessor(gui);
	}

}
