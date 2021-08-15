package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Texture background;
    private Vector2 pos;
    private Vector2 v;

    private float fin_x, fin_y, len;
    private Vector2 fin_pos;
    private Vector2 sub_pos;

    @Override
    public void show() {
        super.show();
        background = new Texture("fon.jpg");
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        fin_pos = new Vector2();
        sub_pos = new Vector2();
        pos.set(0,0);
        v = new Vector2(0,0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if(len!=0) {
            pos.add(sub_pos);
            fin_pos.set(fin_x,fin_y);
            sub_pos.set(fin_pos.sub(pos));
            len=sub_pos.len();
            sub_pos.nor();
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        fin_x = screenX;
        fin_y = Gdx.graphics.getHeight()-screenY;
        fin_pos.set(screenX,Gdx.graphics.getHeight()-screenY);
        sub_pos.set(fin_pos.sub(pos));
        len=sub_pos.len();
        sub_pos.nor();
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }
}
