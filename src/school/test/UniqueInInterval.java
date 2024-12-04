package school.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class UniqueInInterval {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Zadej posloupnost");
        
        while(true) {
            int x = sc.nextInt();
            if (x < 0) {
                break;
            }
            numbers.add(x);
        }
        
        System.out.println("Zadej dolni hranici");
        int a = sc.nextInt();
        
        System.out.println("Zadej horni hranici");
        int b = sc.nextInt();
        
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (number >= a && number <= b) {
                uniqueNumbers.add(number);
            }
        }

        System.out.println("V posloupnosti " + numbers + " v intervalu " + a + " až " + b + ": " + uniqueNumbers.size() + " čísla.");
    }
}
