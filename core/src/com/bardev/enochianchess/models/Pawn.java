package com.bardev.enochianchess.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Pawn extends Pieces{

    private Texture pawnTexture;
    public Pawn(Texture pawnTexture) {
        super(pawnTexture);
        this.pawnTexture = pawnTexture;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
