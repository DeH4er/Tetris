package com.deli.tetris.game.impl;

import com.deli.tetris.game.Figure;

import java.util.List;
import java.util.Random;

/**
 * Created by denys on 07.05.17.
 */
public class FigureSet {
    private static List<Figure> figures;
    private static Random random = new Random();
    private static int FIGURES_COUNT = 7;

    public static Figure getRandomFigure() {
        int choice = random.nextInt() % (FIGURES_COUNT + 1) + 1;
        switch (choice) {
            case 1: return new Figure1();
            case 2: return new Figure2();
            case 3: return new Figure3();
            case 4: return new Figure4();
            case 5: return new Figure5();
            case 6: return new Figure6();
            case 7: return new Figure7();
            default: return new Figure1();
        }
    }
}
