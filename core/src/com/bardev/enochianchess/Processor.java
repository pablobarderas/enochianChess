package com.bardev.enochianchess;

import com.badlogic.gdx.InputAdapter;

public class Processor extends InputAdapter {

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("You has been touched on " + screenX + "x" + screenY + " position");
        System.out.println("You has been used the " + pointer + " finger and the " + button + "button");
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
}
