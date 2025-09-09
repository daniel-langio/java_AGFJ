package vendredi.soir.agfj.game.controller;

import vendredi.soir.agfj.game.entity.ControllableCharacter;

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
     *
     * @param character the controlled character
     * */
    public abstract void update(ControllableCharacter character);
}
