package school.test.u1;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class P2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Zadejte pocet vrcholu");
            int n = sc.nextInt();
            if(n <= 0) {
                break;
            }
            System.out.println("Zadejte souradnice vrcholu");
            double[][] points = new double[n][2];
            for (int i = 0; i < n; i++) {
                System.out.println("Bod " + (i + 1) + " (x y):");
                points[i][0] = sc.nextDouble();
                points[i][1] = sc.nextDouble();
            }
            
            double circumference = circumference(points);
            System.out.println("Obvod n-uhelniku: " + String.format("%.2f", circumference));
        }
    }
    
    public static double circumference(double[][] points) {
        double circumference = 0;
        int n = points.length;
        
        for (int i = 0; i < n; i++) {
            double dx = points[i][0] - points[(i + 1) % n][0];
            double dy = points[i][1] - points[(i + 1) % n][1];
            circumference += Math.sqrt(dx * dx + dy * dy);
        }
        
        return circumference;
    }
}
