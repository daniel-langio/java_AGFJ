package vendredi.soir.agfj.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;
import vendredi.soir.agfj.data.BoundsDefinition;
import vendredi.soir.agfj.data.ControlDefinition;
import vendredi.soir.agfj.data.DeactivationTrigger;
import vendredi.soir.agfj.data.EntityDefinition;
import vendredi.soir.agfj.data.EntityInstanceDefinition;
import vendredi.soir.agfj.data.SceneDefinition;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.game.GameWorld;

public final class SceneLoader {
  private SceneLoader() {}

  public static void populate(
      GameWorld world,
      String sceneFilePath,
      Map<String, EntityDefinition> entityDefinitions,
      Map<String, ActionDefinition> actions) {
    SceneDefinition scene =
        GameDataJson.instance().fromJson(SceneDefinition.class, Gdx.files.internal(sceneFilePath));

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

      ControlDefinition control = instance.getControl();
      if (control != null) {
        validateControl(control, instance.getEntityDefinitionId());
        entity.setControlDefinition(control);
      }
      entity.setSolid(instance.isSolid());

      world.addEntity(entity);
    }
  }

  private static void validateControl(ControlDefinition control, String entityDefinitionId) {
    if (control.getDeactivateOn() == DeactivationTrigger.TIMEOUT
        && (control.getDeactivateAfterSeconds() == null || control.getDeactivateAfterSeconds() <= 0)) {
      throw new IllegalArgumentException(
          String.format(
              "Entity %s declares control.deactivateOn=TIMEOUT but no positive"
                  + " deactivateAfterSeconds was given",
              entityDefinitionId));
    }
  }
}
