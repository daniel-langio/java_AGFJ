package vendredi.soir.agfj.core.type;

/**
 * Represent a range of integers
 * */
public class IntegerRange extends ValueRange<Integer, IntegerPosition>{

    /** Creates an integer's range */
    public IntegerRange (IntegerPosition start, LogicalOperator operator, IntegerPosition end) {
        this.rightLimit = start;
        this.operator = operator;
        this.leftLimit = end;
    }
}
