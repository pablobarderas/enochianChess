package model;

import com.badlogic.gdx.graphics.Texture;

public class Board {

    private Texture img;
    private int width, height;

    public Board(Texture img, int width, int height) {
        this.img = img;
        this.width = width;
        this.height = height;
    }

    public Board(){

    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
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
