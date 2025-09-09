package vendredi.soir.agfj.core.physics;

/**
 * Represent a rotation of an object in a 2d space
 * */
public class Rotation {

    /** The value of the rotation in degree*/
    private int degValue;

    /**
     * Creates a rotation object from a degree value
     *
     * @param degValue the degree value of the rotation.
     * */
    public Rotation(int degValue) {setValue(degValue);}

    /** Converts a given degree value into a value included between 0 and 360. */
    public static int roundDeg(int degValue) {return degValue % 360;}

    /**
     * Set the value of the rotation using the given value.
     * NOTE: The new value is converted to a value between 0 and 360.
     *
     * @param degValue the new value of the rotation*/
    public void setValue(int degValue) {this.degValue = roundDeg(degValue);}

    /** Provides the value in degree of the rotation */
    public int getValue() {return this.degValue;}
}
