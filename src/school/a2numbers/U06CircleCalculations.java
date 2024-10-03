package school.a2numbers;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */

//Test: in: 1 out: 3,14 6,28
//Test: in: 1,25 out: 7,85 4,91
public class U06CircleCalculations {
    
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadej polomer kruhu (napriklad: 1,25):");
        double r = sc.nextDouble();
        
        //processing
        double obvod = 2 * Math.PI * r;
        double obsah = Math.PI * Math.pow(r, 2);
        
        //output
        System.out.format("Obsah kruhu je: %.2f a obvod je  %.2f\n" , obsah,obvod);
    }
    
}
