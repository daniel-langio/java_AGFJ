package vendredi.soir.agfj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import vendredi.soir.agfj.graphics.sprites.SpriteManager;

public abstract class Game {
  protected final int WORLD_WIDTH = 200;
  protected final int WORLD_HEIGHT = 200;

  protected final SpriteBatch spriteBatch;
  protected final Viewport viewport;
  protected final SpriteManager spriteManager;
  protected final GameWorld world;

  public Game() {
    this.spriteBatch = new SpriteBatch();
    this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
    this.spriteManager = new SpriteManager(spriteBatch);

    this.world = new GameWorld();
    init();
  }

  // create entities and do settings here
  public abstract void init();

  public void input() {}

  public void logic() {
    final float deltaTime = Gdx.graphics.getDeltaTime();

    world.animate(deltaTime);
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
