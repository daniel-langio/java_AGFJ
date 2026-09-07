package vendredi.soir.agfj.data;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EntityDefinition {
  private String id;
  private float width = 32f;
  private float height = 32f;
  private String defaultActionId;
  private List<AnimationBinding> animations;
}
