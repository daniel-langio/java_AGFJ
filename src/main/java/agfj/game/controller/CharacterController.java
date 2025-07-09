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
     * Method executed in each game loop iteration.
     * Specifies when to move where.
     * */
    abstract void update();
}
