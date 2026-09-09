package vendredi.soir.agfj.data;

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
  private ControlDefinition control;
  private boolean solid = false;
}
