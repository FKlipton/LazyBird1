package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Button {
    BitmapFont font;

    String text;
    Texture texture;

    int x, y;
    int textX, textY;
    int buttonWidth, buttonHeight;
    int textWidth, textHeight;

    public Button(int x, int y, String text) {
        this.text = text;
        this.x = x;
        this.y = y;

        font = new BitmapFont();
        font.getData().scale(5f);
        font.setColor(Color.WHITE);

        GlyphLayout gl = new GlyphLayout(font, text);
        textWidth = (int) gl.width;
        textHeight = (int) gl.height;

        texture = new Texture("button_bg.png");
        buttonWidth = texture.getWidth();
        buttonHeight = texture.getHeight();

        textX = x + (buttonWidth - textWidth) / 2;
        textY = y + (buttonHeight + textHeight) / 2;
    }
    public void draw(Batch batch) {
        batch.draw(texture, x, y, buttonWidth, buttonHeight);
        font.draw(batch, text, textX, textY);
    }
    public boolean isHeat(int bX, int bY) {
        return (bX >= x && bX <= x + buttonWidth && bY >= y && bY<=y + buttonHeight);

    }

    public void dispose() {
        texture.dispose();
        font.dispose();
    }


    }

