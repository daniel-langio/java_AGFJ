package vendredi.soir.agfj.entity;

import static vendredi.soir.agfj.graphics.sprites.AnimationCategory.IDLE;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import vendredi.soir.agfj.graphics.sprites.AnimationCategory;
import vendredi.soir.agfj.graphics.sprites.SpriteAnimation;

@Getter
public class AnimatedEntity extends TexturedEntity {
  private static final List<AnimationCategory> REQUIRED_ANIMATION_CATEGORIES = List.of(IDLE);
  private static final AnimationCategory DEFAULT_ANIMATION_CATEGORY = IDLE;
  @Setter private AnimationCategory currentAnimationCategory = DEFAULT_ANIMATION_CATEGORY;
  @Setter private boolean loopAnimation = true;
  private List<SpriteAnimation> animations;

  public AnimatedEntity(String name, List<SpriteAnimation> animations) {
    super(name, null);
    setAnimations(animations);
    initTexture(getDefaultTexture());
  }

  @Override
  public void draw(Batch batch) {
    batch.draw(getCurrentAnimation().getCurrentFrame(), getX(), getY(), getWidth(), getHeight());
  }

  public void animate(float deltaTime) {
    getCurrentAnimation().animate(deltaTime);
  }

  public Texture getDefaultTexture() {
    return getDefaultAnimation().getCurrentFrame().getTexture();
  }

  public SpriteAnimation getCurrentAnimation() {
    SpriteAnimation currentAnimation =
        animations.stream()
            .filter(a -> a.getCategory().equals(currentAnimationCategory))
            .findFirst()
            .orElse(null);

    if (currentAnimation == null) {
      throw new IllegalArgumentException(
          String.format("Animation category %s not found", currentAnimationCategory));
    }

    return currentAnimation;
  }

  public SpriteAnimation getDefaultAnimation() {
    SpriteAnimation defaultAnimation =
        animations.stream()
            .filter(a -> a.getCategory().equals(DEFAULT_ANIMATION_CATEGORY))
            .findFirst()
            .orElse(null);

    if (defaultAnimation == null) {
      throw new IllegalArgumentException("No default animation provided for this entity");
    }

    return defaultAnimation;
  }

  public void setAnimations(List<SpriteAnimation> animations) {
    if (animations.stream()
        .noneMatch(a -> REQUIRED_ANIMATION_CATEGORIES.contains(a.getCategory()))) {
      throw new IllegalArgumentException(
          String.format(
              "This entity requires an animation for : %s", REQUIRED_ANIMATION_CATEGORIES));
    }
    this.animations = animations;
  }
}
