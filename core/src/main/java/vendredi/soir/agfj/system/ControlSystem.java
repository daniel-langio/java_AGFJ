package vendredi.soir.agfj.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import vendredi.soir.agfj.data.ControlDefinition;
import vendredi.soir.agfj.data.ControlType;
import vendredi.soir.agfj.entity.AnimatedEntity;
import vendredi.soir.agfj.entity.TexturedEntity;
import vendredi.soir.agfj.game.GameWorld;

/**
 * Drives entities that declare a {@link ControlDefinition}. Only one entity may be actively
 * controlled at a time; whichever holds the slot keeps it until its own deactivation condition
 * fires. Only {@link ControlType#MOUSE} is implemented so far - the type switch below is where a
 * future control type (keyboard, gamepad, ...) would plug in.
 */
public class ControlSystem {
  private AnimatedEntity activeEntity;
  private boolean leftButtonWasPressed;

  public void update(GameWorld world, Viewport viewport) {
    Vector2 mouseWorld = viewport.unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
    boolean leftButtonPressed = Gdx.input.isButtonPressed(Buttons.LEFT);
    boolean leftButtonJustReleased = leftButtonWasPressed && !leftButtonPressed;

    for (TexturedEntity texturedEntity : world.getEntities()) {
      if (!(texturedEntity instanceof AnimatedEntity entity)) {
        continue;
      }
      ControlDefinition control = entity.getControlDefinition();
      if (control == null || control.getType() != ControlType.MOUSE) {
        continue;
      }

      if (entity.isControlActive()) {
        updateActive(entity, control, mouseWorld, leftButtonJustReleased);
      } else {
        tryActivate(entity, control, mouseWorld);
      }
    }

    leftButtonWasPressed = leftButtonPressed;
  }

  private void tryActivate(AnimatedEntity entity, ControlDefinition control, Vector2 mouseWorld) {
    if (activeEntity != null) {
      return;
    }

    Rectangle bounds = entity.getBoundingRectangle();
    boolean satisfied =
        switch (control.getActivateOn()) {
          case INSTANT -> true;
          case ON_CLICK -> Gdx.input.isButtonJustPressed(Buttons.LEFT) && bounds.contains(mouseWorld);
          case ON_HOVER -> bounds.contains(mouseWorld);
        };

    if (satisfied) {
      entity.setControlActive(true);
      entity.setControlElapsedSeconds(0f);
      activeEntity = entity;
    }
  }

  private void updateActive(
      AnimatedEntity entity,
      ControlDefinition control,
      Vector2 mouseWorld,
      boolean leftButtonJustReleased) {
    Rectangle bounds = entity.getBoundingRectangle();
    boolean shouldDeactivate =
        switch (control.getDeactivateOn()) {
          case TIMEOUT -> entity.getControlElapsedSeconds() >= control.getDeactivateAfterSeconds();
          case ON_RELEASE_CLICK -> leftButtonJustReleased;
          case ON_OUT_HOVER -> !bounds.contains(mouseWorld);
        };

    if (shouldDeactivate) {
      entity.setControlActive(false);
      activeEntity = null;
      return;
    }

    entity.setPosition(
        mouseWorld.x - entity.getWidth() / 2f, mouseWorld.y - entity.getHeight() / 2f);
    entity.setControlElapsedSeconds(entity.getControlElapsedSeconds() + Gdx.graphics.getDeltaTime());
  }
}
