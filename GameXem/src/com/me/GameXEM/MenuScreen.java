package com.me.GameXEM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MenuScreen implements Screen {
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Vector3 touch;
	public GameScreen game_screen;
	public GameXEM game;
	
	public MenuScreen(GameXEM gameXEM) {
		game = gameXEM;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();
		touch = new Vector3();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0F, 0F, 0F, 1F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		generalUpdate();
		batch.begin();
			batch.draw(MenuAssets.back, 0, 0);
			batch.draw(MenuAssets.play, 760, 550);
		batch.end();
	}
	
	private void generalUpdate() {
		if(Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			if(touch.x > 760 && touch.x < 1160){
				if(touch.y > 550 && touch.y < 750){
					game.setPlay();
				}
			}
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

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
