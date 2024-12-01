package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U22 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Rozmer matic");
            int n = sc.nextInt();
            
            if (n <= 0) {
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
            
           int[] transformations = findTransformations(matrix1, matrix2);
            boolean found = false;
            
            for (int transformation : transformations) {
                if (transformation == 0) {
                    System.out.println("Zrcadleni dle hlavni diagonaly");
                    found = true;
                }
                if (transformation == 1) {
                    System.out.println("Zrcadleni dle vedlejsi diagonaly");
                    found = true;
                }
                if (transformation == 2) {
                    System.out.println("Zrcadleni dle vertikalni osy");
                    found = true;
                }
                if (transformation == 3) {
                    System.out.println("Zrcadleni dle horizontalni osy");
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("Nenalezena transformace");
            }
            System.out.println("");
        }
    }
    
    public static int[] findTransformations(int[][] matrix1, int[][] matrix2) {
        int[] transformations = {-1, -1, -1, -1};
        int index = 0;
        
        if (isSymmetricByMain(matrix1, matrix2)) {
            transformations[index++] = 0;
        }
        
        if (isSymmetricBySide(matrix1, matrix2)) {
            transformations[index++] = 1;
        }
        
        if (isSymmetricByVertical(matrix1, matrix2)) {
            transformations[index++] = 2;
        }
        
        if (isSymmetricByHorizontal(matrix1, matrix2)) {
            transformations[index++] = 3;
        }
        
        return transformations;
    }
    
    public static boolean isSymmetricByVertical(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2 ; j++) {
                if (matrix1[i][j] != matrix2[i][n - 1 - j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isSymmetricByHorizontal(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n ; j++) {
                if (matrix1[i][j] != matrix2[n - 1 - i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isSymmetricByMain(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        for (int i = 0; i < n- 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (matrix1[i][j] != matrix2[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isSymmetricBySide(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (matrix1[i][j] != matrix2[n - 1 - j][n - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
