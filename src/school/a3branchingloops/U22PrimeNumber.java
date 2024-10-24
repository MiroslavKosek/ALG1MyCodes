package school.a3branchingloops;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */

/*
test IN  11, 4, 15, 25
test OUT je, není, je, není
 */
public class U22PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while (again) {
            System.out.println("Napiš KLADNÉ číslo, které chceš zjistit jestli je prvočíslo:");
            int number = sc.nextInt();
            
            boolean isPrimeNumber = isPrime(number);
            
            System.out.println("Číslo " + (isPrimeNumber ? "je" : "není") + " prvočíslo");
            System.out.println("Chcete pokračovat? (A/N)");
            
            char input = sc.next().toUpperCase().charAt(0);
            
            again = input == 'A';
        }
    }

    public static boolean isPrime(int a) {
        int n = 2;
        boolean isPrime = true;
        
        if(a <= 1) {
            isPrime = false;
        }
        
        for (int i = n; i <= Math.sqrt(a) && isPrime; i++) {
            if (a % i == 0) {
                isPrime = false;
                //break;
            }
        }
        
        /*while(n <= Math.sqrt(a) && isPrime) {
            if(a % n == 0) {
                isPrime = false;
                //break;
            }
            n++;
        }*/
        
        return isPrime;
    }
}
