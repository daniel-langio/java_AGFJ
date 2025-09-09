package vendredi.soir.agfj.core.interaction;

import vendredi.soir.agfj.core.entity.BodyState;
import vendredi.soir.agfj.core.type.IntegerRange;
import vendredi.soir.agfj.core.type.ValueScope;
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

  /** The range of action base speed */
  private IntegerRange speed;

  @Override
  public Boolean isInclude(BodyState value) {
    return maxHealthPoint.isInclude(value.getMaxHealthPoint()) &&
            actualHealthPoint.isInclude(value.getActualHealthPoint()) &&
            maxCleannessPoint.isInclude(value.getMaxCleannessPoint()) &&
            actualCleannessPoint.isInclude(value.getActualCleannessPoint()) &&
            speed.isInclude(value.getSpeed());
  }
}
