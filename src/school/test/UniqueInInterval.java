package school.test;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class UniqueInInterval {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int DELTA = 10;
        int[] a = new int[DELTA];
        int n = 0;
        System.out.println("Zadej posloupnost");
        while(true) {
            if (n == DELTA - 1) {
                int[] b = new int[n + DELTA];
                System.arraycopy(a, 0, b, 0, n + 1);
                a = b;
                b = null;
            }
            
            int x = sc.nextInt();
            if (x < 0) {
                break;
            }
            a[n] = x;
            n++;
        }
        
        for (int i = 0; i < n + 1; i++) {
            System.out.println(a[i]);
        }
    }
}
