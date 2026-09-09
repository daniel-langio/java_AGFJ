package vendredi.soir.agfj.system;

import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.List;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.entity.TexturedEntity;
import vendredi.soir.agfj.game.GameWorld;
import vendredi.soir.agfj.graphics.sprites.SpriteAnimation;

/**
 * Pairwise bounding-box collision among "solid" entities. O(n^2) - fine at demo scale, not meant
 * to scale to large entity counts.
 */
public final class CollisionSystem {
  private CollisionSystem() {}

  public static void resolve(GameWorld world) {
    List<AnimatedEntity> solidEntities = new ArrayList<>();
    for (TexturedEntity entity : world.getEntities()) {
      if (entity instanceof AnimatedEntity animatedEntity && animatedEntity.isSolid()) {
        solidEntities.add(animatedEntity);
      }
    }

    for (int i = 0; i < solidEntities.size(); i++) {
      for (int j = i + 1; j < solidEntities.size(); j++) {
        resolvePair(solidEntities.get(i), solidEntities.get(j));
      }
    }
  }

  private static void resolvePair(AnimatedEntity a, AnimatedEntity b) {
    Rectangle boundsA = a.getBoundingRectangle();
    Rectangle boundsB = b.getBoundingRectangle();
    if (!boundsA.overlaps(boundsB)) {
      return;
    }

    float overlapX = Math.min(boundsA.x + boundsA.width, boundsB.x + boundsB.width)
        - Math.max(boundsA.x, boundsB.x);
    float overlapY = Math.min(boundsA.y + boundsA.height, boundsB.y + boundsB.height)
        - Math.max(boundsA.y, boundsB.y);

    if (overlapX < overlapY) {
      separateAndBounce(a, b, overlapX, true, boundsA.x < boundsB.x);
    } else {
      separateAndBounce(a, b, overlapY, false, boundsA.y < boundsB.y);
    }
  }

  private static void separateAndBounce(
      AnimatedEntity a, AnimatedEntity b, float overlap, boolean xAxis, boolean aIsLower) {
    float push = overlap / 2f;
    float aSign = aIsLower ? -1f : 1f;

    if (xAxis) {
      a.setX(a.getX() + aSign * push);
      b.setX(b.getX() - aSign * push);
      flipVx(a);
      flipVx(b);
    } else {
      a.setY(a.getY() + aSign * push);
      b.setY(b.getY() - aSign * push);
      flipVy(a);
      flipVy(b);
    }
  }

  // A controlled entity's position is driven by the mouse, not its own velocity - don't perturb
  // the velocity it'll resume with once released.
  private static void flipVx(AnimatedEntity entity) {
    if (entity.isControlActive()) {
      return;
    }
    SpriteAnimation animation = entity.getCurrentAnimation();
    animation.setVx(-animation.getVx());
  }

  private static void flipVy(AnimatedEntity entity) {
    if (entity.isControlActive()) {
      return;
    }
    SpriteAnimation animation = entity.getCurrentAnimation();
    animation.setVy(-animation.getVy());
  }
}
