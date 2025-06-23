package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Pieces extends Group {

    private Texture pieces;

    public Pieces(Texture pieces){
        this.pieces = pieces;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(pieces, getX(), getY(), getWidth(),getHeight() );
    }

}
