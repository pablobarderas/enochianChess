package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Pieces extends Actor {

    private Texture pieces;

    public Pieces(Texture pieces){
        this.pieces = pieces;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(pieces, 2,2);
    }
}
