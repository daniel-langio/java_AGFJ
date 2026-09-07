package vendredi.soir.agfj.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.entity.TexturedEntity;
import vendredi.soir.agfj.graphics.sprites.SpriteLoader;

@Getter
@RequiredArgsConstructor
public class GameWorld {
  private List<TexturedEntity> entities = new ArrayList<>();

  public void addEntity(TexturedEntity entity) {
    entities.add(entity);
  }

  public void animate(float deltaTime) {
    List<AnimatedEntity> animatedEntities =
        entities.stream()
            .filter(entity -> entity instanceof AnimatedEntity)
            .map(entity -> (AnimatedEntity) entity)
            .toList();

    animatedEntities.forEach(animatedEntity -> animatedEntity.animate(deltaTime));
  }

  public void dispose() {
    Set<Texture> texturesToDispose = new HashSet<>();

    entities.stream()
        .filter(entity -> entity instanceof AnimatedEntity)
        .map(entity -> (AnimatedEntity) entity)
        .flatMap(animatedEntity -> animatedEntity.getAnimations().stream())
        .flatMap(animation -> animation.getFrames().stream())
        .map(TextureRegion::getTexture)
        .forEach(texturesToDispose::add);

    entities.stream()
        .filter(entity -> !(entity instanceof AnimatedEntity))
        .map(TexturedEntity::getTexture)
        .forEach(texturesToDispose::add);

    texturesToDispose.forEach(Texture::dispose);
    SpriteLoader.clearCache();
  }

  public void draw(SpriteBatch batch) {
    entities.forEach(entity -> entity.draw(batch));
  }
}
