package com.me.GameXEM;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Project Fish";
		cfg.useGL20 = true;
		cfg.width = 720;
		cfg.height = 360;
		
		new LwjglApplication(new GameXEM(), cfg);
	}
}
