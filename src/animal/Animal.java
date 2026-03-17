package animal;
/**
 * {@code AnimalKernal} enhanced with secondary methods.
 */
public interface Animal extends AnimalKernel {
    /**
     * Creates and returns a String containing the status of the animal.
     *
     * @return A String with all of the status variables of the animal.
     * @ensures {@code status = a String containing the animal's status variables}
     */
    String status();

    /**
     * Given another animal of the same species and opposite gender, a new
     * animal with a random gender is produced.
     *
     * @param other
     *            Another animal which this will reproduce with
     * @requires 1. the gender of this and other are different, and neither is
     *           unknown 2. the species of this and other are the same, and both
     *           not unknown
     * @return The new animal
     * @ensures {@code reproduce = a new animal of the same species as
     * its parents and a random gender}
     */
    Animal reproduce(Animal other);

    /**
     * Creates and returns a string containing the names of all of the family
     * members of this.
     *
     * @return a String containing the names of the family members of this.
     * @ensures {@code family = a String with family member names}
     */
    String family();

}
