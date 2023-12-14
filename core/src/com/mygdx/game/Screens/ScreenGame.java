package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.components.Background;
import com.mygdx.game.Characters.Bird;
import com.mygdx.game.Characters.Tube;
import com.mygdx.game.components.Counter;
import com.mygdx.game.MyGdxGame;

public class ScreenGame implements Screen {
    MyGdxGame myGdxGame;
    Bird bird;
    Tube[] tubes;
    int numberOfTubes = 3;
    boolean isGameOver;
    int i;
    int points;
    Counter counter;
    Background background;


    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        bird = new Bird(0, 0, 5);
        initTubes();
        counter = new Counter(MyGdxGame.SCR_WIDTH - 400, MyGdxGame.SCR_HEIGHT - 60);
        background = new Background();
        isGameOver = false;
    }

    public void initTubes() {
        tubes = new Tube[numberOfTubes];
        for (int i = 0; i < numberOfTubes; i++) {
            tubes[i] = new Tube(numberOfTubes, i);
        }
    }


    @Override
    public void show() {
        isGameOver = false;
        points = 0;
        bird.setY(MyGdxGame.SCR_HEIGHT/2 );
        initTubes();
    }

    @Override
    public void render(float delta) {
       if (isGameOver )
           if (isGameOver) {            myGdxGame.restart.points = points;
               myGdxGame.setScreen(myGdxGame.restart);        }
        if (Gdx.input.justTouched()) {
            bird.OnClick();
        }
        background.move();
        bird.fly();
        if (!bird.isInField()) {
            System.out.println("Not in the field");
            isGameOver = true;
        }
        for (Tube tube : tubes) {
            tube.move();
            if (tube.isHeat(bird)) {
                System.out.println("Hit!");
                isGameOver = true;
            } else if (tube.isPast()) {
                points +=1;
                System.out.println(points);
            }
        }
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(239, 175, 140, 0);
        myGdxGame.batch.begin();
        background.draw(myGdxGame.batch);

        bird.draw(myGdxGame.batch);
        for (Tube tube : tubes) tube.draw(myGdxGame.batch);
        counter.draw(myGdxGame.batch,points);
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
        bird.dispose();
        counter.dispose();
        background.dispose();
    }
}
