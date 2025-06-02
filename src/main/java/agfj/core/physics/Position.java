package agfj.core.physics;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent the position of a body in a 2d space
 * */
@AllArgsConstructor
@Data
public class Position {
    private Coordinate2d coordinate;
    private Rotation rotation;
}
