package vendredi.soir.agfj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import vendredi.soir.agfj.system.CollisionSystem;
import vendredi.soir.agfj.system.ControlSystem;

public abstract class Game {
  public static final int WORLD_WIDTH = 200;
  public static final int WORLD_HEIGHT = 200;

  protected final SpriteBatch spriteBatch;
  protected final Viewport viewport;
  protected final GameWorld world;
  protected final ControlSystem controlSystem;
  protected final CollisionSystem collisionSystem;

  protected double upTime = 0.0;

  public Game() {
    this.spriteBatch = new SpriteBatch();
    this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
    this.controlSystem = new ControlSystem();
    this.collisionSystem = new CollisionSystem();

    this.world = new GameWorld();
    init();
  }

  // create entities and do settings here
  public abstract void init();

  public void input() {
    controlSystem.update(world, viewport);
  }

  public void logic() {
    final float deltaTime = Gdx.graphics.getDeltaTime();

    upTime += deltaTime;
    world.animate(deltaTime);
    collisionSystem.resolve(world);
  }

  public void draw() {
    ScreenUtils.clear(Color.valueOf("069f66"));
    spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
    spriteBatch.begin();

    world.draw(spriteBatch);

    spriteBatch.end();
  }

  public void dispose() {
    world.dispose();
  }

  public void resize(int width, int height) {
    viewport.update(width, height, true);
  }
}
