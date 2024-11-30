package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U17 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Pocet radku");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Pocet sloupcu");
            int m = sc.nextInt();
            
            System.out.println("Velikost bloku");
            int k = sc.nextInt();
            
            System.out.println("Vysledna matice");
            int[][] matrix = generateMatrix(n, m, k);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%3d", matrix[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static int[][] generateMatrix(int n, int m, int k) {
        int[][] matrix = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int blockRow = i / k;
                int blockCol = j / k;
                
                matrix[i][j] = (blockRow + blockCol) % 2;
            }
        }
        
        return matrix;
    }
}
