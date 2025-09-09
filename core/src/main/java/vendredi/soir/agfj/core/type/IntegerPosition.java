package vendredi.soir.agfj.core.type;

/**
 * Represent a scope of integers
 * */
public class IntegerPosition extends ValuePosition<Integer> {

    /** Create an integer scope */
    public IntegerPosition(ValueRelation relation, Integer value) {
        this.valueRelation = relation;
        this.value = value;
    }

    @Override
    public Boolean isInclude(Integer value) {
        return switch (valueRelation)  {
            case EQUAL -> value.equals(this.value);
            case SUPERIOR -> value > this.value;
            case INFERIOR -> value < this.value;
        };
    }
}
