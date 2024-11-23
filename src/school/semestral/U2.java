package school.semestral;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U2 {
    
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while(again) {
            System.out.println("Zadej první posloupnost:");
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
            
            System.out.println("Nejdelsi spolecny usek obou posloupnosti ma delku " + commonLength(a1, a2));
            
            char input = 'y';
            
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');

            again = input != 'n';
        }
    }
    
    public static int commonLength(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        int maxLength = 0;

        for (int i = 0; i < a1.size(); i++) {
            for (int j = 0; j < a2.size(); j++) {
                int length = 0;

                while (i + length < a1.size() && j + length < a2.size() &&
                       a1.get(i + length).equals(a2.get(j + length))) {
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
