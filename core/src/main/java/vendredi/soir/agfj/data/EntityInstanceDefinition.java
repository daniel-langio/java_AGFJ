package vendredi.soir.agfj.data;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EntityInstanceDefinition {
  private String entityDefinitionId;
  private String instanceName;
  private float x = 0f;
  private float y = 0f;
  private String initialActionId;
  private BoundsDefinition bounceBounds;
  private List<ActionRule> actionRules;
  private boolean solid = false;
  private boolean cameraTarget = false;
}
