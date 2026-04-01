package animal;

import components.standard.Standard;
import components.tree.Tree;

/**
 * Animal kernel component with primary methods.
 *
 * @initially <pre>
 * ():
 *  ensures
 *      this.hunger = FULL and
 *      this.health = FULL and
 *      this.alive = true and
 *      this.species = "Unknown" and
 *      this.name = "Unknown" and
 *      this.gender = "Unknown"
 * (String s, String n, String g):
 *  ensures
 *      this.hunger = FULL and
 *      this.health = FULL and
 *      this.species = s and
 *      this.name = n and
 *      this.gender = g
 * </pre>
 */
public interface AnimalKernel extends Standard<Animal> {
    /**
     * Default highest integer representation of hunger and health.
     */
    int FULL = 100;

    /**
     * Lowest integer representation of hunger and health.
     */
    int EMPTY = 0;

    /**
     * Updates a given numerical stat, like hunger and health, based on the
     * inputted int, as well as whether the animal is living or not based on
     * those stats.
     *
     * @param stat
     *            The stat that will be updated
     * @param n
     *            The new value that the stat will be changed to
     * @requires 0 <= n <= 100 and stat.equals("hunger") ||
     *           stat.equals("health")
     * @ensures The given animal stat is updated to the correct value.
     */
    void update(String stat, int n);

    /**
     * Updates a given word stat, like species, name, or gender, given that the
     * current is unknown.
     *
     * @param stat
     *            The stat that will be updated
     * @param s
     *            The new word that the stat will be changed to
     * @requires (stat.equals("species") || stat.equals("name") ||
     *           stat.equals("gender")) && s.equals("Unknown")
     * @ensures The given animal stat is updated to the correct value.
     */
    void update(String stat, String s);

    /**
     * Returns a boolean containing whether the animal is living.
     *
     * @return true if alive, false if not.
     * @ensures {@code isAlive = this.isAlive}
     */
    boolean isAlive();

    /**
     * Returns the species of the animal.
     *
     * @return this animal's species.
     * @ensures {@code species = this.species}
     */
    String species();

    /**
     * Returns the name of the animal.
     *
     * @return this animal's name.
     * @ensures {@code name = this.name}
     */
    String name();

    /**
     * Returns the current family tree of this animal as a Tree<Animal>.
     *
     * @return a tree containing family members of the animal.
     * @ensures {@code familyTree = a Tree<Animal> with all family members of
     * this}
     */
    Tree<Animal> familyTree();

}
