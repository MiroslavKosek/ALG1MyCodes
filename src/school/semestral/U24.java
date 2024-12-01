package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U24 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Rozmer matice");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Zadej matici");
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int[][] reducedMatrix = reduce(matrix);
            System.out.printf("Redukovana matice (%d x %d)\n", reducedMatrix.length, reducedMatrix.length);
            for (int i = 0; i < reducedMatrix.length; i++) {
                for (int j = 0; j < reducedMatrix.length; j++) {
                    System.out.printf("%3d", reducedMatrix[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static int[][] reduce(int[][] matrix) {
        int n = matrix.length;

        while (true) {
            boolean found = false;
            int rowToRemove = -1;
            int colToRemove = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] != 0 && isUniqueInRowAndColumn(matrix, i, j)) {
                        found = true;
                        rowToRemove = i;
                        colToRemove = j;
                        break;
                    }
                }
                if (found) break;
            }

            if (!found) {
                break;
            }

            matrix = removeRowAndColumn(matrix, rowToRemove, colToRemove);
            n--;
        }

        return matrix;
    }
    
    public static boolean isUniqueInRowAndColumn(int[][] matrix, int row, int col) {
        int n = matrix.length;

        for (int j = 0; j < n; j++) {
            if (j != col && matrix[row][j] != 0) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != row && matrix[i][col] != 0) {
                return false;
            }
        }

        return true;
    }

    public static int[][] removeRowAndColumn(int[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length;
        int[][] reducedMatrix = new int[n - 1][n - 1];
        int newRow = 0, newCol;

        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;

            newCol = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;

                reducedMatrix[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }

        return reducedMatrix;
    }
}
