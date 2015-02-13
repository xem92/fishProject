package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Background {
	public static Texture sheet;
	
	public static void load(){
		sheet = new Texture(Gdx.files.internal("fondo.png"));
	}
}
