package agfj.game.controller;

import agfj.game.entity.ControllableCharacter;

/**
 * Keyboard-based character controller
 * TODO: implement
 * */
public class KeyInputCharacterController extends CharacterController {

    public KeyInput getKeyInput() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void update(ControllableCharacter character) {
        KeyInput keyInput = getKeyInput();

        if (keyInput.equals(KeyInput.LEFT)) {
            character.moveLeft();
        } else if (keyInput.equals(KeyInput.RIGHT)) {
            character.moveRight();
        }
    }
}
