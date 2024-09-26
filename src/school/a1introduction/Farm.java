package school.a1introduction;

public class Farm {
    public static void main(String[] args) {
        //input
        int numberOfGeese = 5;
        int numberOfRabbits = 4;
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
