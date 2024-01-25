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
		//Texture img = new Texture("tablero-naranja-notacion.png");
		//board = new Board(img, width-10, height-10);

		// Test board textures
		Texture[][] boardTextures = new Texture[8][8];
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				// (Column ODD and row EVEN) OR (column EVEN and row ODD)
				boolean red = col%2==0 && row%2!=0 || col%2!=0 && row%2==0;
				if(red){ // RED
				boardTextures[row][col] = new Texture("red.png");
				} else  {// BLACK
					boardTextures[row][col] = new Texture("black.png");
				}
			}
		}

		board = new Board(boardTextures, 80, 80);

	}

	// Used to clear resources
	@Override
	public void dispose () {
		batch.dispose();

		// BoardTextures dispose
		for (int i = 0; i < board.getBoardTextures().length; i++) {
			for (int j = 0; j < board.getBoardTextures()[0].length; j++) {
			board.getBoardTextures()[i][j].dispose();
			}
		}
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
