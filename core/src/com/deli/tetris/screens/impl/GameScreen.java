package com.deli.tetris.screens.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.deli.tetris.game.Board;
import com.deli.tetris.screens.AbstractScreen;
import com.deli.tetris.utils.Settings;

/**
 * Created by denys on 07.05.17.
 */
public class GameScreen extends AbstractScreen implements InputProcessor {

    private Board board;

    private OrthographicCamera camera;
    private Viewport viewport;

    public GameScreen() {
        camera = new OrthographicCamera(Settings.COLS * Settings.CELL_SIZE, Settings.ROWS * Settings.CELL_SIZE);
        camera.position.set(Settings.COLS * Settings.CELL_SIZE / 2, Settings.ROWS * Settings.CELL_SIZE / 2, 0);
//        viewport = new FitViewport(Settings.COLS * Settings.CELL_SIZE, Settings.ROWS * Settings.CELL_SIZE, camera);
        board = new Board(camera);
        board.start();
        Gdx.input.setInputProcessor(this);
    }

    public void processInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            board.moveFigureLeft();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            board.moveFigureRight();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            board.getCurrentFigure().rotate();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            board.accelerateTime();
        }
    }

    @Override
    public void update() {
        processInput();
        board.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render() {
        camera.update();
        board.render();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.S){
            board.normalizeAcceleration();
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
