package school.semestral;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U3 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        boolean again = true;
        while(again) {
            System.out.println("Zadej posloupnost:");
            ArrayList<Integer> a1 = new ArrayList<>();
            while(true) {
                int num = sc.nextInt();
                
                if (num < 0) {
                    break;
                }
                
                a1.add(num);
            }
            
            System.out.println("Hledana sekvence:");
            ArrayList<Integer> a2 = new ArrayList<>();
            while(true) {
                int num = sc.nextInt();
                
                if (num < 0) {
                    break;
                }
                
                a2.add(num);
            }
            
            int position = containsAt(a1, a2);
            if (position != -1) {
                System.out.println("Sekvence nalezena na pozici " + position);
            } else {
                System.out.println("Sekvence nenalezena");
            }
            
            char input = 'y';
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            
            again = input != 'n';
        }
    }
    
    public static int containsAt(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        if (a2.size() > a1.size()) {
            return -1;
        }
        
        for (int i = 0; i < a1.size() - a2.size(); i++) {
            boolean found = true;
            for (int j = 0; j < a2.size(); j++) {
                if (!a1.get(i + j).equals(a2.get(j))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i + 1;
            }
        }
        
        return -1;
    }
}
