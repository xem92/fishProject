package com.me.GameXEM;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Shark {
	public Vector2 velocity = new Vector2();
	public int posX = 200;
	public int posY = 200;
	public static int speed = 10;
	public static int gravity = 1;
	public static Texture sheet;
	public static Texture sheet2;
	public static TextureRegion[] sheet_frames;
	public static TextureRegion current_frame;
	public static Animation fish;
	public Random rand = new Random();
	public boolean kill;
	
	public Shark(){
		posX = 2000;
		posY = rand.nextInt((80) + 1)*10;
		kill = false;
	}
	
	public void respawn(){
		posX = 2000;
		posY = rand.nextInt(75)*10;
		kill = false;
	}
	
	public void update(float deltaTime, Vector3 touch, OrthographicCamera camera) {
		if(posX < -500){
			posX = 2000;
			posY = rand.nextInt(75)*10;
			kill = false;
		}
		posX -= speed;
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
		sheet = new Texture(Gdx.files.internal("tiburon.png"));
	}
}
