package vendredi.soir.agfj.core.interaction;

import vendredi.soir.agfj.core.physics.Vector2D;
import lombok.Getter;

/**
 * Represents a body's movement
 * */
@Getter
public final class Movement extends Action {

    /** The rotation value to apply */
    private final int rotation;

    /** The vector to add to the position */
    private final Vector2D velocity;

    /**
     * @param speed         the speed to execute the movement
     * @param rotation      the rotation to apply
     * @param velocity      the vector to add to the position */
    public Movement(int speed, int rotation,Vector2D velocity) {
        this.speed = speed;
        this.rotation = rotation;
        this.velocity = velocity;
    }
}
