package school.test.u1;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class P1 {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Zadejte pocet posloupnosti:");
        int n = sc.nextInt();
        int[][] arrays = new int[n][];
        int maxCount = 0;
        int indexMaxCount = -1;

        for (int i = 0; i < n; i++) {
            System.out.println("Posloupnost " + (i + 1) + ":");
            arrays[i] = loadArray();
            sortArray(arrays[i]);
            int count = countUniqueNumbers(arrays[i]);
            if (count > maxCount) {
                maxCount = count;
                indexMaxCount = i;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Posloupnost " + (i + 1) + " (serazena): ");
            printArray(arrays[i]);
            System.out.println("Pocet ruznych hodnot: " + countUniqueNumbers(arrays[i]));
        }
        System.out.println("Posloupnost s nejvice ruznymi hodnotami: " + (indexMaxCount + 1));
    }
    
    public static int[] loadArray() {
        System.out.println("Zadejte delku posloupnosti");
        int n = sc.nextInt();
        
        System.out.println("Zadejte hodnoty posloupnosti");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        return a;
    }
    
    public static void printArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i] + "]\n");
            }
            
        }
    }
    
    public static int countUniqueNumbers(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        
        int count = 1;
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i+1]) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void sortArray(int[] a) {
        int n = a.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
