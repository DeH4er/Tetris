package com.deli.tetris.game;

import com.badlogic.gdx.utils.Array;

import java.util.List;

/**
 * Created by denys on 07.05.17.
 */
public abstract class Figure {
    protected List<Cell> cells;
    protected int maxSizeX;
    protected int maxSizeY;

    public void moveDown() {
        for (Cell cell : cells) {
            cell.setPosition((int)cell.getPosition().x, (int)cell.getPosition().y - 1);
        }
    }

    public int getMaxSizeX() {
        return maxSizeX;
    }

    public int getMaxSizeY() {
        return maxSizeY;
    }

    public void moveLeft() {
        for (Cell cell : cells) {
            cell.setPosition((int)cell.getPosition().x - 1, (int)cell.getPosition().y);
        }
    }

    public void moveRight() {
        for (Cell cell : cells) {
            cell.setPosition((int)cell.getPosition().x + 1, (int)cell.getPosition().y);
        }

    }

    public List<Cell> getCells() {
        return cells;
    }
    public abstract void rotate();
}
