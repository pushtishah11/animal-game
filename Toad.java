/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Toad.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */


import java.util.Random; 

/**
 * The Toad class represents a toad which is an animal and a carnivore.
 * 
 * Bugs:
 * @author pushti shah
 */
public class Toad extends Animal implements Carnivore{
    private static final String NAME = "Toad";

    /**
     * Default constructor for the Toad class.
     */
    public Toad(){
        super();
    }

    /**
     * Parameterized constructor for the Toad class.
     * 
     * @param age      The age of the toad.
     * @param health   The health level of the toad.
     * @param strength The strength level of the toad.
     */
    public Toad(int age, double health, double strength){
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
     * Checks if the given animal is of the same species as this toad.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    @Override
    public boolean sameSpecies(Animal animal){
        return animal instanceof Toad && 
            ((Toad) animal).getName().equals(NAME);
    }

    /**
     * Increases the toad's strength when it sleeps.
     */
    @Override
    public void sleep(){
        setStrength(getStrength() * 1.2);
    }

    /**
     * Checks if the toad is poisonous.
     * 
     * @return True, as toads are poisonous.
     */
    @Override
    public boolean isPoisonous(){
        return true;  
    }

    /**
     * The toad eats another animal and gains strength.
     * 
     * @param animal The animal to be eaten.
     */
    public void eatAnimal(Animal animal){
        Random random = new Random();
        int bugsEaten = random.nextInt(11); // Random number between 0 and 10
        double strengthIncrease = bugsEaten * (animal.getStrength() * 0.30);
        setStrength(getStrength() + strengthIncrease);
    }


    /**
     * Poisons another animal with a certain probability.
     * 
     * @return True if the toad successfully poisons another animal, 
     * false otherwise.
     */
    @Override
    public boolean poisonAnimal(){
        Random random = new Random();
        return random.nextDouble() < 0.30;
    }

    /**
     * Returns a string representation of the toad, including its species.
     * 
     * @return A string representation of the toad.
     */
    @Override
    public String toString(){
        return super.toString() + "; species: Toad";
    }
}