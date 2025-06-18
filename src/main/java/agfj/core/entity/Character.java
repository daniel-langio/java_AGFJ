package agfj.core.entity;

import java.util.List;

import lombok.Getter;

/**
 * Represent a game character
 * */
@Getter
public abstract class Character extends Entity {
    /** The mental dimension of the character */
    protected Personality personality;

    /** The physical dimension of the character */
    protected Body body;

    /** The state of the character */
    protected CharacterState state;

    /** List of possible interaction to do with the character */
    protected List<Interaction> interactions;

    /**
     * Applies a state to the character
     *
     * @param state the {@link CharacterState} to apply
     * */
    public void applyState(CharacterState state) {
        this.state = state;
        this.body.applyState(state.getBodyState());
    }

}
