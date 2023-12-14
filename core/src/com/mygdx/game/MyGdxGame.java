package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.Restart;
import com.mygdx.game.Screens.ScreenGame;

public class MyGdxGame extends Game {
	public SpriteBatch batch;


	public static final int SCR_WIDTH = 1280;
	public static final int SCR_HEIGHT = 720;
	public OrthographicCamera camera;
	public ScreenGame screenGame;
	public Restart restart;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		batch = new SpriteBatch();

		screenGame = new ScreenGame (this);
		restart = new Restart(this);
		setScreen(screenGame);


	}

	
	@Override
	public void dispose () {batch.dispose();

	}
}
