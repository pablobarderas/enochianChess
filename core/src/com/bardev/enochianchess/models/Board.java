package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Board extends Actor {

    private Texture[][] boardTextures;

    private Texture whiteTexture;
    private Texture blackTexture;
    private String currentTheme;
    private int boardSize;
    private float cellSize;

    private Texture borderTexture;

    public Board(float cellSize, int boardSize) {
        this.cellSize = cellSize;
        this.boardSize = boardSize;

        // TEXTURES
        this.currentTheme = "default";
        this.boardTextures = new Texture[boardSize][boardSize];
        this.blackTexture = new Texture("themes/" + currentTheme + "/black.jpg");
        this.whiteTexture = new Texture("themes/" + currentTheme + "/red.jpg");

        // TODO
//        this.borderTexture = new Texture("themes/" + currentTheme + "border.jpg");

        fillBoard();
    }

    // FILL BOARD WITH PRE-CREATED TEXTURES
    public void fillBoard() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                boolean white = col % 2 == 0 && row % 2 != 0 || col % 2 != 0 && row % 2 == 0;
                boardTextures[row][col] = white ? whiteTexture : blackTexture;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float borderSize = 10f;
        float totalSize = cellSize * boardSize;

        // TODO
        // Dibuja el borde
//        batch.draw(borderTexture, getX() - borderSize, getY() - borderSize,
//                totalSize + 2 * borderSize, totalSize + 2 * borderSize);

        // Dibuja casillas
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                float x = getX() + col * cellSize;
                float y = getY() + row * cellSize;
                batch.draw(boardTextures[row][col], x, y, cellSize, cellSize);
            }
        }

    }

    public Texture[][] getBoardTextures() {
        return boardTextures;
    }

    public float getCellSize() {
        return this.cellSize;
    }

    public void disposeBoard() {
        blackTexture.dispose();
        whiteTexture.dispose();
        borderTexture.dispose();
    }

    public void setTheme(String newTheme) {
        whiteTexture.dispose();
        blackTexture.dispose();
        borderTexture.dispose();
        this.currentTheme = newTheme;
        whiteTexture = new Texture("themes/" + newTheme + "/red.jpg");
        blackTexture = new Texture("themes/" + newTheme + "/black.jpg");
        borderTexture = new Texture("themes/" + newTheme + "/border.png");
        fillBoard();
    }

}
