package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U8 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while(again) {
            System.out.println("Zadej pocet bodu:");
            int n = sc.nextInt();
            
            System.out.println("Zadej souradnice bodu:");
            double[][] points = new double[n][3];
            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextDouble();
                points[i][1] = sc.nextDouble();
                points[i][2] = sc.nextDouble();
            }
            
            System.out.println("Setridene body");
            sort(points);
            for (int i = 0; i < n; i++) {
                System.out.print(points[i][0] + " " + points[i][1] + " " + points[i][2] + "\n");
            }
            
            char input = 'y';
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            
            again = input != 'n';
        }
    }
    
    public static void sort(double[][] points) {
        int n = points.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (distanceFromOrigin(points[i]) > distanceFromOrigin(points[i + 1])) {
                    double[] temp = points[i];
                    points[i] = points[i + 1];
                    points[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    
    public static double distanceFromOrigin(double[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2) + Math.pow(point[2], 2));
    }
}
