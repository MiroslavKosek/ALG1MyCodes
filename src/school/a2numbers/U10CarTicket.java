package school.a2numbers;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U10CarTicket {
    
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadej maximalni povolenou rychlost v danem useku (km/h):");
        double maximalniRychlost = scanner.nextDouble();

        System.out.println("Zadej delku useku (km): ");
        double delkaUseku = scanner.nextDouble();

        System.out.println("Zadej cas prujezdu zacatkem useku (hh mm ss set):");
        int startHodiny = scanner.nextInt();
        int startMinity = scanner.nextInt();
        int startSekundy = scanner.nextInt();
        int startSetiny = scanner.nextInt();

        System.out.println("Zadej cas prujezdu koncem useku (hh mm ss set):");
        int stopHodiny = scanner.nextInt();
        int stopMinuty = scanner.nextInt();
        int stopSekundy = scanner.nextInt();
        int stopSetiny = scanner.nextInt();

        //processing
        double startCas = startHodiny * 3600 + startMinity * 60 + startSekundy + startSetiny / 1000.0;
        double stopCas = stopHodiny * 3600 + stopMinuty * 60 + stopSekundy + stopSetiny / 1000.0;

        double cas = stopCas - startCas;
        double prumernaRychlost = (delkaUseku / cas) * 3600;

        //output
        System.out.printf("Prumerna rychlost vozidla: %.2f km/h\n", prumernaRychlost);

        if (prumernaRychlost > maximalniRychlost) {
            double prekrocenaRychlost = prumernaRychlost - maximalniRychlost;
            System.out.format("Rychlost byla prekrocena o: %.2f km/h\n", prekrocenaRychlost);
            
            int pokuta = prekrocenaRychlost <= 20 ? 1000 : 2500;
            System.out.format("Pokuta za prekroceni rychlosti je: %d Kc\n", pokuta);
        }
        else {
            System.out.println("Rychlost nebyla prekrocena.");
        }
    }
    
}
