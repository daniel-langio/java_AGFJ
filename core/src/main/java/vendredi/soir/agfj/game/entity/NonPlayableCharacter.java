package vendredi.soir.agfj.game.entity;

import vendredi.soir.agfj.core.entity.Body;
import vendredi.soir.agfj.core.entity.CharacterState;
import vendredi.soir.agfj.core.entity.Personality;
import vendredi.soir.agfj.core.interaction.Interaction;
import vendredi.soir.agfj.game.controller.AICharacterController;

import java.util.List;

/**
 * Character controlled by an AI
 * TODO: implement
 * */
public class NonPlayableCharacter extends ControllableCharacter{

    /**
     * Creates a new AI controlled character
     *
     * @param name         The character's name
     * @param description  The character's description
     * @param personality  The character's personality
     * @param body         The character's body
     * @param state        The character's state
     * @param interactions The possible interactions with the character
     * @param controller   The controller of the character*/
    public NonPlayableCharacter(
            String name, String description, Personality personality,
            Body body, CharacterState state, List<Interaction> interactions,
            AICharacterController controller
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
