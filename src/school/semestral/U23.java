package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U23 {
    
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
            
            System.out.println("Matice");
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            while(true) {
                System.out.println("Transformace");
                int t = sc.nextInt();

                if (t == 0) {
                    matrix = rotate(matrix, 0);
                } else if (t == -1) {
                    matrix = rotate(matrix, -90);
                } else if (t == 1) {
                    matrix = rotate(matrix, 90);
                } else {
                    break;
                }

                System.out.println("Rotovana matice");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.printf("%3d", matrix[i][j]);
                    }
                    System.out.println("");
                }
            }

            System.out.println("");
        } 
    }
    
    public static int[][] rotate(int[][] matrix, int angle) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated;

        if (angle == 90) {
            rotated = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rotated[m - 1 - j][i] = matrix[i][j];
                }
            }
        } else if (angle == -90) {
            rotated = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rotated[j][n - 1 - i] = matrix[i][j];
                }
            }
        } else {
            rotated = matrix;
        }

        return rotated;
    }
}
