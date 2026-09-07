package vendredi.soir.agfj.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.util.HashMap;
import java.util.Map;
import vendredi.soir.agfj.data.ActionDefinition;

public final class ActionLoader {
  private ActionLoader() {}

  public static Map<String, ActionDefinition> loadAll(String directoryPath) {
    Map<String, ActionDefinition> actions = new HashMap<>();

    for (FileHandle file : Gdx.files.internal(directoryPath).list(".json")) {
      ActionDefinition action = GameDataJson.instance().fromJson(ActionDefinition.class, file);
      actions.put(action.getId(), action);
    }

    return actions;
  }
}
