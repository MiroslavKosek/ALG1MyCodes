package school.semestral;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Miroslav Košek
 */
public class U12 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while(again) {
            System.out.println("Dolni mez intervalu:");
            int a = sc.nextInt();
            
            System.out.println("Horni mez intervalu:");
            int b = sc.nextInt();
            
            System.out.println("Pocet generovanych hodnot:");
            int n = sc.nextInt();
            
            System.out.println("Delka kroku pro vytvareni dvojic:");
            int k = sc.nextInt();
            
            int[] array = generateArray(a, b, n);
            
            System.out.format("Vypocteny korelacni koeficient ma hodnotu %.3f\n", coeficient(array, k));
            System.out.println("");
            
            char input;
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            again = input != 'n';
        }
    }
    
    public static double coeficient(int[] a, int k) {
        int length = a.length - k;
        
        int sumX = 0;
        int sumY = 0;
        
        for (int i = 0; i < length; i++) {
            sumX += a[i];
            sumY += a[i + k];
        }
        
        double meanX = sumX / length;
        double meanY = sumY / length;

        double numerator = 0;
        double denominatorX = 0;
        double denominatorY = 0;
        
        for (int i = 0; i < length; i++) {
            double x = a[i] - meanX;
            double y = a[i + k] - meanY;

            numerator += x * y;
            denominatorX += x * x;
            denominatorY += y * y;  
        }
        
        double denominator = Math.sqrt(denominatorX * denominatorY);
        return denominator == 0 ? 0 : numerator / denominator;
    }
    
    public static int[] generateArray(int a, int b, int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(a, b + 1);
            array[i] = randomNum;
        }
        return array;
    }
}
