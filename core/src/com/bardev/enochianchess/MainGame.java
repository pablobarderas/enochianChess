package com.bardev.enochianchess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture board;

	private int width, height;


	// Upload files here
	@Override
	public void create () {
		batch = new SpriteBatch();
		board = new Texture("tablero-naranja-notacion.png");

		// Width x Height
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		System.out.println("My screen: " + width + "x" + height );
	}

	// Used to clear resources
	@Override
	public void dispose () {
		batch.dispose();
		board.dispose();
	}

	// Update game state, render files ...
	@Override
	public void render () {
		// Clear buffer
		ScreenUtils.clear(0, 0, 0, 1);

		// Begin draw
		batch.begin();
		batch.draw(board, 0, 0, 400, 400);
		batch.end();

	}


}
