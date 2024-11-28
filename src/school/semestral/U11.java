package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U11 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("Zadej rozsah");
            int a = sc.nextInt();
            if (a < 0) {
                break;
            }
            int b = sc.nextInt();
            
            System.out.println("Nalezena cisla");
            long[] nums = soupisky(a, b);
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    n++;
                    System.out.println(nums[i]);
                }
            }
            System.out.println("Pocet nalezenych cisel " + n);
            System.out.println("");
        }
    }
    
    public static long[] soupisky(int a, int b) {
        long[] nums = new long[b-a];
        for (int i = 0; i < b-a; i++) {
            long soupiska = soupiska(a+i);
            if (soupiska == a+i) {
                nums[i] = soupiska;
            }
        }
        return nums;
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
