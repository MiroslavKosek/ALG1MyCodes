package school.test;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class AppMatrix {
    
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
            
            System.out.println("Zadej matici");
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int index = Tools.maxRowNotNull(matrix);
            int[] row = matrix[index];
            System.out.println("Index: " + index);
            System.out.println("Hodnoty:");
            for (int i = 0; i < row.length; i++) {
                System.out.printf("%3d", row[i]);
            }
            System.out.println("");
            System.out.println("");
        }
    }
    
}
