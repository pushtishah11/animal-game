/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: AnimalActivities.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

/**
 * The AnimalActivities class simulates activities 
 * involving animals, such as fighting and reproduction.
 * 
 * Bugs:
 * 
 * @author Pushti Shah
 */
public class AnimalActivities {
    // Necessary constants
    private final static int NUM_ANIMALS = 6;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";
    
    // Private constructor to prevent instantiation
    private AnimalActivities() {}

    // Fight method
    public static int fight(Animal animal1, Animal animal2) {
        boolean animal1Poisoned = false;
        boolean animal2Poisoned = false;

        // Check if either animal is poisonous
        if (animal1.isPoisonous()) {
            animal2Poisoned = animal1.poisonAnimal();
        }
        if (animal2.isPoisonous()) {
            animal1Poisoned = animal2.poisonAnimal();
        }

        int round = 0;
        
        // Fight loop
        while (animal1.getHealth() > 0 && animal2.getHealth() > 0) {
            printRound(round);
            printBothAnimals(animal1, animal2);

            double damage1 = animal1.attack(animal2);
            double damage2 = animal2.attack(animal1);

            printAttack(LEFT, damage1);
            printAttack(RIGHT, damage2);

            round++;
        }

        printFinalStats(animal1, animal2, animal1Poisoned || animal2Poisoned);

        // Determine the outcome
        if (animal1.getHealth() <= 0 && animal2.getHealth() <= 0) {
            printTieGame();
            return 0;
        } else if (animal1.getHealth() > 0) {
            if (animal1Poisoned) {
                printTieGame();
                return 0;
            }
            if (animal1 instanceof Carnivore) {
                ((Carnivore) animal1).eatAnimal(animal2);
            } else if (animal1 instanceof Herbivore) {
                ((Herbivore) animal1).eatPlant();
            }
            printWinner(LEFT);
            return 1;
        } else {
            if (animal2Poisoned) {
                printTieGame();
                return 0;
            }
            if (animal2 instanceof Carnivore) {
                ((Carnivore) animal2).eatAnimal(animal1);
            } else if (animal2 instanceof Herbivore) {
                ((Herbivore) animal2).eatPlant();
            }
            printWinner(RIGHT);
            return 2;
        }
    }

    public static Animal reproduce(Animal animal1, Animal animal2) {
        // Check if both animals are older than 5 and are of the same species
        if (animal1.getAge() > 5 && animal2.getAge() > 5 
            && animal1.sameSpecies(animal2)) {
            int age = 0;
            double health = 100;
            double strength = (animal1.getStrength() + 
                animal2.getStrength()) / 4; // Half of the average strength

            // Return a new animal based on the species
            if (animal1 instanceof Wolf) {
                return new Wolf(age, health, strength);
            } else if (animal1 instanceof Toad) {
                return new Toad(age, health, strength);
            } else if (animal1 instanceof Panda) {
                return new Panda(age, health, strength);
            }
        }
        // If conditions are not met, return null
        return null;
    }

    /* Below are helper methods to make fight() work */
    public static void printBothAnimals(Animal animal1, Animal animal2) {
        int ageSpacing = calcSpacing(Integer.toString(animal1.getAge()));
        int healthSpacing = calcSpacing(String.format("%.2f",
            animal1.getHealth()));
        int strSpacing = calcSpacing(String.format("%.2f", 
            animal1.getStrength()));
        int animalSpacing = calcSpacing(animal1.getName());
        String str = String.format("(%s) %s  (%s)\n" +
                "----------" + "            " + "----------\n" +
                "A: %d %s A: %d\n" +
                "H: %.2f %s H: %.2f\n" +
                "S: %.2f %s S: %.2f\n", animal1.getName(),
                " ".repeat(animalSpacing), animal2.getName(),
                animal1.getAge(), " ".repeat(ageSpacing), animal2.getAge(),
                animal1.getHealth(), " ".repeat(healthSpacing),
                    animal2.getHealth(),
                animal1.getStrength(), " ".repeat(strSpacing), animal2.
                    getStrength()
        );
        System.out.println(str);
    }

    public static int calcSpacing(String str) {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) {
            return 0;
        }
        return spacing;
    }

    public static void printRound(int round) {
        System.out.println();
        System.out.println("Round " + round + ":");
    }

    public static void printAttack(String side, double damage) {
        System.out.printf("%s does %.2f damage!\n", side, damage);
    }

    public static void printFinalStats(Animal animal1, Animal animal2,
        boolean poisoned) {
        System.out.println();

        printBothAnimals(animal1, animal2);
        if (poisoned) {
            System.out.println("An animal was poisoned.");
        }
    }

    public static void printTieGame() {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both animals died!");
    }

    public static void printWinner(String side) {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " animal wins!");
    }
}
