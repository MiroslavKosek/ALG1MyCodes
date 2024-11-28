package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U7 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final double EPSILON = 1e-9;
        boolean again = true;
        while(again) {
            System.out.println("Zadej vrcholy trojuhelnika:");
            double[][] trianglePoints = new double[3][2];
            for (int i = 0; i < 3; i++) {
                trianglePoints[i][0] = sc.nextDouble();
                trianglePoints[i][1] = sc.nextDouble();
            }
            
            System.out.println("Zadej pocet testovanych bodu:");
            int n = sc.nextInt();

            int inside = 0;
            int onBoundary = 0;
            int outside = 0;
            
            System.out.println("Zadej souradnice bodu:");
            for (int i = 0; i < n; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();

                double areaTotal = triangleArea(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
                double area1 = triangleArea(new double[]{x, y}, trianglePoints[1], trianglePoints[2]);
                double area2 = triangleArea(trianglePoints[0], new double[]{x, y}, trianglePoints[2]);
                double area3 = triangleArea(trianglePoints[0], trianglePoints[1], new double[]{x, y});

                if (Math.abs(area1 + area2 + area3 - areaTotal) < EPSILON) {
                    if (Math.abs(area1) < EPSILON || Math.abs(area2) < EPSILON || Math.abs(area3) < EPSILON) {
                        onBoundary++;
                    } else {
                        inside++;
                    }
                } else {
                    outside++;
                }
            }
            
            System.out.println("Uvnitr trojuhelnika lezi " + inside + " bodu");
            System.out.println("Na hranici trojuhelnika lezi " + onBoundary + " bodu");
            System.out.println("Vne trojuhelnika lezi " + outside + " bodu");
            

            char input = 'y';
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            
            again = input != 'n';
        }
    }
    
    public static double triangleArea(double[] p1, double[] p2, double[] p3) {
        return Math.abs((p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1])) / 2.0);
    }
}
