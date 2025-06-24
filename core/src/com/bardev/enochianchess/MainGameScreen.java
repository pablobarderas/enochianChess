package com.bardev.enochianchess;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.bardev.enochianchess.models.Board;
import com.bardev.enochianchess.models.Pawn;

public class MainGameScreen extends BaseScreen{
    private Stage stage;
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
//        piecesTexture = new Texture("pawn-white.jpg");
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
        board.setPosition(boardX, boardY);
        stage.addActor(board);

        // Añadir algunos peones de prueba
        for (int col = 0; col < BOARD_SIZE; col++) {
            Pawn whitePawn = new Pawn("white", 6, col);
            whitePawn.setPosition(boardX + col * cellSize, boardY + 6 * cellSize);
            whitePawn.setSize(cellSize, cellSize);
            stage.addActor(whitePawn);

//            Pawn blackPawn = new Pawn("black", 1, col);
//            blackPawn.setPosition(boardX + col * cellSize, boardY + 1 * cellSize);
//            blackPawn.setSize(cellSize, cellSize);
//            stage.addActor(blackPawn);
        }
    }

    // ESTE METODO LO QUE HACE ES REAJUSTAR TODOS LOS TAMANYOS COMO DEBEN, POR ESTO SE NECESITA LA POSICION Y EL TAMANYO DE LOS ACTORES DEL STAGE
    @Override
    public void resize(int width, int height) {
        calculateBoardDimensions();
        stage.getViewport().update(width, height, true);
        board.setPosition(boardX, boardY);

        // TODO ACTUALIZAR POSICIONES DE PIEZAS SI ES NECESARIO
        for (Actor actor : stage.getActors()) {
            if (actor instanceof Pawn) {
                Pawn pawn = (Pawn) actor;
                pawn.setPosition(boardX + pawn.getCol() * cellSize, boardY + pawn.getRow() * cellSize);
                pawn.setSize(cellSize, cellSize);
            }
        }
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
        board.disposeBoard();
        for (Actor actor : stage.getActors()) {
            if (actor instanceof Pawn) {
                ((Pawn) actor).dispose();
            }
        }
    }
}
