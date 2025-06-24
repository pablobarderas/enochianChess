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

    private float cellSize;
    private float boardX, boardY;

    private static final int BOARD_SIZE = 8;
    private static final float CELL_SCALE_FACTOR = 8.30f;

    public MainGameScreen(MainGame game){
        super(game);
        piecesTexture = new Texture("pawn-white.png");
        calculateBoardDimensions();
        board = new Board(cellSize, BOARD_SIZE);
    }

    private void calculateBoardDimensions() {
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        cellSize = Math.min(screenWidth, screenHeight) / CELL_SCALE_FACTOR;
        float boardSize = cellSize * BOARD_SIZE;
        boardX = (screenWidth - boardSize) / 2f;
        boardY = (screenHeight - boardSize) / 2f;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        pieces = new Pieces(piecesTexture);

        board.setPosition(boardX, boardY);
        pieces.setPosition(boardX + 14, boardY + cellSize + 18);
        pieces.setWidth(100f);
        pieces.setHeight(100f);
        stage.addActor(board);
        stage.addActor(pieces);
    }

    @Override
    public void resize(int width, int height) {
        calculateBoardDimensions();
        stage.getViewport().update(width, height, true);
        board.setPosition(boardX, boardY);

        // TODO ACTUALIZAR POSICIONES DE PIEZAS SI ES NECESARIO
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
