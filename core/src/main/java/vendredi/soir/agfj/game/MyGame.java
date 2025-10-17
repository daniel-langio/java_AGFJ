package vendredi.soir.agfj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import java.util.List;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.entity.TexturedEntity;
import vendredi.soir.agfj.graphics.sprites.AnimationCategory;
import vendredi.soir.agfj.graphics.sprites.SpriteAnimation;
import vendredi.soir.agfj.graphics.sprites.SpriteLoader;

public class MyGame extends Game {
  private static final TexturedEntity player =
      new TexturedEntity(
          "32x32",
          new Texture(Gdx.files.internal("sprites/prototypes/platforms/Tiles/Tile_10.png")));
  private static final AnimatedEntity animatedPlayer =
      new AnimatedEntity(
          "Animated",
          List.of(
              new SpriteAnimation(
                  0,
                  30,
                  AnimationCategory.IDLE,
                  SpriteLoader.loadSpriteSet(
                      "sprites/prototypes/character/Animations/Walking.png", 128, 128, 0, 0, 12)),
            new SpriteAnimation(
              0,
              5,
              AnimationCategory.JUMP,
              SpriteLoader.loadSpriteSet(
                "sprites/prototypes/character/Animations/Jumping.png", 128, 128, 0, 0, 10))));

  public MyGame() {
    super();
  }

  @Override
  public void init() {
    world.addEntity(player);
    world.addEntity(animatedPlayer);
  }

  @Override
  public void logic() {
    super.logic();
    player.setX(player.getX() + 0.5f);
    animatedPlayer.setX(animatedPlayer.getX() + 0.2f);
    if (upTime > 5) {
      animatedPlayer.play(AnimationCategory.JUMP);
    }
  }
}
