package ru.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private int x = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("fon.jpg");

		Vector2 v1 = new Vector2(3,3);
		Vector2 v2 = new Vector2();
		v2.set(2,1);
		v1.add(v2);

		v1.set(7,7);
		v2.set(3,1);
		v1.sub(v2);
		System.out.println(v1.len());
		v1.scl(0.5f);
		v1.nor();
		v2.cpy().add(v1);

		v1.set(1,1);
		v2.set(-1,1);
		v1.nor();
		v2.nor();
		System.out.println(Math.acos(v1.dot(v2)));
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
