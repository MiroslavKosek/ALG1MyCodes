package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U1 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = 1;
        
        do {
            System.out.println("Zadej pocet:");
            n = sc.nextInt();
            
            if (n < 1) {
                break;
            }
            
            System.out.println("Zadej posloupnost:");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            System.out.println("Nejdelsi setridena cast delky " + sortedLength(a));
            System.out.println("Zacatek " + sortedStartingIndex(a) + ". prvek");
            System.out.println("");
            
        } while (n >= 1);
    }
    
    public static int sortedLength(int[] a) {
        int maxLength = 1;
        int length = 1;
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                length++;
            }
            else {
                if (maxLength < length) {
                    maxLength = length;
                }
                length = 1;
            }
        }
        
        if (maxLength < length) {
            maxLength = length;
        }
        
        return maxLength;
    }
    
    public static int sortedStartingIndex(int[] a) {
        int index = 0;
        int maxIndex = 0;
        int maxLength = 1;
        int length = 1;
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                length++;
            }
            else {
                if (maxLength < length) {
                    maxLength = length;
                    maxIndex = index;
                }
                length = 1;
                index = i + 1;
            }
        }
        
        if (maxLength < length) {
            maxLength = length;
            maxIndex = index;
        }
        
        return maxIndex + 1;
    }
}
