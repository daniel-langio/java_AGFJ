package agfj.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represent an entity's personal characteristics
 * */
@AllArgsConstructor
@Data
public class Personality {
    /** The actual mood for the personality */
    private CharacterMood actualMood;

    /** The most common mood for the personality */
    private CharacterMood generalMood;

    /** The sexual gender of the personality */
    private Gender gender;
}
