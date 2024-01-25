package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Board extends Actor {

    private Texture[][] boardTextures;
    private int cellWidth, cellHeight, size;

    public Board(int cellWidth, int cellHeight, int size){
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.size = size;

        fillBoard();
    }

    public void fillBoard() {

        // Board Textures
        Texture[][] boardTexture = new Texture[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // (Column ODD and row EVEN) OR (column EVEN and row ODD)
                boolean red = col%2==0 && row%2!=0 || col%2!=0 && row%2==0;
                if(red){ // RED
                    boardTexture[row][col] = new Texture("red.png");
                } else  {// BLACK
                    boardTexture[row][col] = new Texture("black.png");
                }
            }
        }
        this.boardTextures = boardTexture;
    }

    public Texture[][] getBoardTextures() {
        return boardTextures;
    }

    public int getCellWidth() {
        return this.cellWidth;
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {

        // BoardTextures draw
        int cellSize = 58;
        int boardSize = 8;
        for (int i = 0; i < boardSize; i++) {
            int y = cellSize * i;
            for (int j = 0; j < boardSize; j++) {
                int x = cellSize * j;
                batch.draw(this.getBoardTextures()[i][j], x, y, this.getCellWidth(), this.getHeight());
            }
        }
    }

    // Dispose method to clean resources
    public void disposeBoard(){
        // BoardTextures dispose
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.getBoardTextures()[i][j].dispose();
            }
        }
    }
}
