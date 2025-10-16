package vendredi.soir.agfj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import vendredi.soir.agfj.entity.TexturedEntity;

public class MyGame extends Game{

  public MyGame() {
    super();
  }

  @Override
  public void init() {
    world.addEntity(new TexturedEntity("32x32", new Texture( Gdx.files.internal("sprites/prototypes/platforms/Tiles/Tile_10.png"))));
  }
}
