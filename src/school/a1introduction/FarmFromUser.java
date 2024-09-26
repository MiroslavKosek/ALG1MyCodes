package school.a1introduction;

import java.util.Scanner;

public class FarmFromUser {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte pocet hus:");
        int numberOfGeese = sc.nextInt();

        System.out.println("Zadejte pocet kraliku:");
        int numberOfRabbits = sc.nextInt();
        final int NUMBER_OF_LEGS_PER_GOOSE = 2;
        final int NUMBER_OF_LEGS_PER_RABBIT = 4;
        
        //processing
        int numberOfAnimals = numberOfGeese + numberOfRabbits;
        int numberOfLegs = numberOfGeese * NUMBER_OF_LEGS_PER_GOOSE + numberOfRabbits * NUMBER_OF_LEGS_PER_RABBIT;
        
        //output
        System.out.println("Pocet hus: " + numberOfGeese);
        System.out.println("Pocet kraliku: " + numberOfRabbits);
        System.out.println("Na farme je " + numberOfAnimals + " zvirat a maji " + numberOfLegs + " nohou.");
    }
}
