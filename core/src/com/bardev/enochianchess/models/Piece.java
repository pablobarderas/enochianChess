package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Piece extends Actor {
    protected Texture texture;
    protected String colorSide; // "white" o "black"
    protected int row; // Fila en el tablero (0-7)
    protected int col; // Columna en el tablero (0-7)

    public Piece(Texture texture, String color, int row, int col) {
        this.texture = texture;
        this.colorSide = colorSide;
        this.row = row;
        this.col = col;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public String getColorSide() {
        return colorSide;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setBoardPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void dispose() {
        texture.dispose();
    }

    // Método abstracto para futura lógica de movimiento
    public abstract boolean isValidMove(int toRow, int toCol, Piece[][] board);
}