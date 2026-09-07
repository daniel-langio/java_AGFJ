package vendredi.soir.agfj.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ActionDefinition {
  private String id;
  private float vx = 0f;
  private float vy = 0f;
  private boolean loop = true;
}
