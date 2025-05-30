package agfj.core.entity;

/**
 * Represent an action to do for a specific character state
 * */
public record Interaction (CharacterState target, Action action) {}
