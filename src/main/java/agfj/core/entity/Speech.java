package agfj.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represent a Personality's expression
 * */
@EqualsAndHashCode(callSuper = true)
@Data
public final class Speech extends Action {
    private final String content;
    private final CharacterMood mood;
}
