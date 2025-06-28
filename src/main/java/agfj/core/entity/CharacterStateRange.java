package agfj.core.entity;

import agfj.core.type.ValueScope;

/**
 * Represent a set of character state
 * <>
 * This class is like the {@link CharacterState} but his values are {@link ValueScope}
 *
 * won't include action in this, because 'j'ai la flemme'
 * */
public class CharacterStateRange implements ValueScope<CharacterState> {

    /** A set of body state */
    private BodyStateRange bodyStateRange;

    @Override
    public Boolean isInclude(CharacterState value) {
        return bodyStateRange.isInclude(value.getBodyState());
    }
}
