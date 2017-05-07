package com.deli.tetris.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by denys on 07.05.17.
 */
public class ScreenManager {

    Stack<AbstractScreen> screens;

    public ScreenManager() {
        screens = new Stack<AbstractScreen>();
    }

    public void push(AbstractScreen screen) {
        screens.push(screen);
    }

    public AbstractScreen pop() {
        return screens.pop();
    }

    public void resize(int width, int height) {
        screens.peek().resize(width, height);
    }

    public void update() {
        screens.peek().update();
    }


    public void render(SpriteBatch batch) {
        screens.peek().render();
    }

}
