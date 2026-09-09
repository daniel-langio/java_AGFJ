package vendredi.soir.agfj.lwjgl3.demo.ballbounce;

import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;
import vendredi.soir.agfj.data.EntityDefinition;
import vendredi.soir.agfj.factory.ActionLoader;
import vendredi.soir.agfj.factory.EntityDefinitionLoader;
import vendredi.soir.agfj.factory.SceneLoader;
import vendredi.soir.agfj.game.Game;

/**
 * Interactive preview of the "ball-bounce" scenario (a ball bouncing indefinitely inside a box).
 * Lives under src/test alongside its launcher so visualizing a scenario never requires a
 * temporary edit to MyGame.
 */
public class BallBounceDemo extends Game {
  private static final String ACTIONS_DIR = "data/actions";
  private static final String ENTITIES_DIR = "data/entities";
  private static final String SCENE_FILE = "data/scenes/ball-bounce-scene.json";

  public BallBounceDemo() {
    super();
  }

  @Override
  public void init() {
    Map<String, ActionDefinition> actions = ActionLoader.loadAll(ACTIONS_DIR);
    Map<String, EntityDefinition> entityDefinitions = EntityDefinitionLoader.loadAll(ENTITIES_DIR);
    SceneLoader.populate(world, SCENE_FILE, entityDefinitions, actions);
  }
}
