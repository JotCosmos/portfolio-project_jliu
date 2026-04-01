import java.util.Random;
import java.util.Scanner;

/**
 * The purpose of this component is to model the health and status of an animal.
 * The kernel methods include basic survival functions for the animal, while the
 * secondary methods go in more depth for relationships with other animals and
 * data reporting.
 *
 * @author Jenny Liu
 */
public class Animal1 {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Default highest integer representation of hunger and health.
     */
    private static final int FULL = 100;

    /**
     * Lowest integer representation of hunger and health.
     */
    private static final int EMPTY = 0;

    /**
     * Stores the hunger level of the animal.
     */
    private int hunger;

    /**
     * Stores the health level of the animal.
     */
    private int health;

    /**
     * Stores whether the animal is living or deceased.
     */
    private boolean alive;

    /**
     * Stores the species of the animal.
     */
    private String species;

    /**
     * Stores the name of the animal.
     */
    private String name;

    /**
     * Stores the gender of the animal.
     */
    private String gender;

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor. Creates an unidentified, unnamed animal with
     * full stats.
     */
    public Animal1() {
        this.hunger = FULL;
        this.health = FULL;
        this.alive = true;
        this.species = "Unindentified";
        this.name = "Unnamed";
        this.gender = "Unknown";
    }

    /**
     * Constructor resulting in an animal with full stats, a name and a species.
     *
     * @param s
     *            The species of the animal.
     * @param n
     *            The name of the animal.
     * @param g
     *            The gender of the animal.
     * @requires The gender of the animal is male or female.
     */
    public Animal1(String s, String n, String g) {
        assert g.toLowerCase().equals("male") || g.toLowerCase()
                .equals("female") : "Violation of: gender is male or female";
        this.hunger = FULL;
        this.health = FULL;
        this.alive = true;
        this.species = s;
        this.name = n;
        this.gender = g;
    }

    /*
     * Secondary Methods -------------------------------------------------------
     */

    /**
     * Creates and returns a string containing the status of the animal.
     *
     * @return A String with all of the status variables of the animal.
     */
    public final String status() {
        String returnValue = "Species: " + this.species + "\nName: " + this.name
                + "\nGender: " + this.gender + "\nHealth: " + this.health
                + "\nHunger: " + this.hunger + "\nAlive: " + this.alive;
        return returnValue;
    }

    /**
     * Given another animal of the same species and opposite gender, a new
     * animal with a random gender is produced.
     *
     * @param a
     * @return The new animal
     */
    public final Animal1 reproduce(Animal1 a) {
        assert this.gender.equals(
                a.gender) : "Violation of : the two animals have opposite genders";
        assert this.species.equals(
                a.species) : "Violation of : the two animals are the same species";
        Random rand = new Random();
        int randomGender = rand.nextInt(1);
        String gender;
        if (randomGender == 1) {
            gender = "male";
        } else {
            gender = "female";
        }
        Animal1 baby = new Animal1(this.species, "Unnamed", gender);
        return baby;
    }

    /*
     * Kernel methods ----------------------------------------------------------
     */

    /**
     * Updates a given stat, like hunger and health, based on the inputted int,
     * as well as whether the animal is living or not based on those stats.
     *
     * @param stat
     * @param n
     * @requires 0 <= n <= 100
     * @ensures The given animal stat is updated to the correct value.
     */
    public final void update(String stat, int n) {
        assert n >= EMPTY && n <= FULL : "Violation of: n is in allowed range";
        if (stat.equals("hunger")) {
            this.hunger = n;
        }
        if (stat.equals("health")) {
            this.health = n;
        }
        if (this.health == EMPTY || this.hunger == EMPTY) {
            this.alive = false;
        }
    }

    /**
     * Returns a boolean containing whether the animal is living.
     *
     * @return true if alive, false if not.
     */
    public final boolean isAlive() {
        return this.alive;
    }

    /**
     * Returns the species of the animal.
     *
     * @return this animal's species.
     */
    public final String species() {
        return this.species;
    }

    /**
     * Returns the name of the animal.
     *
     * @return this animal's name.
     */
    public final String name() {
        return this.name;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of this species.");
        String s = input.nextLine();
        System.out.println("Please enter the name of the animal.");
        String n = input.nextLine();
        System.out.println(
                "Please enter the gender of the animal. (male or female)");
        String g = input.nextLine();
        Animal1 animal1 = new Animal1(s, n, g);
        System.out.println("The current animal is " + animal1.name() + ".");
        System.out.println("Would you like to update " + animal1.name()
                + "'s health or hunger? Please enter either \"health\" or \"hunger\".");
        String stat = input.nextLine();
        System.out.println("Please enter an integer from 0 to 100.");
        int num = input.nextInt();
        System.out.println(
                "Is " + animal1.name() + " alive: " + animal1.isAlive());
        System.out.println(
                "Updating " + animal1.name() + "'s " + stat + " to " + num);
        animal1.update("health", num);
        System.out.println(
                "Here is the animal's full status: \n" + animal1.status());
    }
}
