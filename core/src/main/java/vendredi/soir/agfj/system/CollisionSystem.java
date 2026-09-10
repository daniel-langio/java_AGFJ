package vendredi.soir.agfj.system;

import com.badlogic.gdx.math.Rectangle;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.entity.TexturedEntity;
import vendredi.soir.agfj.game.GameWorld;
import vendredi.soir.agfj.graphics.sprites.SpriteAnimation;

/**
 * Pairwise bounding-box collision among "solid" entities. O(n^2) - fine at demo scale, not meant
 * to scale to large entity counts. Also counts distinct collision events (a pair transitioning
 * from separated to overlapping, not every frame they happen to stay in contact), for callers
 * that want to react to or stop after N collisions.
 */
public class CollisionSystem {
  @Getter private int collisionEventCount = 0;

  private final Set<Map.Entry<AnimatedEntity, AnimatedEntity>> previouslyOverlapping =
      new HashSet<>();

  public void resolve(GameWorld world) {
    List<AnimatedEntity> solidEntities = new ArrayList<>();
    for (TexturedEntity entity : world.getEntities()) {
      if (entity instanceof AnimatedEntity animatedEntity && animatedEntity.isSolid()) {
        solidEntities.add(animatedEntity);
      }
    }

    Set<Map.Entry<AnimatedEntity, AnimatedEntity>> stillOverlapping = new HashSet<>();

    for (int i = 0; i < solidEntities.size(); i++) {
      for (int j = i + 1; j < solidEntities.size(); j++) {
        AnimatedEntity a = solidEntities.get(i);
        AnimatedEntity b = solidEntities.get(j);

        if (!resolvePair(a, b)) {
          continue;
        }

        Map.Entry<AnimatedEntity, AnimatedEntity> pairKey = new AbstractMap.SimpleEntry<>(a, b);
        stillOverlapping.add(pairKey);
        if (!previouslyOverlapping.contains(pairKey)) {
          collisionEventCount++;
        }
      }
    }

    previouslyOverlapping.clear();
    previouslyOverlapping.addAll(stillOverlapping);
  }

  private boolean resolvePair(AnimatedEntity a, AnimatedEntity b) {
    Rectangle boundsA = a.getBoundingRectangle();
    Rectangle boundsB = b.getBoundingRectangle();
    if (!boundsA.overlaps(boundsB)) {
      return false;
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
    return true;
  }

  private void separateAndBounce(
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
  private void flipVx(AnimatedEntity entity) {
    if (entity.isControlActive()) {
      return;
    }
    SpriteAnimation animation = entity.getCurrentAnimation();
    animation.setVx(-animation.getVx());
  }

  private void flipVy(AnimatedEntity entity) {
    if (entity.isControlActive()) {
      return;
    }
    SpriteAnimation animation = entity.getCurrentAnimation();
    animation.setVy(-animation.getVy());
  }
}
