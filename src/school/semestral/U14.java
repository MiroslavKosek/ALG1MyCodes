package school.semestral;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U14 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        
        while(again) {
            System.out.println("Velikost sachovnice:");
            int n = sc.nextInt();
            
            System.out.println("Pocet dam:");
            int k = sc.nextInt();
            
            System.out.println("Pozice jednotlivých dam:");
            int[][] positions = new int[k][2];

            for (int i = 0; i < k; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                
                if (row < 1 || row > n || col < 1 || col > n) {
                    System.out.println("Neplatna pozice. Zadejte znovu.");
                    i--;
                    continue;
                }
                
                positions[i][0] = row - 1;
                positions[i][1] = col - 1;
            }

            System.out.println("Kolizni dvojice:");
            findCollisions(positions);
            
            char input;
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            again = input != 'n';
        }
    }

    private static void findCollisions(int[][] positions) {
        int k = positions.length;

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (areQueensInConflict(positions[i], positions[j])) {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }
    }

    private static boolean areQueensInConflict(int[] q1, int[] q2) {
        return q1[0] == q2[0] || q1[1] == q2[1] || Math.abs(q1[0] - q2[0]) == Math.abs(q1[1] - q2[1]);
    }
}
