package vendredi.soir.agfj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import vendredi.soir.agfj.graphics.sprites.SpriteManager;

public class MyGame {
    private final int WORLD_WIDTH = 200;
    private final int WORLD_HEIGHT = 200;

    private float runTime = 0;

    private final SpriteBatch spriteBatch;
    private final Viewport viewport;
    private final SpriteManager spriteManager;
    private final GameWorld world;

    public MyGame() {
        this.spriteBatch = new SpriteBatch();
        this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        this.spriteManager = new SpriteManager(spriteBatch);

        this.world = new GameWorld();
        init();
    }

    public void init() {
        // create entities and do settings here
    }

    public void input() {}

    public void logic() {
        final float deltaTime = Gdx.graphics.getDeltaTime();
        runTime += deltaTime;

    }

    public void draw() {
        ScreenUtils.clear(Color.valueOf("069f66"));
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        world.draw(spriteBatch);

        spriteBatch.end();
    }

    public void dispose() {
        spriteManager.disposeSprites(world.getSprites());
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
