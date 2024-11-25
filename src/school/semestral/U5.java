package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U5 {
    private static final int DELTA = 10;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while (again) {
            System.out.println("Zadej pocet prvku pocatecni posloupnosti:");
            int n = sc.nextInt();
            
            System.out.println("Zadej pocatecni vzestupne setridenou posloupnost:");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            System.out.println("Zadavej dalsi hodnoty:");
            while(true) {
                int num = sc.nextInt();
                if (num < 0) {
                    break;
                }
                if (binarySearch(a, n, num) == -1) {
                    a = insertIntoSortedArray(a, n, num);
                    n++;
                }
            }
            
            System.out.println("Vysledna posloupnost:");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            
            System.out.println("");
            
            char input = 'y';
            
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            
            again = input != 'n';
        }
    }
    
    public static int binarySearch(int[] a, int n, int num) {
        int l = 0;
        int r = n - 1;
        
        while(l <= r) {
            int mid = (l+r)/2;
            
            if (a[mid] == num) {
                return mid;
            } else if (a[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return -1;
    }
    
    public static int findInsertPosition(int[] a, int n, int num) {
        int l = 0;
        int r = n - 1;
        
        while(l <= r) {
            int mid = (l+r)/2;
            
            if (a[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    public static int[] insertIntoSortedArray(int[] a, int n, int num) {
        if (a.length == n) {
            int[] b = new int[n + DELTA];
            System.arraycopy(a, 0, b, 0, n);
            a = b;
            b = null;
        }
        
        int pos = findInsertPosition(a, n, num);
        
        for (int i = n; i > pos; i--) {
            a[i] = a[i - 1];
        }
        
        a[pos] = num;
        
        return a;
    }
}
