package vendredi.soir.agfj.factory;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.List;
import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;
import vendredi.soir.agfj.data.AnimationBinding;
import vendredi.soir.agfj.data.EntityDefinition;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.graphics.sprites.SpriteAnimation;
import vendredi.soir.agfj.graphics.sprites.SpriteLoader;

public final class EntityFactory {
  private EntityFactory() {}

  public static AnimatedEntity create(
      EntityDefinition definition,
      Map<String, ActionDefinition> actions,
      String instanceName,
      String initialActionId) {
    List<SpriteAnimation> spriteAnimations =
        definition.getAnimations().stream().map(binding -> toSpriteAnimation(binding, actions)).toList();

    String name = instanceName != null ? instanceName : definition.getId();
    String defaultActionId =
        initialActionId != null ? initialActionId : definition.getDefaultActionId();

    AnimatedEntity entity = new AnimatedEntity(name, spriteAnimations, defaultActionId);
    entity.setSize(definition.getWidth(), definition.getHeight());
    return entity;
  }

  private static SpriteAnimation toSpriteAnimation(
      AnimationBinding binding, Map<String, ActionDefinition> actions) {
    ActionDefinition action = actions.get(binding.getActionId());
    if (action == null) {
      throw new IllegalArgumentException(
          String.format("Action %s referenced by a binding is not defined", binding.getActionId()));
    }

    List<TextureRegion> frames =
        SpriteLoader.loadSpriteSet(
            binding.getSpriteSheetPath(),
            binding.getFrameWidth(),
            binding.getFrameHeight(),
            binding.getFirstFrameX(),
            binding.getFirstFrameY(),
            binding.getFrameCount());

    SpriteAnimation animation =
        new SpriteAnimation(0, binding.getFps(), binding.getActionId(), frames);
    animation.setLoop(action.isLoop());
    animation.setVx(action.getVx());
    animation.setVy(action.getVy());
    return animation;
  }
}
