
package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U6 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Stupen prvního polynomu:");
            int s1 = sc.nextInt();
            if (s1 < 0) {
                break;
            }

            System.out.println("Koeficienty prvniho polynomu:");
            int[] k1 = new int[s1 + 1];
            for (int i = 0; i <= s1; i++) {
                k1[s1 - i] = sc.nextInt();
            }

            System.out.println("Stupen druheho polynomu:");
            int s2 = sc.nextInt();

            System.out.println("Koeficienty druheho polynomu:");
            int[] k2 = new int[s2 + 1];
            for (int i = 0; i <= s2; i++) {
                k2[s2 - i] = sc.nextInt();
            }
            
            System.out.println("První polynom: " + polynomToString(k1));
            System.out.println("Druhý polynom: " + polynomToString(k2));
            int[] sum = polynomSum(k1, k2);
            System.out.println("Součet polynomů: " + polynomToString(sum));
            int[] prod = polynomProd(k1, k2);
            System.out.println("Součin polynomů: " + polynomToString(prod));
        }
    }
    
    public static int[] polynomSum(int[] k1, int[] k2) {
        int max = Math.max(k1.length, k2.length);
        int[] sum = new int[max];
        
        for (int i = 0; i < max; i++) {
            int koef1 = (i < k1.length) ? k1[i] : 0;
            int koef2 = (i < k2.length) ? k2[i] : 0;
            sum[i] = koef1 + koef2;
        }
        
        return sum;
    }
    
    public static int[] polynomProd(int[] k1, int[] k2) {
        int[] prod = new int[k1.length + k2.length - 1];

        for (int i = 0; i < k1.length; i++) {
            for (int j = 0; j < k2.length; j++) {
                prod[i + j] += k1[i] * k2[j];
            }
        }

        return prod;
    }
    
    public static String polynomToString(int[] k) {
        StringBuilder sb = new StringBuilder();
        int stupen = k.length - 1;

        for (int i = stupen; i >= 0; i--) {
            int koef = k[i];
            if (koef == 0) {
                continue;
            }

            if (sb.length() > 0 && koef > 0) {
                sb.append(" + ");
            } else if (koef < 0) {
                sb.append(" - ");
                koef = -koef;
            }

            if (i > 0) {
                if (koef != 1) {
                    sb.append(koef);
                }
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            } else {
                sb.append(koef);
            }
        }

        return sb.length() > 0 ? sb.toString() : "0";
    }
}
