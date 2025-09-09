package vendredi.soir.agfj.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent the state of a body
 * */
@AllArgsConstructor
@Data
public class BodyState {

    /** The maximum health point */
    private int maxHealthPoint;

    /** The current health point */
    private int actualHealthPoint;

    /** The current cleanness point */
    private int maxCleannessPoint;

    /** The current cleanness point */
    private int actualCleannessPoint;

    /** Action base speed */
    private int speed;
}
