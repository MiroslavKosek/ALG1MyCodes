package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U27 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Pocet vektoru");
            int n = sc.nextInt();
            
            if(n <= 0) {
                break;
            }
            
            System.out.println("Delka vektoru");
            int k = sc.nextInt();
            
            System.out.println("Zadej vektory");
            double[][] matrix = new double[n][k];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
            }
            
            System.out.println("Vektory s maximalnim skalarnim soucinem");
            double[][] maxScalar = maxScalar(matrix);
            for (int i = 0; i < 2; i++) {
                System.out.print("(");
                for (int j = 0; j < k; j++) {
                    System.out.printf("%.2f", maxScalar[i][j]);
                    if (j < matrix[0].length - 1) System.out.print(" ");
                }
                System.out.print(")\n");
            }
            
            System.out.printf("Skalarni soucin techto vektoru %.2f\n", calculateScalarProduct(maxScalar[0], maxScalar[1]));
            
            System.out.println("");
        }
    }
    
    public static double[][] maxScalar(double[][] matrix) {
        int n = matrix.length;
        int k = matrix[0].length;
        double maxScalarProduct = Double.NEGATIVE_INFINITY;
        int vector1Index = -1;
        int vector2Index = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double scalarProduct = calculateScalarProduct(matrix[i], matrix[j]);
                if (scalarProduct > maxScalarProduct) {
                    maxScalarProduct = scalarProduct;
                    vector1Index = i;
                    vector2Index = j;
                }
            }
        }
        
        double[][] maxScalar = new double[2][k];
        for (int i = 0; i < k; i++) {
            maxScalar[0][i] = matrix[vector1Index][i];
            maxScalar[1][i] = matrix[vector2Index][i];
        }
        
        return maxScalar;
    }
    
    public static double calculateScalarProduct(double[] vector1, double[] vector2) {
        double scalarProduct = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            scalarProduct += vector1[i] * vector2[i];
        }
        return scalarProduct;
    }
}
