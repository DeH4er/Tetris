package com.deli.tetris.screens;

import com.badlogic.gdx.Screen;

/**
 * Created by denys on 07.05.17.
 */
public abstract class AbstractScreen implements Screen{
    public abstract void update();

    public void render(float delta){
    }
    
    public abstract void render();
}
