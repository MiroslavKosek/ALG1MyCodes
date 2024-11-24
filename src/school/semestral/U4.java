package school.semestral;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U4 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while(again) {
            System.out.println("Zadej prvni posloupnost:");
            ArrayList<Integer> a1 = new ArrayList<>();
            while(true) {
                int num = sc.nextInt();
                
                if (num < 0) {
                    break;
                }
                
                a1.add(num);
            }
            
            System.out.println("Zadej druhou posloupnost:");
            ArrayList<Integer> a2 = new ArrayList<>();
            while(true) {
                int num = sc.nextInt();
                
                if (num < 0) {
                    break;
                }
                
                a2.add(num);
            }
            
            System.out.println("Zadej treti posloupnost:");
            ArrayList<Integer> a3 = new ArrayList<>();
            while(true) {
                int num = sc.nextInt();
                
                if (num < 0) {
                    break;
                }
                
                a3.add(num);
            }
            
            System.out.println("Vysledna posloupnost");
            ArrayList<Integer> a4 = combine(a1, a2, a3);
            for (int num : a4) {
                System.out.print(num + " ");
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
    
    public static ArrayList<Integer> combine(ArrayList<Integer> a1, ArrayList<Integer> a2, ArrayList<Integer> a3) {
        ArrayList<Integer> a = new ArrayList<>();
        int i = 0, j = 0, k = 0;

        while (i < a1.size() || j < a2.size() || k < a3.size()) {
            int val1 = (i < a1.size()) ? a1.get(i) : Integer.MAX_VALUE;
            int val2 = (j < a2.size()) ? a2.get(j) : Integer.MAX_VALUE;
            int val3 = (k < a3.size()) ? a3.get(k) : Integer.MAX_VALUE;

            if (val1 <= val2 && val1 <= val3) {
                a.add(val1);
                i++;
            } else if (val2 <= val1 && val2 <= val3) {
                a.add(val2);
                j++;
            } else {
                a.add(val3);
                k++;
            }
        }

        return a;
    }
}
