/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Wolf.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

/**
 * The Wolf class represents a wolf which is an animal and a carnivore.
 * 
 * Bugs:
 * @author pushti shah 
 */
public class Wolf extends Animal implements Carnivore{
    private static final String NAME = "Wolf";

    /**
     * Default constructor for the Wolf class.
     */
    public Wolf(){
        super();
    }

    /**
     * Parameterized constructor for the Wolf class.
     * 
     * @param age      The age of the wolf.
     * @param health   The health level of the wolf.
     * @param strength The strength level of the wolf.
     */
    public Wolf(int age, double health, double strength){
        super(age,health,strength);
    }

    /**
     * Gets the name of the species.
     * 
     * @return The name of the species.
     */
    @Override
    public String getName(){
        return NAME; 

    }

    /**
     * Checks if the given animal is of the same species as this wolf.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    @Override
    public boolean sameSpecies (Animal animal){
        return animal instanceof Wolf && ((Wolf) animal).getName().equals(NAME);
    }

    /**
     * Increases the wolf's strength when it sleeps.
     */
    @Override
    public void sleep(){
        setStrength(getStrength()*1.6); 
    }

    /**
     * Checks if the wolf is poisonous.
     * 
     * @return False, as wolves are not poisonous.
     */
    @Override
    public boolean isPoisonous(){
        return false;
    }

    /**
     * The wolf eats another animal and gains strength.
     * 
     * @param animal The animal to be eaten.
     */
    public void eatAnimal (Animal animal){
        setStrength(getStrength() + animal.getStrength() * 0.60);
    }

    /**
     * Returns a string representation of the wolf, including its species.
     * 
     * @return A string representation of the wolf.
     */
    @Override
    public String toString(){
        return super.toString() + "; species: Wolf";

    }

}