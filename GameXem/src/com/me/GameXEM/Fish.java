package com.me.GameXEM;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Fish{
	
	public int MAXBULL = 30;
	public Vector2 velocity = new Vector2();
	public int posX;
	public int posY;
	public static int speed = 2;
	public static int gravity = 1;
	public static Texture sheet;
	public static Texture sheet2;
	public static TextureRegion[] sheet_frames;
	public static TextureRegion current_frame;
	public static Animation fish;
	public int lives;
	public Bullet bullet[];
	public Boolean[] fire;
	private int fireCount;
	public boolean touching;
	private Vector3 touch;
	private int id;
	
	public Fish(){
		posX = 200;
		posY = 200;
		lives = 3;
		fireCount = 0;
		fire = new Boolean[30];
		Arrays.fill(fire, Boolean.FALSE);
		bullet = new Bullet[30];
		touch = new Vector3();
		touching = false;
		id = 0;
	}
	
	public void update(float deltaTime, OrthographicCamera camera) {
		if(Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(touch.x > 960){
				if(touch.y > 540){
					velocity.y += 1;
					if(velocity.y > 10){
						velocity.y = 10;
					}
				}
				if(touch.y < 540){
					velocity.y -= 1;
					if(velocity.y < -10){
						velocity.y = -10;
					}
				}
				posY = (int) (posY + velocity.y);
			}
			if(touch.x < 960){
				if(!touching){
					if(fireCount < MAXBULL){
						bullet[fireCount] = new Bullet(posX+225, posY+50);
						fire[fireCount] = true;
						fireCount ++;
					}else{
						fireCount = 0;
						bullet[fireCount] = new Bullet(posX+225, posY+50);
						fireCount++;
					}
					touching = true;
				}
			}
		}
		if(posY > 800){
			posY = 800;
		}
		if(posY < 0){
			posY = 0;
		}
		for(int i = 0; i < MAXBULL; i++){
			if(fire[i]){
				bullet[i].update(this, i);
			}
		}
		touching = false;
	}

	public void update2(float deltaTime, OrthographicCamera camera){
		for(int i = 0; i < 2; i++){ // 20 is max number of touch points
			if(Gdx.input.isTouched(i)){
				touch.set(Gdx.input.getX(i), Gdx.input.getY(i), 0);
				camera.unproject(touch);
				if(touch.x > 960){
					if(touch.y > 540){
						velocity.y += 1;
						if(velocity.y > 10){
							velocity.y = 10;
						}
					}
					if(touch.y < 540){
						velocity.y -= 1;
						if(velocity.y < -10){
							velocity.y = -10;
						}
					}
					posY = (int) (posY + velocity.y);
				}
				if(touch.x < 960){
					id = i;
					if(!touching){
						if(fireCount < MAXBULL){
							bullet[fireCount] = new Bullet(posX+225, posY+50);
							fire[fireCount] = true;
							fireCount ++;
						}else{
							fireCount = 0;
							bullet[fireCount] = new Bullet(posX+225, posY+50);
							fireCount++;
						}
						touching = true;
					}
				}
			}else{
				if(id == i){
					id = 0;
					touching = false;
				}
			}
			if(posY > 800){
				posY = 800;
			}
			if(posY < 0){
				posY = 0;
			}
			for(int j = 0; j < MAXBULL; j++){
				if(fire[j]){
					bullet[j].update(this, j);
				}
			}
		}
	}
	
	public void drawFish(SpriteBatch batch){
		for(int i = 0; i < MAXBULL; i++){
			if(fire[i]){
				batch.draw(Bullet.sheet, bullet[i].posX, bullet[i].posY);
			}
		}
		batch.draw(Fish.sheet, posX, posY);
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
		sheet = new Texture(Gdx.files.internal("pez.png"));
	}
}
