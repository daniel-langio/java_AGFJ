package agfj.core.entity;

import agfj.core.physics.Position;

/**
 * Represent a character's body
 * */
public class Body extends Entity {
    private BodyState state;
    private Position position;

    /**
     * Applies a movement to the body
     * */
    public void applyMovement(Movement movement) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
