package vendredi.soir.agfj.core.physics;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent the position of a body in a 2d space
 * */
@AllArgsConstructor
@Data
public class Position {

    /** The coordinate in a 2d space */
    private Coordinate2d coordinate;

    /** The rotation */
    private Rotation rotation;
}
