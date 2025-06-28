package agfj.core.interaction;

import agfj.core.entity.CharacterState;
import agfj.core.type.ValueScope;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent a set of character state
 * <>
 * This class is like the {@link CharacterState} but his values are {@link ValueScope}
 *
 * won't include action in this, because 'j'ai la flemme'
 * */
@AllArgsConstructor
@Data
public class CharacterStateRange implements ValueScope<CharacterState> {

    /** A set of body state */
    private BodyStateRange bodyStateRange;

    @Override
    public Boolean isInclude(CharacterState value) {
        return bodyStateRange.isInclude(value.getBodyState());
    }
}
