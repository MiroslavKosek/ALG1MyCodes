package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U20 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Rozmer matice");
            int n = sc.nextInt();
            
            if (n <= 0) {
                break;
            }
            
            System.out.println("Zadej matici");
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            if (isSymmetricByValue(matrix)) {
                System.out.println("Matice je symetricka hodnotami");
            } else if(isSymmetricByStructure(matrix)) {
                System.out.println("Matice je symetricka strukturou");
            } else {
                System.out.println("Matice je nesymetricka");
            }
            System.out.println("");
        }
    }
    
    public static boolean isSymmetricByValue(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isSymmetricByStructure(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.signum(matrix[i][j]) != Math.signum(matrix[j][i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
