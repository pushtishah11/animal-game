/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Animal.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */
import java.util.Random; 

/**
 * The abstract Animal class represents a generic animal.
 * 
 * Bugs:
 * @author pushti shah
 */
public abstract class Animal{
    private int age;
    private double health;
    private double strength;
    private static final String NAME = "Animal"; 

    /**
     * Default constructor for the Animal class.
     * Initializes age, health, and strength to default values.
     */
    protected Animal(){
        this.age = 0; 
        this.health = 0.0;
        this.strength = 0.0; 
    }

    /**
     * Parameterized constructor for the Animal class.
     * 
     * @param age      The age of the animal.
     * @param health   The health level of the animal.
     * @param strength The strength level of the animal.
     */

    protected Animal(int age, double health, double strength){
        this.age = age;
        this.health = health; 
        this.strength = strength; 

    }
    /**
     * Gets the age of the animal.
     * 
     * @return The age of the animal.
     */
    public int getAge(){
        return this.age ; 
    }

    /**
     * Gets the health of the animal.
     * 
     * @return The health of the animal.
     */
    public double getHealth(){
        return this.health;
    }


     /**
     * Gets the strength of the animal.
     * 
     * @return The strength of the animal.
     */
    public double getStrength(){
        return this.strength; 
    }

    /**
     * Gets the name of the species.
     * 
     * @return The name of the species.
     */
    public String getName(){
        return NAME; 
    }

    /**
     * Sets the health of the animal.
     * 
     * @param health The new health level of the animal.
     */
    public void setHealth(double health){
        this.health = health; 
    }


     /**
     * Sets the strength of the animal.
     * 
     * @param strength The new strength level of the animal.
     */
    public void setStrength(double strength){
        this.strength = strength; 
    }

    /**
     * Attacks another animal and reduces its health.
     * 
     * @param animal The animal to attack.
     * @return The value of the attack.
     */
    public double attack( Animal animal){
        Random random = new Random();
        double attackValue = 1 + (random.nextDouble() * (this.strength - 1));
        animal.setHealth(animal.getHealth() - attackValue);
        return attackValue;
    
    }
    
    /**
     * Checks if the given animal is of the same species.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    public abstract boolean sameSpecies(Animal animal);

    /**
     * Causes the animal to sleep and restore strength.
     */
    public abstract void sleep(); 

    /**
     * Checks if the animal is poisonous.
     * 
     * @return True if the animal is poisonous, false otherwise.
     */
    public abstract boolean isPoisonous();

    /**
     * Poisons another animal.
     * 
     * @return False, as the default behavior is not to poison.
     */
    public boolean poisonAnimal(){
        return false; 
    }

    /**
     * Returns a string representation of the animal.
     * 
     * @return A string representation of the animal.
     */
    @Override
    public String toString(){
        return "(Animal)" + " age: " + getAge() +
                "; health: " + getHealth() + "; strength: " + getStrength();


    }

    
}


