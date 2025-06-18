package agfj.core.entity;

/**
 * Represent an action to do for a specific character state
 * */
public record Interaction (CharacterState target, Action action) {
    
    /** Tell if a character matches the target*/
    public Boolean matches(Character target) {
        return this.target.equals(target.state);
    }
}
