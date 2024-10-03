/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Panda.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

import java.util.Random; 

/**
 * The Panda class represents a panda which is an animal and a herbivore.
 * 
 * Bugs:
 * @author Pushti Shah
 */

public class Panda extends Animal implements Herbivore{
    private static final String NAME ="Panda";

    /**
     * Default constructor for the Panda class.
     */
    public Panda(){
        super();
    }

    /**
     * Parameterized constructor for the Panda class.
     * 
     * @param age      The age of the panda.
     * @param health   The health level of the panda.
     * @param strength The strength level of the panda.
     */
    public Panda(int age, double health, double strength){
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
     * Checks if the given animal is of the same species as this panda.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    @Override
    public boolean sameSpecies(Animal animal){
        return animal instanceof Panda 
            && ((Panda) animal).getName().equals(NAME);
    }

    /**
     * Increases the panda's strength when it sleeps.
     */
    @Override
    public void sleep(){
        setStrength(getStrength()*1.4); 
    }

    /**
     * Checks if the panda is poisonous.
     * 
     * @return False, as pandas are not poisonous.
     */
    @Override
    public boolean isPoisonous(){
        return false;
    }

    /**
     * The panda eats a plant and gains strength.
     */
    public void eatPlant(){
        Random random = new Random();
        double strengthIncrease = random.nextDouble() * 50;
        setStrength(getStrength() + strengthIncrease);

    }

    /**
     * Returns a string representation of the panda, including its species.
     * 
     * @return A string representation of the panda.
     */
    @Override
    public String toString() {
        return super.toString() + "; species: Panda";
    }
}