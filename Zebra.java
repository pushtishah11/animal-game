/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Zebra.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

import java.util.Random; 

/**
 * The Zebra class represents a zebra which is an animal and a herbivore.
 * 
 * Bugs:
 * @author Pushti Shah
 */

public class Zebra extends Animal implements Herbivore{
    private static final String NAME ="Zebra";

    /**
     * Default constructor for the Zebra class.
     */
    public Zebra(){
        super();
    }

    /**
     * Parameterized constructor for the Zebra class.
     * 
     * @param age      The age of the zebra.
     * @param health   The health level of the zebra.
     * @param strength The strength level of the zebra.
     */
    public Zebra(int age, double health, double strength){
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
     * Checks if the given animal is of the same species as this zebra.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    @Override
    public boolean sameSpecies(Animal animal){
        return animal instanceof Zebra 
            && ((Zebra) animal).getName().equals(NAME);
    }

    /**
     * Increases the zebra's strength when it sleeps.
     */
    @Override
    public void sleep(){
        setStrength(getStrength()*1.3); 
    }

     /**
     * Checks if the zebra is poisonous.
     * 
     * @return False, as zebras are not poisonous.
     */
    @Override
    public boolean isPoisonous(){
        return false;
    }

    /**
     * The zebra eats a plant and gains strength.
     */
    public void eatPlant(){
        Random random = new Random();
        double strengthIncrease = random.nextDouble() * 40;
        setStrength(getStrength() + strengthIncrease);
    }


    /**
     * Returns a string representation of the zebra, including its species.
     * 
     * @return A string representation of the zebra.
     */
    @Override
    public String toString() {
        return super.toString() + "; species: Zebra";
    }

}