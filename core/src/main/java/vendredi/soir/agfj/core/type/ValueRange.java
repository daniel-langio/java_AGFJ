package vendredi.soir.agfj.core.type;

/**
 * Represent a range of values
 * */
public abstract class ValueRange<T, P extends ValuePosition<T>> implements ValueScope<T> {

    /** The range's first value position */
    protected P leftLimit;

    /** The logical operator for the positions linking */
    protected LogicalOperator operator;

    /** The range's last value position */
    protected P rightLimit;

    /**
     * Tells if a value is included in the value range
     *
     * @param value the value to check
     * @return true if the value is included in the range, false otherwise.*/
    public Boolean isInclude(T value) {
        return switch (operator) {
            case AND -> leftLimit.isInclude(value) && rightLimit.isInclude(value);
            case OR -> leftLimit.isInclude(value) || rightLimit.isInclude(value);
        };
    }
}
