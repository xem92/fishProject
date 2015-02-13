package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	public Vector2 velocity = new Vector2();
	public int posX;
	public int posY;
	public static int speed = 1;
	public static int gravity = 1;
	public static Texture sheet;
	public static Texture sheet2;
	public static TextureRegion[] sheet_frames;
	public static TextureRegion current_frame;
	public static Animation fish;
	public int lives;
	
	public Bullet(int x, int y){
		posX =  x;
		posY = y;
	}
	
	public void update(Fish fish, int i) {
		if(posX < 1920){
			posX += 10;
		}else{
			fish.fire[i] = false;
		}
	}

	public static void load(){
		/*sheet = new Texture(Gdx.files.internal("fish.png"));
		sheet2 = new Texture(Gdx.files.internal("fish2.png"));
		sheet_frames = new TextureRegion[2];
		sheet_frames[0] = TextureRegion.split(sheet, 640, 640)[0][0];
		sheet_frames[1] = TextureRegion.split(sheet2, 640, 640)[0][0];
		sheet_frames[0].flip(false, true);
		sheet_frames[1].flip(false, true);
		fish = new Animation(0.5F, sheet_frames);*/
		sheet = new Texture(Gdx.files.internal("bala.png"));
	}
}
