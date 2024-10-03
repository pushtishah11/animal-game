/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Leopard.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

/**
 * The Leopard class represents a leopard which is an animal and a carnivore.
 * 
 * Bugs:
 * @author pushti shah
 */
public class Leopard extends Animal implements Carnivore  {
    private static final String NAME ="Leopard";

    /**
     * Default constructor for the Leopard class.
     */
    public Leopard(){
        super();
    }


    
    /**
     * Parameterized constructor for the Leopard class.
     * 
     * @param age      The age of the leopard.
     * @param health   The health level of the leopard.
     * @param strength The strength level of the leopard.
     */
    public Leopard(int age, double health, double strength){
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
     * Checks if the given animal is of the same species as this leopard.
     * 
     * @param animal The animal to compare.
     * @return True if the animal is of the same species, false otherwise.
     */
    @Override
    public boolean sameSpecies(Animal animal){
        return animal instanceof Leopard && 
            ((Leopard) animal).getName().equals(NAME);
    }


    /**
     * Increases the leopard's strength when it sleeps.
     */
    @Override
    public void sleep(){
        setStrength(getStrength()*1.5);
    }

    /**
     * Checks if the leopard is poisonous.
     * 
     * @return False, as leopards are not poisonous.
     */
    @Override
    public boolean isPoisonous(){
        return false;
    }

    /**
     * The leopard eats another animal and gains strength.
     * 
     * @param animal The animal to be eaten.
     */
    public void eatAnimal(Animal animal){
        setStrength(getStrength() + animal.getStrength() * 0.55);
    }

    /**
     * Returns a string representation of the leopard, including its species.
     * 
     * @return A string representation of the leopard.
     */
    public String toString(){
        return super.toString() + "; species: Wolf";
    }
}


