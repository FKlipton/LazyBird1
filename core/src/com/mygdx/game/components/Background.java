package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.MyGdxGame;

public class Background {
    Texture textureBackground;

    int x1, x2;
    int speed = 3;
   public Background() {
        textureBackground = new  Texture("game_bg.png");
        x1 = 0;
        x2 = MyGdxGame.SCR_WIDTH;
    }
    public void  draw (Batch batch) {
        batch.draw(textureBackground, x1, 0, MyGdxGame.SCR_WIDTH + 2, MyGdxGame.SCR_HEIGHT);
        batch.draw(textureBackground, x2, 0, MyGdxGame.SCR_WIDTH + 2 , MyGdxGame.SCR_HEIGHT);
    }
    public void dispose(){
        textureBackground.dispose();
    }
    public void  move(){
        x1 -= speed;
       if  (x1 <= -MyGdxGame.SCR_WIDTH){
            x1 = MyGdxGame.SCR_WIDTH;

       }
       x2 -= speed;
       if (x2 <= -MyGdxGame.SCR_WIDTH){
           x2 = MyGdxGame.SCR_WIDTH;
       }
    }
}