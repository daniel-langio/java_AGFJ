package vendredi.soir.agfj.game;

import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;
import vendredi.soir.agfj.data.EntityDefinition;
import vendredi.soir.agfj.factory.ActionLoader;
import vendredi.soir.agfj.factory.EntityDefinitionLoader;
import vendredi.soir.agfj.factory.SceneLoader;

public class MyGame extends Game {
  private static final String ACTIONS_DIR = "data/actions";
  private static final String ENTITIES_DIR = "data/entities";
  private static final String SCENE_FILE = "data/scenes/demo.json";

  public MyGame() {
    super();
  }

  @Override
  public void init() {
    Map<String, ActionDefinition> actions = ActionLoader.loadAll(ACTIONS_DIR);
    Map<String, EntityDefinition> entityDefinitions = EntityDefinitionLoader.loadAll(ENTITIES_DIR);
    SceneLoader.populate(world, SCENE_FILE, entityDefinitions, actions);
  }
}
