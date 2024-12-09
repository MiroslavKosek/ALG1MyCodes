package school.test.u2;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class P1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadejte pocet bodu");
        int n = sc.nextInt();
        
        double[][] points = new double[n][2];
        System.out.println("Zadejte body (x y)");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }
        
        System.out.println("Vzdalenosti mezi vsemi dvojicemi bodu:");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = calculateDistance(points[i], points[j]);
                System.out.printf("Vzdalenost mezi bodem %d a bodem %d: %.2f%n", i + 1, j + 1, distance);
            }
        }

        sc.close();
    }
    
    public static double calculateDistance(double[] point1, double[] point2) {
        double dx = point2[0] - point1[0];
        double dy = point2[1] - point1[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public static void swapByHorizontalAxe(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }
    }
    
    public static boolean testArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                return false;
            }
            if (array[i] % 7 != 0) {
                return false;
            }
        }
        return true;
    }
}
