package school.test.u10;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class P1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int triangleIndex = -1;
        int countTriangles = 0;
        double minPerimeterAreaRatio = Double.MAX_VALUE;
        double perimeter = 0;
        double area = 0;
        
        while(true) {
            countTriangles++;
            System.out.println("Zadejte stranu a");
            double a = sc.nextDouble();

            if(a < 0) {
                break;
            }

            System.out.println("Zadejte stranu b");
            double b = sc.nextDouble();

            System.out.println("Zadejte stranu c");
            double c = sc.nextDouble();
            
            if (!isValidTriangle(a, b, c)) {
                System.out.println("Zadane hodnoty netvori trojuhelnik. Zadejte nove hodnoty.");
                continue;
            }

            countTriangles++;
            double currentPerimeter = perimeter(a, b, c);
            double currentArea = area(a, b, c);
            double perimeterAreaRatio = currentArea / currentPerimeter;

            if (perimeterAreaRatio < minPerimeterAreaRatio) {
                triangleIndex = countTriangles;
                minPerimeterAreaRatio = perimeterAreaRatio;
                perimeter = currentPerimeter;
                area = currentArea;
            }
        }
        
        sc.close();
        
        if (triangleIndex != -1) {
            System.out.println("Trojuhelnik, ktery ma nejmensi pomer plochy a obvodu je: " + triangleIndex + ". trojuhelnik");
            System.out.println("Jeho obvod je: " + perimeter);
            System.out.println("Jeho plocha je: " + area);
        } else {
            System.out.println("Nebyl zadan zadny platny trojuhelnik.");
        }
    }
    
    public static boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }
    
    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public static int count(double[] array) {
        int count = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= 2 * array[i-1]) {
                count++;
            }
        }
        
        return count;
    }
    
    public static boolean isConstant(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i][j+1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
