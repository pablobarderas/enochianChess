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
		//batch = new SpriteBatch();

		// Main Screen
		Screen mainGameScreen = new MainGameScreen(this);
		this.setScreen(mainGameScreen);
//
//		// Width x Height Screen
//		widthScreen = Gdx.graphics.getWidth();
//		heightScreen = Gdx.graphics.getHeight();
//		System.out.println("My screen: " + widthScreen + "x" + heightScreen );
//
//		// Create board
//		board = new Board( 80, 80, 8);

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
