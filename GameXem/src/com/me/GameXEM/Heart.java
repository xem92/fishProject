package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Heart {
	
	public static Texture sheet;
	
	public static void load(){
		sheet = new Texture(Gdx.files.internal("heart.png"));
	}
	
	public void drawHeart(SpriteBatch batch, int lives) {
		if(lives == 3){
			batch.draw(sheet, 1800, 960);
			batch.draw(sheet, 1700, 960);
			batch.draw(sheet, 1600, 960);
		}
		if(lives == 2){
			batch.draw(sheet, 1800, 960);
			batch.draw(sheet, 1700, 960);
		}
		if(lives == 1){
			batch.draw(sheet, 1800, 960);
		}
	}
}
