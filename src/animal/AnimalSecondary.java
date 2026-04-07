package animal;

import static org.junit.Assert.assertFalse;

import java.util.Random;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.tree.Tree;

/**
 * Layered implementations of secondary methods for {@code Animal}.
 */

public abstract class AnimalSecondary extends Object implements Animal {

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

    public final boolean equals(Animal a) {
        boolean result = false;
        if (this == a) {
            result = true;
        }
        if (a instanceof Animal) {
            Animal other = (Animal) a;
            result = this.hunger() == other.hunger()
                    && this.health() == other.health()
                    && this.isAlive() == other.isAlive()
                    && this.species().equals(other.species())
                    && this.name().equals(other.name())
                    && this.gender().equals(other.gender());
        }
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

    @Override
    public String family(Tree<Animal> t, int d) {
        assert d >= 0;
        String returnValue = "";
        if (t.size() == 0) {
            if (d == 0) {
                returnValue += "self: " + t.root() + "\n";
            } else if (d == 1) {
                returnValue += "child: " + t.root() + "\n";
            } else if (d == 2) {
                returnValue += "grandchild: " + t.root() + "\n";
            } else {
                for (int i = 0; i < d - 2; i++) {
                    returnValue += "great";
                }
                returnValue += "grandchild: " + t.root() + "\n";
            }
        } else {
            Sequence<Tree<Animal>> s = new Sequence1L<>();
            Animal root = t.disassemble(s);
            for (Tree<Animal> child : s) {
                returnValue += this.family(child, d + 1);
            }
            t.assemble(root, s);
        }
        return returnValue;
    }
}
