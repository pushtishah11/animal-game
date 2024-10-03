
/* 
 Title : CSE 11
 Main Class File: Assignment8.java
 File: Assignment8.java
 Quarter: CSE 11 Spring 2024
 Author: Pushti Shah 
 Email: pushah@ucsd.edu
 Instructor's Name: Professor Ochoa
 */

/**
 * The Assignment8 class contains unit tests for the functionality of the 
 * AnimalActivities class.
 * 
 * Bugs:
 * @author Pushti Shah
 * 
 */

public class Assignment8 {
    /**
     * Main method to execute the unit tests.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("All tests passed: " + unitTests());
    }

    /**
     * Executes unit tests for the AnimalActivities class.
     * 
     * @return true if all tests pass, false otherwise.
     */
    public static boolean unitTests() {
        boolean allTestsPassed = true;

        // Test 1: sleep()
        Panda panda = new Panda(10, 50, 20);
        panda.sleep();
        if (panda.getStrength() != 28) {
            System.out.println("Test 1 failed: sleep()");
            allTestsPassed = false;
        }

        // Test 2: eatAnimal()
        Wolf wolf1 = new Wolf(8, 60, 30);
        Wolf wolf2 = new Wolf(5, 50, 20);
        wolf1.eatAnimal(wolf2);
        if (wolf1.getStrength() <= 30) {
            System.out.println("Test 2 failed: eatAnimal()");
            allTestsPassed = false;
        }

        // Test 3: poisonAnimal()
        Toad toad = new Toad(6, 40, 15);
        boolean poisoned = false;
        for (int i = 0; i < 100; i++) {
            poisoned = toad.poisonAnimal();
            if (poisoned) {
                break;
            }
        }
        if (!poisoned) {
            System.out.println("Test 3 failed: poisonAnimal()");
            allTestsPassed = false;
        }

        // Test 4: reproduce()
        Wolf wolf3 = new Wolf(6, 100, 40);
        Wolf wolf4 = new Wolf(7, 90, 50);
        Animal babyWolf = AnimalActivities.reproduce(wolf3, wolf4);
        if (!(babyWolf instanceof Wolf) || babyWolf.getAge() != 0 ||
             babyWolf.getHealth() != 100 || babyWolf.getStrength() != 22.5) {
            System.out.println("Test 4 failed: reproduce()");
            allTestsPassed = false;
        }

        // Test 5: reproduce() - edge case
        Wolf wolf6 = new Wolf(5,100,30);
        Cobra cobra2 = new Cobra(5,90,50);
        Animal babyAnimal = AnimalActivities.reproduce(wolf6, cobra2);
        if(!(babyAnimal == null)){
            System.out.println("Test 5 failed: Animals" +
               "of Different Type reproduce()");
        }
        
        // Test 6: Edge case for reproduce() - Animals not old enough
        Wolf youngWolf1 = new Wolf(3, 90, 30);
        Wolf youngWolf2 = new Wolf(4, 80, 20);
        Animal babyYoungWolves = 
            AnimalActivities.reproduce(youngWolf1, youngWolf2);
        if(!(babyYoungWolves == null)){
            System.out.println("Test 6 failed: Animals not old " +
                "enough reproduce");
        }

        // Test 7: fight()
        Wolf wolf5 = new Wolf(8, 100, 50);
        Panda panda2 = new Panda(8, 100, 10);
        int result = AnimalActivities.fight(wolf5, panda2);
        if (result != 1) {
            System.out.println("Test 7 failed: fight()");
            allTestsPassed = false;
        }

        return allTestsPassed;
    }
}
