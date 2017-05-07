package com.deli.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deli.tetris.screens.ScreenManager;
import com.deli.tetris.screens.impl.GameScreen;

public class Tetris implements ApplicationListener {
	SpriteBatch batch;
	ScreenManager screenManager;
	
	@Override
	public void create () {
		screenManager = new ScreenManager();
		batch = new SpriteBatch();
		screenManager.push(new GameScreen());
	}

	@Override
	public void resize(int width, int height) {
		screenManager.resize(width, height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		screenManager.update();
		screenManager.render(batch);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
