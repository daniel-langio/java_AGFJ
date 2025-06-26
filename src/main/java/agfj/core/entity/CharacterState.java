package agfj.core.entity;

import agfj.core.interaction.Action;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent the state if a character
 * */
@AllArgsConstructor
@Data
public class CharacterState {

    /** The body state */
    private BodyState bodyState;

    /** The executed action. Null if no action is executed */
    private Action action;
}
