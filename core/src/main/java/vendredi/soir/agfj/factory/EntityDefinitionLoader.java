package vendredi.soir.agfj.factory;

import com.badlogic.gdx.Gdx;
import java.util.HashMap;
import java.util.Map;
import vendredi.soir.agfj.data.EntityDefinition;

public final class EntityDefinitionLoader {
  private EntityDefinitionLoader() {}

  public static Map<String, EntityDefinition> loadAll(String directoryPath) {
    Map<String, EntityDefinition> entityDefinitions = new HashMap<>();

    for (String path : AssetManifest.listJsonFiles(directoryPath)) {
      EntityDefinition entityDefinition =
          GameDataJson.instance().fromJson(EntityDefinition.class, Gdx.files.internal(path));
      entityDefinitions.put(entityDefinition.getId(), entityDefinition);
    }

    return entityDefinitions;
  }
}
