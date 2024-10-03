package school.a1homework;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */

//Test: in: 1 1 1 out: 3661
//Test: in: 25 45 21 out: 92721
public class ToSeconds {
    
    public static void main(String[] args) {
        //Vstup
        Scanner sc = new Scanner(System.in);
        
//        int pocetHodin = 10;
//        int pocetMinut = 10;
//        int pocetSekund = 10;
        
        System.out.println("Zadej pocet hodin, minut a sekund:");
        int pocetHodin = sc.nextInt();
        int pocetMinut = sc.nextInt();
        int pocetSekund = sc.nextInt();
        
//        if (args.length != 3) {
//            System.out.println("Chyba: Zadej pocet hodin, minut a sekund jako argumenty.");
//            return;
//        }
//
//        int pocetHodin = Integer.parseInt(args[0]);
//        int pocetMinut = Integer.parseInt(args[1]);
//        int pocetSekund = Integer.parseInt(args[2]);
        
        //Zpracovani 
        int celkem = convertToSeconds(pocetHodin, pocetMinut, pocetSekund);
        
        //Vystup
        System.out.format("Čas závodníka je %d vteřin%n\n", celkem);
    }
    
    public static int convertToSeconds(int pocetHodin, int pocetMinut, int pocetSekund) {
        final int SEC_IN_HOUR = 3600;
        final int SEC_IN_MIN = 60;
        
        int celkem = (pocetHodin * SEC_IN_HOUR) + (pocetMinut * SEC_IN_MIN) + pocetSekund;
        
        return celkem;
    }
    
}
