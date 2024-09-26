package school.a1homework;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class ToSecondsFromUser {
    
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte pocet hodin:");
        int hours = sc.nextInt();

        System.out.println("Zadejte pocet minut:");
        int minutes = sc.nextInt();

        System.out.println("Zadejte pocet sekund:");
        int seconds = sc.nextInt();

        //processing
        int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;

        //output
        System.out.println("Celkovy cas v sekundach: " + totalSeconds);
    }
    
}
