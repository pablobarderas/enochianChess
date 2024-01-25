package com.bardev.enochianchess;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class MainGameScreen extends BaseScreen{
    private Stage stage;

    public MainGameScreen(MainGame game){
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage();
    }

    @Override
    public void hide() {
        stage.dispose();
    }
}
