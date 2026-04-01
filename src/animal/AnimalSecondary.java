package animal;

import static org.junit.Assert.assertFalse;

import java.util.Random;

/**
 * Layered implementations of secondary methods for {@code Animal}.
 */

public abstract class AnimalSecondary implements Animal {

    /*
     * Public members
     */

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

    /*
     * Other non-kernel methods
     */

    @Override
    public String status() {
        String value = "Species: " + this.species() + "\nName: " + this.name()
                + "\nGender: " + this.gender() + "\nHealth: " + this.health()
                + "\nHunger: " + this.hunger() + "\nAlive: " + this.isAlive();
        return value;
    }

    @Override
    public Animal reproduce(Animal other) {
        assertFalse(this.gender().equals(other.gender()));
        assertFalse(this.species().equals("Unknown"));
        assert (this.species().equals(other.species()));
        Animal child = this.newInstance();
        Random r = new Random();
        int randGender = r.nextInt(1);
        if (randGender == 0) {
            child.update("gender", "male");
        } else {
            child.update("gender", "female");
        }
        return child;
    }

}
