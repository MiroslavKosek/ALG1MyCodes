package school.test.u2;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class P2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadejte rozmery matice (n m)");
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        double[][] matrix = new double[n][m];
        System.out.println("Zadejte prvky matice (nadmorské vysky):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        
        int peakCount = 0;
        double maxHeight = Double.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                double currentHeight = matrix[i][j];
                maxHeight = Math.max(maxHeight, currentHeight);
                if (isPeak(matrix, i, j)) {
                    peakCount++;
                }
            }
        }

        System.out.println("Pocet vrcholu: " + peakCount);
        System.out.println("Maximalni vyska: " + maxHeight);

        sc.close();
    }
    
    public static boolean isPeak(double[][] matrix, int x, int y) {
        double currentHeight = matrix[x][y];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (matrix[x + i][y + j] + 5 > currentHeight) {
                    return false;
                }
            }
        }
        return true;
    }
}
