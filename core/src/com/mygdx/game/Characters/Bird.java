package com.mygdx.game.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

import java.util.Random;

public class Bird {
    Texture texture;

    int x;
    int y;
    int speed;
    boolean jump;
    int jumpHeight = 50;
    Texture[] framesArray;
    int frameCounter;
    final int width = 150;
    final  int  height = 100;

    public Bird(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        framesArray = new Texture[]{
                new Texture("birdTiles/bird0.png"),
                new Texture("birdTiles/bird1.png"),
                new Texture("birdTiles/bird2.png")


        };
        texture = framesArray[0];
        frameCounter = 0;
    }

    public void OnClick() {
        jump = true;
        jumpHeight = y + 200;
    }
    public boolean isInField() {
        return  (y + height > 0 && y < MyGdxGame.SCR_HEIGHT);
    }

    public void fly() {
        if (y >= jumpHeight) {
            jump = false;
        }

        if (jump) {
            y += speed;
        } else {
            y -= 0.8 * speed;
        }
        frameCounter++;
        texture =framesArray [frameCounter / 10 % 3];
    }
    public void draw(SpriteBatch batch) {
        batch.draw(framesArray[frameCounter++ / 10 % 3], x, y, 250, 200);
        fly();

    }
    public void setY(int y) {
        this. y = y;
    }

    public void dispose() {
        texture.dispose();}
}
