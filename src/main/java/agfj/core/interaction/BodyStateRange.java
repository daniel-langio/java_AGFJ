package agfj.core.interaction;

import agfj.core.entity.BodyState;
import agfj.core.type.IntegerRange;
import agfj.core.type.ValueScope;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent a set of body state
 * <>
 * This class is like the {@link BodyState} but his values are {@link ValueScope}
 * */
@AllArgsConstructor
@Data
public class BodyStateRange implements ValueScope<BodyState> {

  /** The range of maximum health point */
  private IntegerRange maxHealthPoint;

  /** The range of current health point */
  private IntegerRange actualHealthPoint;

  /** The range of current cleanness point */
  private IntegerRange maxCleannessPoint;

  /** The range of current cleanness point */
  private IntegerRange actualCleannessPoint;

  @Override
  public Boolean isInclude(BodyState value) {
    return maxHealthPoint.isInclude(value.getMaxHealthPoint()) &&
            actualHealthPoint.isInclude(value.getActualHealthPoint()) &&
            maxCleannessPoint.isInclude(value.getMaxCleannessPoint()) &&
            actualCleannessPoint.isInclude(value.getActualCleannessPoint());
  }
}
