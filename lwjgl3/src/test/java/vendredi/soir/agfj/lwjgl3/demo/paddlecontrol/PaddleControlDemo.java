package vendredi.soir.agfj.lwjgl3.demo.paddlecontrol;

import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;
import vendredi.soir.agfj.data.EntityDefinition;
import vendredi.soir.agfj.factory.ActionLoader;
import vendredi.soir.agfj.factory.EntityDefinitionLoader;
import vendredi.soir.agfj.factory.SceneLoader;
import vendredi.soir.agfj.game.Game;

/**
 * Interactive preview of the "paddle-control" scenario: a mouse-controlled paddle that deflects a
 * bouncing ball on contact. Lives under src/test alongside its launcher, same convention as
 * demo/ballbounce.
 */
public class PaddleControlDemo extends Game {
  private static final String ACTIONS_DIR = "data/actions";
  private static final String ENTITIES_DIR = "data/entities";
  private static final String SCENE_FILE = "data/scenes/paddle-control-scene.json";

  public PaddleControlDemo() {
    super();
  }

  @Override
  public void init() {
    Map<String, ActionDefinition> actions = ActionLoader.loadAll(ACTIONS_DIR);
    Map<String, EntityDefinition> entityDefinitions = EntityDefinitionLoader.loadAll(ENTITIES_DIR);
    SceneLoader.populate(world, SCENE_FILE, entityDefinitions, actions);
  }
}
