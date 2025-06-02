package agfj.core.entity;

import agfj.core.physics.Coordinate2d;
import agfj.core.physics.Position;
import agfj.core.physics.Rotation;

/**
 * Represent a character's body
 * */
public class Body extends Entity {
    /** The state of the body */
    private BodyState state;

    /** The position of the body on a space */
    private Position position;

    /**
     * Applies a movement to the body.
     *
     * @param movement the {@link Movement} to appy to the body.
     * */
    public void applyMovement(Movement movement) {
        Coordinate2d newCoo = position.getCoordinate();
        Rotation newRotation = position.getRotation();

        newCoo.setX(newCoo.getX() + movement.getVelocity().getX() * movement.speed);
        newCoo.setY(newCoo.getY() + movement.getVelocity().getY() * movement.speed);

        newRotation.setValue(movement.getRotation());

        position.setCoordinate(newCoo);
        position.setRotation(newRotation);
    }
}
