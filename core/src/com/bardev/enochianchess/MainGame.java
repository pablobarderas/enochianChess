package com.bardev.enochianchess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import model.Board;

public class MainGame extends ApplicationAdapter {
	private SpriteBatch batch;

	private Board board;

	private int width, height;


	// Upload files here
	@Override
	public void create () {
		batch = new SpriteBatch();

		// Width x Height
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		System.out.println("My screen: " + width + "x" + height );

		// Create board
		Texture img = new Texture("tablero-naranja-notacion.png");
		board = new Board(img, width-10, height-10);

	}

	// Used to clear resources
	@Override
	public void dispose () {
		batch.dispose();
		board.getImg().dispose();
	}

	// Update game state, render files ...
	@Override
	public void render () {
		// Clear buffer
		ScreenUtils.clear(Color.WHITE);

		// Begin draw
		batch.begin();
		batch.draw(board.getImg(), 0, 0, board.getWidth(), board.getHeight());
		batch.end();

	}


}
