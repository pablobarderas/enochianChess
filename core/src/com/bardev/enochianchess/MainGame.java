package com.bardev.enochianchess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import model.Board;

public class MainGame extends ApplicationAdapter {
	private SpriteBatch batch;

	private Board board;

	private int widthScreen, heightScreen;


	// Upload files here
	@Override
	public void create () {
		batch = new SpriteBatch();

		// Width x Height Screen
		widthScreen = Gdx.graphics.getWidth();
		heightScreen = Gdx.graphics.getHeight();
		System.out.println("My screen: " + widthScreen + "x" + heightScreen );

		// Create board
		board = new Board( 80, 80, 8);

	}

	// Used to clear resources
	@Override
	public void dispose () {
		batch.dispose();
		board.disposeBoard();

	}

	// Update game state, render files ...
	@Override
	public void render () {
		// Clear buffer
		ScreenUtils.clear(Color.WHITE);

		// Begin draw
		batch.begin();

		// Draw board
		board.drawBoard(batch);

		batch.end();

	}


}
