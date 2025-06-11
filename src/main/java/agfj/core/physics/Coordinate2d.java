package agfj.core.physics;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent a coordinate in a 2D space
 * */
@AllArgsConstructor
@Data
public class Coordinate2d {

    /** The coordinate on the x-axis */
    protected double x;

    /** The coordinate on the y-axis */
    protected double y;
}
