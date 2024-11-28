package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U9 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while(again) {
            System.out.println("Zadej body primky:");
            double[][] straightLine = new double[2][2];
            for (int i = 0; i < 2; i++) {
                straightLine[i][0] = sc.nextDouble();
                straightLine[i][1] = sc.nextDouble();
            }
            
            System.out.println("Zadej pocet bodu:");
            int n = sc.nextInt();
            
            System.out.println("Zadej souradnice bodu:");
            double[][] points = new double[n][2]; 
            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextDouble();
                points[i][1] = sc.nextDouble();
            }
            
            System.out.println("Setridene body:");
            sortPointsByDistance(points, straightLine);
            for (int i = 0; i < n; i++) {
                System.out.println(points[i][0] + " " + points[i][1]);
            }
            System.out.println("");
            
            char input;
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            again = input != 'n';
        }
    }

    public static void sortPointsByDistance(double[][] points, double[][] straightLine) {
        int n = points.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (calculateDistance(points[i], straightLine) > calculateDistance(points[i + 1], straightLine)) {
                    double[] temp = points[i];
                    points[i] = points[i + 1];
                    points[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    
    public static double calculateDistance(double[] point, double[][] straightLine) {
        double x0 = point[0], y0 = point[1];
        double x1 = straightLine[0][0], y1 = straightLine[0][1];
        double x2 = straightLine[1][0], y2 = straightLine[1][1];

        double A = y2 - y1;
        double B = x1 - x2;
        double C = x2 * y1 - x1 * y2;

        return Math.abs(A * x0 + B * y0 + C) / Math.sqrt(A * A + B * B);
    }
}
