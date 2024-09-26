package school.a1introduction;

public class FarmFromArgv {
    public static void main(String[] args) {
        //input
        if (args.length != 2) {
            System.out.println("Chyba: Zadejte pocet hus a pocet kraliku jako argumenty.");
            return;
        }
        
        int numberOfGeese = Integer.parseInt(args[0]);
        int numberOfRabbits = Integer.parseInt(args[1]);
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
