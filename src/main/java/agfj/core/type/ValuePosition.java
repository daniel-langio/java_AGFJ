package agfj.core.type;

/**
 * Represent a value position
 * */
public abstract class ValuePosition<T> implements ValueScope<T> {

    /** The reference value */
    protected T value;

    /** The relation of the position to the value */
    protected ValueRelation valueRelation;
}
