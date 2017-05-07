package com.deli.tetris.game.impl;

import com.badlogic.gdx.utils.Array;
import com.deli.tetris.game.Cell;
import com.deli.tetris.game.Figure;

import java.util.ArrayList;

/**
 * Created by denys on 07.05.17.
 */
public class Figure2 extends Figure {

    public Figure2() {
        //base 5, 20
        cells = new ArrayList<Cell>();
        cells.add(new Cell(5, 21));
        cells.add(new Cell(6, 21));
        cells.add(new Cell(6, 20));
        cells.add(new Cell(7, 20));

        maxSizeX = 3;
        maxSizeY = 2;
    }

    @Override
    public void rotate() {

    }
}
