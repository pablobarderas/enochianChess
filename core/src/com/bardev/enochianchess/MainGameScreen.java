package com.bardev.enochianchess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.bardev.enochianchess.models.Board;
import com.bardev.enochianchess.models.Pieces;

public class MainGameScreen extends BaseScreen{
    private Stage stage;
    private Pieces pieces;

    private Texture piecesTexture;
    private Board board;
    private  Texture[][] boardTexture;

    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();


    public MainGameScreen(MainGame game){
        super(game);
        piecesTexture = new Texture("pawn-white.png");

        // Fill boardTexture
        boardTexture = new Texture[8][8];


    }

    @Override
    public void show() {

        float cellSize = Math.min(screenWidth, screenHeight) / 8.30f;
        float boardSize = cellSize * 8;
        float boardX = (screenWidth - boardSize) / 2f;
        float boardY = (screenHeight - boardSize) / 2f;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        board = new Board(boardTexture, cellSize, 8);
        pieces = new Pieces(piecesTexture);

        board.setPosition(boardX, boardY);

        pieces.setWidth(100f);
        pieces.setHeight(100f);

        // TODO TAMAñO Y POSICIONES DE PEONES
        pieces.setPosition(boardX + 14, boardY + cellSize + 18);

        stage.addActor(board);
        stage.addActor(pieces);

        board.fillBoard();
    }


    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        // Clear buffer and set color
        ScreenUtils.clear(Color.DARK_GRAY);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        piecesTexture.dispose();
        board.disposeBoard();
    }
}
