package agfj.core.entity;

import agfj.core.physics.Vector2D;
import lombok.Getter;

/**
 * Represents a body's movement
 * */
@Getter
public final class Movement extends Action {
    private final int rotation;
    private final Vector2D velocity;

    public Movement(int speed, int rotation,Vector2D velocity) {
        this.speed = speed;
        this.rotation = rotation;
        this.velocity = velocity;
    }
}
