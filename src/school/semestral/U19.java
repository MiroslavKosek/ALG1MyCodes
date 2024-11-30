package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U19 {
    
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
            
            System.out.println("Zadej matici");
            double[][] matrix = new double[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            
            System.out.println("");
            
            System.out.println("Usporadana matice");
            sortMatrix(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.printf("%10.2f", matrix[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public static void sortMatrix(double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        double maxVal = Double.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Math.abs(matrix[i][j]) > Math.abs(maxVal)) {
                    maxVal = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        
        if (maxRow != 0) {
            double[] tempRow = matrix[0];
            matrix[0] = matrix[maxRow];
            matrix[maxRow] = tempRow;
        }
        
        if (maxCol != 0) {
            for (int i = 0; i < n; i++) {
                double temp = matrix[i][0];
                matrix[i][0] = matrix[i][maxCol];
                matrix[i][maxCol] = temp;
            }
        }
    }
}
