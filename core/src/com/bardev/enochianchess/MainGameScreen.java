package com.bardev.enochianchess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bardev.enochianchess.models.Board;
import com.bardev.enochianchess.models.Pieces;

public class MainGameScreen extends BaseScreen{
    private Stage stage;
    private Pieces pieces;

    private Texture piecesTexture;
    private Board board;
    private  Texture[][] boardTexture;

    public MainGameScreen(MainGame game){
        super(game);
        piecesTexture = new Texture("pawn-white.png");

        // Fill boardTexture
        boardTexture = new Texture[8][8];
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

    }

    @Override
    public void show() {
        stage = new Stage();
        pieces = new Pieces(piecesTexture);
        board = new Board(80,80,8);
        stage.addActor(pieces);
        stage.addActor(board);

        pieces.setPosition(10,100);
        board.setPosition(20,100);
    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        // Clear buffer and set color
        ScreenUtils.clear(Color.WHITE);
        stage.draw();
    }

    @Override
    public void dispose() {
        piecesTexture.dispose();
        board.disposeBoard();
    }
}
