package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Texture;

public class Pawn extends Piece {
    public Pawn(String colorSide, int row, int col) {
        super(new Texture("pawn-" + colorSide + ".png"), colorSide, row, col);
    }

    @Override
    public boolean isValidMove(int toRow, int toCol, Piece[][] board) {
        // Implementación vacía por ahora, se añadirá en el siguiente paso
        return false;
    }
}