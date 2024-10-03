/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Cobra.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

import java.util.Random;

/**
 * The Cobra class represents a cobra which is an animal and a carnivore.
 * 
 * Bugs
 * @author Pushti Shah
 */
public class Cobra extends Animal implements Carnivore{
    private static final String NAME = "Cobra"; 

    /**
     * Default constructor for the Cobra class.
     */
    public Cobra(){
        super();
    }

    /**
     * Parameterized constructor for the Cobra class.
     * 
     * @param age      The age of the cobra.
     * @param health   The health level of the cobra.
     * @param strength The strength level of the cobra.
     */
    public Cobra(int age, double health, double strength){
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
     * Checks if the given animal is of the same species as this cobra.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    @Override
    public boolean sameSpecies(Animal animal){
        return animal instanceof Cobra 
            && ((Cobra) animal).getName().equals(NAME);
    }

    /**
     * Increases the cobra's strength when it sleeps.
     */
    @Override
    public void sleep(){
        setStrength(getStrength()*1.7); 
    }


    /**
     * Checks if the cobra is poisonous.
     * 
     * @return True, as cobras are poisonous.
     */
    @Override
    public boolean isPoisonous(){
        return true;
    }

    /**
     * The cobra eats another animal and gains strength.
     * 
     * @param animal The animal to be eaten.
     */
    public void eatAnimal (Animal animal){
        setStrength(getStrength() + animal.getStrength() * 0.90);
    }

    /**
     * Poisons another animal with a certain probability.
     * 
     * @return True if the cobra successfully poisons another 
     * animal, false otherwise.
     */
    @Override
    public boolean poisonAnimal(){
        Random random = new Random();
        return random.nextDouble() < 0.80;
    }

    /**
     * Returns a string representation of the cobra, including its species.
     * 
     * @return A string representation of the cobra.
     */
    @Override
    public String toString(){
        return super.toString() + "; species: Cobra";

    }

}