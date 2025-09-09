package vendredi.soir.agfj.game.entity;

import vendredi.soir.agfj.core.entity.Character;
import vendredi.soir.agfj.core.interaction.Movement;
import vendredi.soir.agfj.core.physics.Vector2D;
import vendredi.soir.agfj.game.controller.CharacterController;

/**
 * A controllable character
 **/
public abstract class ControllableCharacter extends Character {

    /**
     * Controller
     * */
    protected CharacterController controller;

    /**
     * Move the character to the left
     * */
    public void moveLeft() {
        Vector2D leftVelocity = new Vector2D(-1,0);
        Movement leftMovement = new Movement(this.body.getState().getSpeed(), 0, leftVelocity);

        this.body.applyMovement(leftMovement);
    }

    /**
     * Move the character to the right
     * */
    public void moveRight() {
        Vector2D rightVelocity = new Vector2D(1,0);
        Movement  rightMovement = new Movement(this.body.getState().getSpeed(), 0, rightVelocity);

        this.body.applyMovement(rightMovement);
    }

}
