package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U30 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Definujeme parametry pro dimenze
        int[] weights = new int[11];
        int[] prices = new int[11];
        for (int d = 0; d <= 10; d++) {
            weights[d] = (int) Math.pow(3, d); // Váha je 3^d
            prices[d] = weights[d] + (weights[d] - 1) * d; // Cena je váha + spojnice
        }
        
        while(true) {
            System.out.println("Nosnost lode");
            int capacity = sc.nextInt();
            
            if(capacity <= 0) {
                break;
            }
            
            int[] dimensions = calculateDimensions(capacity, weights, prices);
            System.out.println("Pocty predmetu jednotlivych dimenzi");
            for (int i = dimensions.length - 1; i >= 0; i--) {
                System.out.print(dimensions[i] + " ");
            }
            System.out.println("\n");
        }
    }
    
    public static int[] calculateDimensions(int capacity, int[] weights, int[] prices) {
        int n = weights.length;
        int[] dimensions = new int[n];
        
        // Vytvoříme pole pro poměr cena/váha a indexy
        double[] valuePerWeight = new double[n];
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            valuePerWeight[i] = (double) prices[i] / weights[i];
            indices[i] = i;
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (valuePerWeight[indices[j]] < valuePerWeight[indices[j + 1]]) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }
        
        // Plníme nosnost od nejvýhodnější dimenze
        for (int idx : indices) {
            while (capacity >= weights[idx]) {
                capacity -= weights[idx];
                dimensions[idx]++;
            }
        }
        
        return dimensions;
    }
}
