package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MenuAssets {

	public static Texture back;
	public static Texture play;
	
	public static void load(){
		back = new Texture(Gdx.files.internal("fondo.png"));
		play = new Texture(Gdx.files.internal("play.png"));
	}
}
