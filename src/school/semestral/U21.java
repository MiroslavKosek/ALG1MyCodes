package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U21 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Rozmer matic");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Prvni matice");
            int[][] matrix1 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix1[i][j] = sc.nextInt();
                }
            }
            
            System.out.println("Druha matice");
            int[][] matrix2 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix2[i][j] = sc.nextInt();
                }
            }
            
            int[] rotations = findRotations(matrix1, matrix2);
            boolean found = false;
            
            for (int rotation : rotations) {
                if (rotation != -1) {
                    System.out.println("Rotace " + rotation);
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("Neni rotace");
            }
            System.out.println("");
        }
    }
    
    public static int[] findRotations(int[][] matrix1, int[][] matrix2) {
        int[] rotations = {-1, -1, -1, -1};
        int index = 0;
        
        if (areEqual(matrix1, matrix2)) {
            rotations[index++] = 0;
        }
        
        int[][] rotated90 = rotate90(matrix1);
        if (areEqual(rotated90, matrix2)) {
            rotations[index++] = 90;
        }
        
        int[][] rotated180 = rotate90(rotated90);
        if (areEqual(rotated180, matrix2)) {
            rotations[index++] = 180;
        }
        
        int[][] rotated270 = rotate90(rotated180);
        if (areEqual(rotated270, matrix2)) {
            rotations[index++] = 270;
        }
        
        return rotations;
    }
    
    public static boolean areEqual(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - j][i] = matrix[i][j];
            }
        }
        return rotated;
    }
}
