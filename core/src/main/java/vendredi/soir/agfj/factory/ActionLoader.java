package vendredi.soir.agfj.factory;

import com.badlogic.gdx.Gdx;
import java.util.HashMap;
import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;

public final class ActionLoader {
  private ActionLoader() {}

  public static Map<String, ActionDefinition> loadAll(String directoryPath) {
    Map<String, ActionDefinition> actions = new HashMap<>();

    for (String path : AssetManifest.listJsonFiles(directoryPath)) {
      ActionDefinition action =
          GameDataJson.instance().fromJson(ActionDefinition.class, Gdx.files.internal(path));
      actions.put(action.getId(), action);
    }

    return actions;
  }
}
