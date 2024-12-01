package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U25 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Rozmer matice");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Matice");
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            if (isLatin(matrix)) {
                System.out.println("Matice tvori latinsky ctverec");
            } else {
                System.out.println("Nejedna se o latinsky ctverec");
            }
            System.out.println("");
        }
    }
    
    public static boolean isLatin(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value < 1 || value > n || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int value = matrix[i][j];
                if (value < 1 || value > n || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        return true;
    }
}
