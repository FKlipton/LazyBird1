package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.Button;
import com.mygdx.game.components.Counter;

public class Restart implements Screen {
    MyGdxGame myGdxGame;
    Texture restartBackground;
    Button button;
    int points;
    Counter counter;
    public Restart(MyGdxGame myGdxGame){
        this.myGdxGame = myGdxGame;
        restartBackground = new Texture("restart_bg.png");
        button = new Button(100, 400, "Restart");
        counter = new Counter(750,530);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            Vector3 touch = myGdxGame.camera.unproject(
                    new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)
            );
            if (button.isHeat((int) touch.x, (int) touch.y)) {
                myGdxGame.setScreen(myGdxGame.screenGame);
            }
        }
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(239, 175, 140, 0);
        myGdxGame.batch.begin();
        myGdxGame.batch.draw(restartBackground, 0, 0, MyGdxGame.SCR_WIDTH, MyGdxGame.SCR_HEIGHT);
        button.draw(myGdxGame.batch);
        counter.draw(myGdxGame.batch, points);
        myGdxGame.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
