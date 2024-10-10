package school.a3branchingloops;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U6SortNumbers {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte prvni cislo: ");
        int num1 = scanner.nextInt();
        System.out.println("Zadejte druhe cislo: ");
        int num2 = scanner.nextInt();
        System.out.println("Zadejte tretí cislo: ");
        int num3 = scanner.nextInt();

        System.out.println("Zvolte poradi (1 pro vzestupne, 2 pro sestupne): ");
        int order = scanner.nextInt();

        //processing
        int temp;

        if (order == 1) {
            if (num1 > num2) {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num2 > num3) {
                temp = num2;
                num2 = num3;
                num3 = temp;
            }
            if (num1 > num2) {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            //output
            System.out.println("Cisla v vzestupnem poradi: " + num1 + " " + num2 + " " + num3);
        }
        else if (order == 2) {
            if (num1 < num2) {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num2 < num3) {
                temp = num2;
                num2 = num3;
                num3 = temp;
            }
            if (num1 < num2) {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            //output
            System.out.println("Cisla v sestupnem poradi: " + num1 + " " + num2 + " " + num3);
        }
        else {
            //output
            System.out.println("Neplatna volba.");
        }
    }
    
}
