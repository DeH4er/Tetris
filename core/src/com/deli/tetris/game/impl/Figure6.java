package com.deli.tetris.game.impl;

import com.badlogic.gdx.utils.Array;
import com.deli.tetris.game.Cell;
import com.deli.tetris.game.Figure;

import java.util.ArrayList;

/**
 * Created by denys on 07.05.17.
 */
public class Figure6 extends Figure {

    public Figure6() {
        cells = new ArrayList<Cell>();
        cells.add(new Cell(5, 22));
        cells.add(new Cell(6, 22));
        cells.add(new Cell(6, 21));
        cells.add(new Cell(6, 20));
        maxSizeX = 2;
        maxSizeY = 3;
    }

    @Override
    public void rotate() {

    }
}
