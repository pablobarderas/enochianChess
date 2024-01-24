package model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;

public class Board {

    private Texture[][] boardTextures;
    private int width, height;

    public Board(Texture[][] boardTextures, int width, int height) {
        this.boardTextures = boardTextures;
        this.width = width;
        this.height = height;
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
}
