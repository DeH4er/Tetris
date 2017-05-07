package com.deli.tetris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.deli.tetris.game.impl.FigureSet;
import com.deli.tetris.utils.Settings;

/**
 * Created by denys on 07.05.17.
 */
public class Board {
    private Cell[][] board;
    private Figure currentFigure;
    protected float time;
    protected float timeBorder;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    public Board(OrthographicCamera camera) {
        board = new Cell[Settings.COLS + 4][Settings.ROWS + 4];
        for (int y = 0; y < Settings.ROWS; y++) {
            for (int x = 0; x < Settings.COLS; x++) {
                board[x][y] = null;
            }
        }

//        this.viewport = viewport;
        this.camera = camera;

        currentFigure = FigureSet.getRandomFigure();
        time = 0;
        timeBorder = 1f;

        shapeRenderer = new ShapeRenderer();
    }

    public void moveFigureLeft() {
        boolean canMoveLeft = true;

        for (Cell cell : currentFigure.getCells()) {

            int x = (int) cell.getPosition().x;
            int y = (int) cell.getPosition().y;

            if (x <= 0) {
                canMoveLeft = false;
            } else if (board[x - 1][y] != null) {
                canMoveLeft = false;
            }
        }

        if (canMoveLeft) {
            currentFigure.moveLeft();
        }
    }

    public void moveFigureRight() {
        boolean canMoveRight = true;
        for (Cell cell : currentFigure.getCells()) {

            int x = (int) cell.getPosition().x;
            int y = (int) cell.getPosition().y;
                if (x >= Settings.COLS - 1) {
                    canMoveRight = false;
                } else if (board[x + 1][y] != null) {
                    canMoveRight = false;
                }
            }

        if (canMoveRight) {
            currentFigure.moveRight();
        }
    }

    public void generateFigure() {
        //TODO 'freeze' currentFigure and move on
        for (Cell cell : currentFigure.getCells()) {
            board[(int) cell.getPosition().x][(int) cell.getPosition().y] = new Cell((int) cell.getPosition().x, (int) cell.getPosition().y);
        }

        currentFigure = FigureSet.getRandomFigure();
    }

    public void start() {
//        currentFigure = FigureSet.getRandomFigure();
    }

    public void update() {
        //TODO check collisions with currentFigure
        //TODO move figure down if there is no collisions
        //TODO else 'freeze' figure and generate new
        time += Gdx.graphics.getDeltaTime();

        if (time >= timeBorder) {
            boolean freeze = false;

            for (int i = 0; i < currentFigure.getCells().size() && !freeze; i++) {

                Cell cell = currentFigure.getCells().get(i);

                if ((int) cell.getPosition().y > 0) {
//                    if ((int) cell.getPosition().y < 20)
                    if (board[(int) cell.getPosition().x][(int) cell.getPosition().y - 1] != null) {
                        generateFigure();
                        freeze = true;
                    }
                } else {
                    generateFigure();
                    freeze = true;
                }
            }

            if (!freeze) {
                currentFigure.moveDown();

            }
            time -= timeBorder;
        }


    }

    public void render() {

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.setColor(Color.WHITE);

        for (int y = 0; y < Settings.ROWS; y++) {
            for (int x = 0; x < Settings.COLS; x++) {
                if (board[x][y] != null) {
                    shapeRenderer.rect(x * Settings.CELL_SIZE, y * Settings.CELL_SIZE, Settings.CELL_SIZE, Settings.CELL_SIZE);
                }
            }
        }

        shapeRenderer.setColor(Color.GREEN);

        for (Cell cell : currentFigure.getCells()) {
            shapeRenderer.rect(cell.getPosition().x * Settings.CELL_SIZE, cell.getPosition().y * Settings.CELL_SIZE, Settings.CELL_SIZE, Settings.CELL_SIZE);
        }

        shapeRenderer.end();
    }

    private void removeLine(int lineNumber) {

    }

    private boolean wasCollision() {
        return false;
    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }

    public void accelerateTime() {
        timeBorder = timeBorder * 0.1f;
    }
}
