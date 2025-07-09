package agfj.game.entity;

import agfj.core.entity.Body;
import agfj.core.entity.CharacterState;
import agfj.core.entity.Personality;
import agfj.core.interaction.Interaction;
import agfj.game.controller.KeyInputCharacterController;

import java.util.List;

/**
 * Character controlled by the player
 * TODO: implement
 * */
public class PlayableCharacter extends ControllableCharacter{

    /**
     * Creates a new playable character
     *
     * @param name         The character's name
     * @param description  The character's description
     * @param personality  The character's personality
     * @param body         The character's body
     * @param state        The character's state
     * @param interactions The possible interactions with the character
     * @param controller   The controller of the character*/
    public PlayableCharacter(
            String name, String description, Personality personality,
            Body body, CharacterState state, List<Interaction> interactions,
            KeyInputCharacterController controller
    ) {
        this.name = name;
        this.description = description;
        this.personality = personality;
        this.body = body;
        this.state = state;
        this.interactions = interactions;
        this.controller = controller;
    }
}
