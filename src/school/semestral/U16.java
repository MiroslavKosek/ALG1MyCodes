package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U16 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Pocet radku");
            int n = sc.nextInt();
            
            if (n <= 0) {
                break;
            }
            
            System.out.println("Pocet sloupcu");
            int m = sc.nextInt();
            
            System.out.println("Vysledna matice");
            int[][] matrix = generateMatrix(n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%3d", matrix[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static int[][] generateMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        int value = n * m;
        
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value--;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value--;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value--;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value--;
                }
                left++;
            }
        }
        
        return matrix;
    }
}
