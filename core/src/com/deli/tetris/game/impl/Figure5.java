package com.deli.tetris.game.impl;

import com.badlogic.gdx.utils.Array;
import com.deli.tetris.game.Cell;
import com.deli.tetris.game.Figure;

import java.util.ArrayList;

/**
 * Created by denys on 07.05.17.
 */
public class Figure5 extends Figure {

    public Figure5() {
        cells = new ArrayList<Cell>();
        cells.add(new Cell(5, 20));
        cells.add(new Cell(6, 20));
        cells.add(new Cell(7, 20));
        cells.add(new Cell(8, 20));
        maxSizeX = 4;
        maxSizeY = 1;
    }

    @Override
    public void rotate() {

    }
}
