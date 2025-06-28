package agfj.core.interaction;

import agfj.core.entity.Character;

/**
 * Represent an action to do for a specific character state
 * */
public record Interaction (CharacterStateRange targetState, Action action) {
    
    /** Tell if a character matches the target's state*/
    public Boolean matches(Character target) {
        return this.targetState.isInclude(target.getState());
    }
}
