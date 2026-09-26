package vendredi.soir.nofy.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import vendredi.soir.nofy.data.ActionDefinition;
import vendredi.soir.nofy.data.ActionRule;
import vendredi.soir.nofy.data.BoundsDefinition;
import vendredi.soir.nofy.data.EntityDefinition;
import vendredi.soir.nofy.data.EntityInstanceDefinition;
import vendredi.soir.nofy.data.SceneDefinition;
import vendredi.soir.nofy.entity.AnimatedEntity;
import vendredi.soir.nofy.game.GameWorld;

public final class SceneLoader {
  private SceneLoader() {}

  public static void populate(
      GameWorld world,
      String sceneFilePath,
      Map<String, EntityDefinition> entityDefinitions,
      Map<String, ActionDefinition> actions) {
    SceneDefinition scene =
        GameDataJson.instance().fromJson(SceneDefinition.class, Gdx.files.internal(sceneFilePath));

    if (scene.getSimulationRange() != null) {
      world.setSimulationRange(scene.getSimulationRange());
    }

    for (EntityInstanceDefinition instance : scene.getEntities()) {
      EntityDefinition entityDefinition = entityDefinitions.get(instance.getEntityDefinitionId());
      if (entityDefinition == null) {
        throw new IllegalArgumentException(
            String.format(
                "Entity definition %s referenced by scene %s is not defined",
                instance.getEntityDefinitionId(), sceneFilePath));
      }

      AnimatedEntity entity =
          EntityFactory.create(
              entityDefinition, actions, instance.getInstanceName(), instance.getInitialActionId());
      entity.setPosition(instance.getX(), instance.getY());

      BoundsDefinition bounceBounds = instance.getBounceBounds();
      if (bounceBounds != null) {
        entity.setBounceBounds(
            new Rectangle(
                bounceBounds.getX(),
                bounceBounds.getY(),
                bounceBounds.getWidth(),
                bounceBounds.getHeight()));
      }

      List<ActionRule> actionRules = instance.getActionRules();
      if (actionRules != null) {
        entity.setActionRules(
            actionRules.stream()
                .sorted(Comparator.comparingInt(ActionRule::getPriority).reversed())
                .toList());
      }
      entity.setSolid(instance.isSolid());

      if (instance.isCameraTarget()) {
        world.setCameraTarget(entity);
      }

      world.addEntity(entity);
    }
  }
}
