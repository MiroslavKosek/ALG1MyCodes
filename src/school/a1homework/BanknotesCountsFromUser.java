package school.a1homework;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class BanknotesCountsFromUser {
    
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        System.out.print("Zadejte castku v Kč: ");
        int amount = sc.nextInt();

        //processing
        int[] values = {100, 50, 20, 10, 5, 2, 1};
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = amount / values[i];
            amount %= values[i];
        }

        //output
        System.out.println("Vycetka platidel:");
        for (int i = 0; i < values.length; i++) {
            if (numbers[i] > 0) {
                System.out.println(values[i] + " Kc: " + numbers[i] + " ks");
            }
        }
    }
    
}
