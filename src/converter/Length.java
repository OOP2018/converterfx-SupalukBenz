package converter;

/**
 * Use enum Length for the converter to handle different units
 *
 * @author Supaluk Jaroensuk
 */
public enum Length {

    Meter(1.0000),
    Centimeter(0.0100),
    Kilometer(1000.0),
    Mile(1609.344),
    Foot(0.30480),
    Wa(2.00000),
    AU(149597870700.0);

    /**
     * attributes of the enum members
     */
    private final double value;

    /**
     * Initialize value of the enum members
     * @param value is enum members, as a double
     */
    private Length(double value) {
        this.value = value;
    }

    /**
     * Get value of the enum members
     * @return value of enum members
     */
    public double getValue(){
        return value;
    }
}