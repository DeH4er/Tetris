package com.deli.tetris.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by denys on 07.05.17.
 */
public class Cell {
    private Vector2 position;

    public Cell(int x, int y) {
        position = new Vector2(x , y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new Vector2(x, y);
    }
}
