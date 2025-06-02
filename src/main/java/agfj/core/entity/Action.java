package agfj.core.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Represent an Entity's action
 * */
@Getter
@Setter
public abstract sealed class Action permits Movement, Speech {
    /** The speed which the action will be executed */
    protected int speed;
}
