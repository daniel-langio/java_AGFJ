package vendredi.soir.agfj.core.entity;

import vendredi.soir.agfj.core.interaction.Movement;
import vendredi.soir.agfj.core.physics.Coordinate2d;
import vendredi.soir.agfj.core.physics.Position;
import vendredi.soir.agfj.core.physics.Rotation;
import lombok.Getter;

/**
 * Represent a character's body
 * */
@Getter
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

        newCoo.setX(newCoo.getX() + movement.getVelocity().getX() * movement.getSpeed());
        newCoo.setY(newCoo.getY() + movement.getVelocity().getY() * movement.getSpeed());

        newRotation.setValue(movement.getRotation());

        position.setCoordinate(newCoo);
        position.setRotation(newRotation);
    }

    /**
     * Applies a state to the body
     * @param state the state to apply */
    public void applyState(BodyState state) {
        this.state = state;
    }
}
