package agfj.core.type;

/**
 * Represent a non unit value
 * */
public interface ValueScope<T> {

    /**
     * Checks if a value is in the scope
     *
     * @param value the value to check
     * @return true if the value is in the scope, false otherwise.*/
    public Boolean isInclude(T value);
}
