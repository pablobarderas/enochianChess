package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Board extends Actor {

    private Texture[][] boardTextures;
    private int boardSize;
    private float cellSize;
    private ShapeRenderer shapeRenderer;

    public Board(Texture[][] boardTextures, float cellSize, int boardSize) {
        this.cellSize = cellSize;
        this.boardSize = boardSize;
        this.boardTextures = boardTextures;
        shapeRenderer = new ShapeRenderer();
    }

    public void fillBoard() {
        Texture[][] boardTexture = new Texture[boardSize][boardSize];

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                boolean red = col % 2 == 0 && row % 2 != 0 || col % 2 != 0 && row % 2 == 0;
                boardTexture[row][col] = new Texture(red ? "red.jpg" : "black.jpg");
            }
        }

        this.boardTextures = boardTexture;
    }

    public Texture[][] getBoardTextures() {
        return boardTextures;
    }

    public float getCellSize() {
        return this.cellSize;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end(); // Se detiene para usar ShapeRenderer

        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GOLD);

        float borderSize = 10f;
        float totalSize = cellSize * boardSize;

        shapeRenderer.rect(
                getX() - borderSize,
                getY() - borderSize,
                totalSize + 2 * borderSize,
                totalSize + 2 * borderSize
        );

        shapeRenderer.end();

        batch.begin(); // Volvemos a dibujar con Batch

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                float x = getX() + col * cellSize;
                float y = getY() + row * cellSize;
                batch.draw(boardTextures[row][col], x, y, cellSize, cellSize);
            }
        }
    }



    public void disposeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardTextures[i][j].dispose();
            }
        }
        shapeRenderer.dispose();
    }
}
