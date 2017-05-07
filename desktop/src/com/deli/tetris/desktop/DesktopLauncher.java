package com.deli.tetris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.deli.tetris.Tetris;
import com.deli.tetris.utils.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Settings.WIDTH;
		config.height = Settings.HEIGHT;
		config.title = Settings.TITLE;
		new LwjglApplication(new Tetris(), config);
	}
}
