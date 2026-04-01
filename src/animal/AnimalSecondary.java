package animal;

/**
 * Layered implementations of secondary methods for {@code Animal}.
 */

public abstract class AnimalSecondary implements Animal {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(");
        result.append(",\"");
        result.append(this.name());
        result.append("\",[contents])");
        return result.toString();
    }

    public boolean equals() {
        boolean result = false;
        return result;
    }
}
