package school.a72darray;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */

/*
Testy:
rozmer: 3x3
0,2 0,5 0,3
0,4 0,4 0,2
0,1 0,7 0,2
je po radcich
rozmer: 2x2
0,3 -0,1
0,5 0,5
neni po radcich
rozmer: 3x3
0,2 0,5 0,4
0,4 0,4 0,2
0,1 0,7 0,2
neni po radcich
rozmer: 3x3
0,2 0,5 0,3
0,4 0,4 0,2
0,4 0,1 0,5
je po radcich
je po sloupcich
rozmer: 3x3
-0,2 0,5 0,3
0,4 0,4 0,2
0,4 0,1 0,5
neni po radcich
neni po sloupcich
*/
public class U4 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        while(again) {
            System.out.println("Zadejte rozmery matice");
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            System.out.println("Zadejte hodnoty matice");
            double[][] matrix = new double[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            
            if (isStochasticByRows(matrix)) {
                System.out.println("Je stochasticka po radcich");
            } else {
                System.out.println("Neni stochasticka po radcich");
            }
            
            if (isStochasticByColumns(matrix)) {
                System.out.println("Je stochasticka po sloupcich");
            } else {
                System.out.println("Neni stochasticka po sloupcich");
            }
            
            System.out.println("");
            
            System.out.println("Pokracovat ve zpracovani (a/n):");
            char input;
            do {
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            again = input != 'n';
        }
    }
    
    public static boolean isStochasticByRows(double[][] matrix) {
        double sum;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    return false;
                }
                
                sum += matrix[i][j];
            }
            if(sum != 1) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isStochasticByColumns(double[][] matrix) {
        double sum;
        for (int j = 0; j < matrix[0].length; j++) {
            sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] < 0) {
                    return false;
                }
                
                sum += matrix[i][j];
            }
            if(sum != 1) {
                return false;
            }
        }
        
        return true;
    }
}
