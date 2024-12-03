package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U26 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Rozmer matic");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Prvni matice");
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            if(isMagic(matrix)) {
                System.out.println("Matice tvori magicky ctverec");
            } else {
                System.out.println("Nejedna se o magicky ctverec");
            }
            System.out.println("");
        }
    }
    
    public static boolean isMagic(int[][] matrix) {
        int n = matrix.length;
        int magicSum = 0;
        
        // Počítání cílové sumy (součet prvního řádku)
        for (int j = 0; j < n; j++) {
            magicSum += matrix[0][j];
        }
        
        // Kontrola všech řádků
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }
        
        // Kontrola všech sloupců
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }
        
        // Kontrola hlavní diagonály
        int diagSum1 = 0;
        for (int i = 0; i < n; i++) {
            diagSum1 += matrix[i][i];
        }
        if (diagSum1 != magicSum) {
            return false;
        }
        
        // Kontrola vedlejší diagonály
        int diagSum2 = 0;
        for (int i = 0; i < n; i++) {
            diagSum2 += matrix[i][n - i - 1];
        }
        if (diagSum2 != magicSum) {
            return false;
        }
        
        // Kontrola všech čísel od 1 do n^2 pomocí pole
        boolean[] found = new boolean[n * n + 1]; // Velikost pole je n^2 + 1, index 0 se nepoužije
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value < 1 || value > n * n || found[value]) {
                    return false; // Číslo je mimo rozsah nebo se opakuje
                }
                found[value] = true;
            }
        }
        
        return true;
    }
}
