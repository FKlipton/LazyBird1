package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Counter {
    BitmapFont font;
    int x;
    int y;
    public Counter(int x, int y) {
       font = new BitmapFont();
       font.getData().scale(5F);
       font.setColor(Color.MAGENTA);
       this.x = x;
       this.y = y;
    }
    public void draw(Batch batch, int counter) {
        font.draw(batch,"count: " + counter, x, y);
    }
    public void dispose() {
        font.dispose();

    }



}
