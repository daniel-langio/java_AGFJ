package agfj.core.entity;

import java.util.List;

/**
 * Represent a game character
 * */
public class Character extends Entity {
    private Personality personality;
    private Body body;
    private CharacterState state;

    private List<Interaction> interactions;

    /**
     * Applies a state to the character
     *
     * @param state the {@link CharacterState} to apply
     * */
    public void applyState(CharacterState state) {
        throw new  UnsupportedOperationException("Not implemented yet.");
    }

}
