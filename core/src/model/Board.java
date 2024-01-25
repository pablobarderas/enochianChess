package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board {

    private Texture[][] boardTextures;
    private int width, height, size;

    public Board(Texture[][] boardTextures, int width, int height, int size) {
        this.boardTextures = boardTextures;
        this.width = width;
        this.height = height;
        this.size = size;
    }

    public Board(){

    }

    public Texture[][] getBoardTextures() {
        return boardTextures;
    }

    public void setBoardTextures(Texture[][] boardTextures) {
        this.boardTextures = boardTextures;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void drawBoard(SpriteBatch batch){
        // BoardTextures draw
        int cellSize = 58;
        int boardSize = this.getBoardTextures().length;
        for (int i = 0; i < boardSize; i++) {
            int y = cellSize * i;
            for (int j = 0; j < boardSize; j++) {
                int x = cellSize * j;
                batch.draw(this.getBoardTextures()[i][j], x, y, this.getWidth(), this.getHeight());
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
