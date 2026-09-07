package vendredi.soir.agfj.factory;

import com.badlogic.gdx.utils.Json;
import vendredi.soir.agfj.data.AnimationBinding;
import vendredi.soir.agfj.data.EntityDefinition;
import vendredi.soir.agfj.data.EntityInstanceDefinition;
import vendredi.soir.agfj.data.SceneDefinition;

public final class GameDataJson {
  private static final Json JSON = new Json();

  static {
    JSON.setElementType(EntityDefinition.class, "animations", AnimationBinding.class);
    JSON.setElementType(SceneDefinition.class, "entities", EntityInstanceDefinition.class);
  }

  private GameDataJson() {}

  public static Json instance() {
    return JSON;
  }
}
