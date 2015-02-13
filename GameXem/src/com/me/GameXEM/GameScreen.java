package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen{
	
	private GameXEM game;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private float stateTime;
	private Fish fish;
	private Shark shark[];
	private Vector3 touch;
	private Heart heart;
	private int score;
	private String scoreName;
	private BitmapFont bitmapFontName;
	
	public GameScreen(GameXEM gameXEM){
		this.game = gameXEM;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();
		stateTime = 0F;
		touch = new Vector3();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0F, 0F, 0F, 1F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		stateTime += Gdx.graphics.getDeltaTime();
		fish.update2(stateTime, camera);
		shark[0].update(stateTime, touch, camera);
		shark[1].update(stateTime, touch, camera);
		generalUpdate();
		generalUpdate2();
		bulletUpdate();
		bulletUpdate2();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			batch.draw(Background.sheet, 0, 0);
			batch.draw(Shark.sheet, shark[0].posX, shark[0].posY);
			batch.draw(Shark.sheet, shark[1].posX, shark[1].posY);
			fish.drawFish(batch);
			heart.drawHeart(batch, fish.lives);
			bitmapFontName.draw(batch, scoreName, 20, 1020);
		batch.end();
	}
	
	private void bulletUpdate() {
		for(int i = 0; i < fish.MAXBULL; i++){
			if(fish.fire[i]){
				if(fish.bullet[i].posX+50 > shark[0].posX+10 && fish.bullet[i].posY > shark[0].posY &&
						fish.bullet[i].posY < shark[0].posY+200){
					score += 50;
					scoreName = "score: " + score;
					fish.fire[i] = false;
					shark[0].respawn();
				}
			}
		}
	}
	
	private void bulletUpdate2() {
		for(int i = 0; i < fish.MAXBULL; i++){
			if(fish.fire[i]){
				if(fish.bullet[i].posX+50 > shark[1].posX+10 && fish.bullet[i].posY > shark[1].posY &&
						fish.bullet[i].posY < shark[1].posY+200){
					score += 50;
					scoreName = "score: " + score;
					fish.fire[i] = false;
					shark[1].respawn();
				}
			}
		}
	}

	private void generalUpdate() {
		if(shark[0].posX > (fish.posX+100) && shark[0].posX < (fish.posX+300) ||
				(shark[0].posX+100) > (fish.posX+100) && (shark[0].posX+100) < (fish.posX+300)){
			if((shark[0].posY+75) > (fish.posY+50) && (shark[0].posY+75) < (fish.posY+150) || 
					(shark[0].posY+125) > (fish.posY+50) && (shark[0].posY+125) < (fish.posY+150)){
				if(!shark[0].kill){
					shark[0].kill = true;
					fish.lives--;
					scoreName = "score: " + score;
					if(fish.lives == 0){
						game.gameOver(score);
					}
				}
			}
		}
	}
	
	private void generalUpdate2() {
		if(shark[1].posX > (fish.posX+100) && shark[1].posX < (fish.posX+300) ||
				(shark[1].posX+100) > (fish.posX+100) && (shark[1].posX+100) < (fish.posX+300)){
			if((shark[1].posY+75) > (fish.posY+50) && (shark[1].posY+75) < (fish.posY+150) || 
					(shark[1].posY+125) > (fish.posY+50) && (shark[1].posY+125) < (fish.posY+150)){
				if(!shark[1].kill){
					shark[1].kill = true;
					fish.lives--;
					scoreName = "score: " + score;
					if(fish.lives == 0){
						game.gameOver(score);
					}
				}
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		fish = new Fish();
		shark = new Shark[5];
		shark[0] = new Shark();
		shark[1] = new Shark();
		heart = new Heart();
		score = 0;
		scoreName = "score: " + score;
	    bitmapFontName = new BitmapFont();
		bitmapFontName.setColor(Color.BLACK);
		bitmapFontName.setScale(5);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
