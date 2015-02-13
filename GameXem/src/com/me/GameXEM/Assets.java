package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture sheetH1;
	public static Texture sheetH2;
	public static TextureRegion[] sheet_frames;
	public static TextureRegion current_frame;
	public static Animation home;
	
	public static void load(){		
		sheetH1 = new Texture(Gdx.files.internal(".png"));
		sheetH2 = new Texture(Gdx.files.internal(".png"));
		sheet_frames = new TextureRegion[2];
		sheet_frames[0] = TextureRegion.split(sheetH1, 480, 480)[0][0];
		sheet_frames[1] = TextureRegion.split(sheetH2, 480, 480)[0][0];
		sheet_frames[0].flip(false, true);
		sheet_frames[1].flip(false, true);
		home = new Animation(0.5F, sheet_frames);
	}
}
