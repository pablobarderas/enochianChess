package com.bardev.enochianchess;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.bardev.enochianchess.models.Board;

public class MainGame extends Game {
	private SpriteBatch batch;

	//private Board board;

	private int widthScreen, heightScreen;


	// Upload files here
	@Override
	public void create () {
		// Main Screen
		Screen mainGameScreen = new MainGameScreen(this);
		this.setScreen(mainGameScreen);

	}

	// Used to clear resources
//	@Override
//	public void dispose () {
//		batch.dispose();
////		board.disposeBoard();
//
//	}

	// Update game state, render files ...
//	@Override
//	public void render () {
//		// Clear buffer and set color
//		ScreenUtils.clear(Color.WHITE);
//
//		// Begin draw
//		batch.begin();
//
////		// Draw board
////		board.drawBoard(batch);
//
//		// End draw
//		batch.end();
//
//	}


}
