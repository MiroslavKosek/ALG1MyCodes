package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U28 {
    
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
            
            if (isOrthonormal(matrix)) {
                System.out.println("System vektoru je ortonormalni");
            } else {
                System.out.println("System vektoru neni ortonormalni");
            }
            System.out.println("");
        }
    }
    
    public static boolean isOrthonormal(double[][] matrix) {
        int n = matrix.length;
        final double EPSILON = 1e-9; // Tolerance pro testování reálných čísel
        
        for (int i = 0; i < n; i++) {
            // Ověření, že délka vektoru je 1
            double norm = calculateNorm(matrix[i]);
            if (Math.abs(norm - 1.0) > EPSILON) {
                return false;
            }
            
            // Ověření, že skalární součin různých vektorů je 0
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
