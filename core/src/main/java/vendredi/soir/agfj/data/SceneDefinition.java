package vendredi.soir.agfj.data;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SceneDefinition {
  private String id;
  private List<EntityInstanceDefinition> entities;
}
