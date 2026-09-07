package vendredi.soir.agfj.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.util.HashMap;
import java.util.Map;
import vendredi.soir.agfj.data.EntityDefinition;

public final class EntityDefinitionLoader {
  private EntityDefinitionLoader() {}

  public static Map<String, EntityDefinition> loadAll(String directoryPath) {
    Map<String, EntityDefinition> entityDefinitions = new HashMap<>();

    for (FileHandle file : Gdx.files.internal(directoryPath).list(".json")) {
      EntityDefinition entityDefinition =
          GameDataJson.instance().fromJson(EntityDefinition.class, file);
      entityDefinitions.put(entityDefinition.getId(), entityDefinition);
    }

    return entityDefinitions;
  }
}
