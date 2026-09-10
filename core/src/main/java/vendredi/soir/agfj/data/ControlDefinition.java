package vendredi.soir.agfj.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ControlDefinition {
  private ControlType type;
  private ActivationTrigger activateOn;
  private DeactivationTrigger deactivateOn;
  private Float deactivateAfterSeconds;
}
