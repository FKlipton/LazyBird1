package com.mygdx.game.Characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.Characters.Bird;
import com.mygdx.game.MyGdxGame;

import java.util.Random;

public class Tube {
    Texture textureUpperTube;
    Texture textureDownTube;
    int gapY, gapHeight = 400, padding = 100;
    Random random;

    int distanceBetweenTubes;
    int width = 200;
    int height = 700;
    int x;
    int speed = 5;
    boolean isActive;


    public  Tube(int tubeCount, int tubeIndex) {
        textureUpperTube = new Texture("Tubes/tube.png");
        textureDownTube = new Texture("Tubes/tube_flipped.png");

        random = new Random();
        gapY = gapHeight / 2 + padding +
                random.nextInt(MyGdxGame.SCR_HEIGHT - 2 * (padding + gapHeight / 2));

        distanceBetweenTubes = (MyGdxGame.SCR_HEIGHT + width) / (tubeCount - 1);
        x = distanceBetweenTubes * tubeIndex + MyGdxGame.SCR_WIDTH;
    }

   public void draw(Batch batch) {
        batch.draw(textureDownTube, x, gapY + gapHeight / 2, width, height);
        batch.draw(textureUpperTube, x, gapY - gapHeight / 2 - height, width, height);
    }

    public void move() {
        x -= speed;
        if (x < -width) {
            x = MyGdxGame.SCR_HEIGHT + distanceBetweenTubes;
            gapY = gapHeight / 2 + padding +
                    random.nextInt(MyGdxGame.SCR_HEIGHT - 2 * (padding + gapHeight / 2));
            isActive = true;
        }
    }
    public boolean isHeat(Bird bird) {
        if (bird.y <= gapY - gapHeight / 2 &&
                bird.x + bird.width >= x && bird.x <= x) {
            return true;
        }
        if (bird.y + bird.height >= gapY + gapHeight / 2 &&
                bird.x + bird.width >= x && bird.x <= x) {
            return true;
        }
        return false;
    }
    public boolean isPast(){
        if (isActive) {
            isActive = false;
            return true;
        }
        return false;
    }

    public void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }
}