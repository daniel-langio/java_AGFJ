package agfj.core.interaction;

import agfj.core.entity.CharacterMood;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represent a Personality's expression
 * */
@EqualsAndHashCode(callSuper = true)
@Data
public final class Speech extends Action {

    /** The text to show */
    private final String content;

    /** The mood to express the text */
    private final CharacterMood mood;

    /**
     * Creates a Speech
     *
     * @param speed the speed to express the speech
     * @param content the text to show
     * @param mood the mood to express the text */
    public Speech(int speed, String content, CharacterMood mood) {
        this.speed = speed;
        this.content = content;
        this.mood = mood;
    }
}
