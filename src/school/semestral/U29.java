package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U29 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Pocet vektoru");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Zadej vektory");
            double[][] matrix = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            
            if(isOrthogonal(matrix)) {
                System.out.println("System je ortogonalni");
                System.out.println("Normalizovany system");
                double[][] normalizedMatrix = normalize(matrix);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%.2f", normalizedMatrix[i][j]);
                        if (j < normalizedMatrix[0].length - 1) System.out.print(" ");
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("System neni ortogonalni");
            }
            System.out.println("");
        }
    }
    
    public static double[][] normalize(double[][] matrix) {
        int n = matrix.length;
        double[][] normalizedMatrix = new double[n][n];
        
        for (int i = 0; i < n; i++) {
            double norm = calculateNorm(matrix[i]);
            for (int j = 0; j < n; j++) {
                normalizedMatrix[i][j] = matrix[i][j] / norm;
            }
        }
        
        return normalizedMatrix;
    }
    
    public static boolean isOrthogonal(double[][] matrix) {
        int n = matrix.length;
        final double EPSILON = 1e-9; // Tolerance pro testování reálných čísel
        
        for (int i = 0; i < n; i++) {
            // Kontrola, že žádný vektor nemá nulovou délku
            double norm = calculateNorm(matrix[i]);
            if (Math.abs(norm) < EPSILON) {
                return false;
            }
            
            // Kontrola ortogonality mezi všemi dvojicemi různých vektorů
            for (int j = i + 1; j < n; j++) {
                double scalarProduct = calculateScalarProduct(matrix[i], matrix[j]);
                if (Math.abs(scalarProduct) > EPSILON) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static double calculateNorm(double[] vector) {
        double norm = 0.0;
        for (double v : vector) {
            norm += v * v;
        }
        return Math.sqrt(norm);
    }
    
    public static double calculateScalarProduct(double[] vector1, double[] vector2) {
        double scalarProduct = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            scalarProduct += vector1[i] * vector2[i];
        }
        return scalarProduct;
    }
}
