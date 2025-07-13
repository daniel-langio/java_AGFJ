package agfj.game.controller;

import agfj.game.entity.ControllableCharacter;

/**
 * A character controller
 * */
public abstract class CharacterController {

    /**
     * The character to control
     * */
    protected ControllableCharacter character;

    /**
     * Method executed in each game loop iteration to update character's state
     * Specifies when to move where.
     * */
    public abstract void update(ControllableCharacter character);
}
