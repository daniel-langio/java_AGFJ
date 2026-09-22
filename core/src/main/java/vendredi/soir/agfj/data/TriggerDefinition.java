package vendredi.soir.agfj.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

/** Fields are only meaningful for the matching {@link TriggerType}; unused ones stay null. */
@Getter
@NoArgsConstructor
public class TriggerDefinition {
  private TriggerType type;
  private Float radius; // PROXIMITY: distance to the camera target, in world units
  private Float startHour; // TIME_OF_DAY: 0-24, wraps past midnight if startHour > endHour
  private Float endHour; // TIME_OF_DAY
  private String eventName; // ENVIRONMENT_EVENT: matches GameWorld.raiseEvent(name)
}
