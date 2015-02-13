package com.me.GameXEM;

import com.badlogic.gdx.Game;

public class GameXEM extends Game {
	
	public MenuScreen menu;
	public GameScreen game_screen;
	public GameOver game_over_sceen;
	
	@Override
	public void create() {
		Fish.load();
		Shark.load();
		Background.load();
		Heart.load();
		Bullet.load();
		MenuAssets.load();
		menu = new MenuScreen(this);
		setScreen(menu);
	}

	public void setPlay() {
		game_screen = new GameScreen(this);
		setScreen(game_screen);
	}
	
	public void gameOver(int points){
		game_over_sceen = new GameOver(this, points);
		setScreen(game_over_sceen);
	}
}
