package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U10 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Zadej cislo");
            long num = sc.nextLong();
            if(num <= 0) {
                break;
            }
            
            long soupiskaNum = soupiska(num);
            System.out.println("Cislo " + num + " ma soupisku " + soupiskaNum);
            
            if (num == soupiskaNum) {
                System.out.println("Cislo " + num + " je zapisem sve soupisky");
            } else {
                System.out.println("Cislo " + num + " neni zapisem sve soupisky");
            }
            
            System.out.println("");
        }
    }
    
        public static long soupiska(long num) {
        int[] digitCounts = new int[10];
        
        long temp = num;
        while (temp > 0) {
            int digit = (int) (temp % 10);
            digitCounts[digit]++;
            temp /= 10;
        }
        
        StringBuilder soupiskaBuilder = new StringBuilder();
        for (int digit = 0; digit < 10; digit++) {
            if (digitCounts[digit] > 0) {
                soupiskaBuilder.append(digitCounts[digit]).append(digit);
            }
        }
        
        return Long.parseLong(soupiskaBuilder.toString());
    }
}
