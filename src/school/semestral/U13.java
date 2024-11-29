package school.semestral;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Miroslav Košek
 */
public class U13 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        while(again) {
            System.out.println("Dolni mez intervalu:");
            int a = sc.nextInt();
            
            System.out.println("Horni mez intervalu:");
            int b = sc.nextInt();
            
            System.out.println("Pocet generovanych hodnot:");
            int n = sc.nextInt();
            
            int[] array = generateArray(a, b, n);
            
            int[] frequencies = calculateFrequencies(a, b, array);

            System.out.println("Vypis dle generovaných hodnot:");
            for (int i = a; i <= b; i++) {
                System.out.println(i + ": " + frequencies[i - a]);
            }

            System.out.println("Vypis dle dosazenych cetnosti:");
            printByFrequency(a, b, frequencies);

            System.out.println("Hodnoty s nulovou četností:");
            int zeroCount = 0;
            for (int i = a; i <= b; i++) {
                if (frequencies[i - a] == 0) {
                    System.out.print(i + " ");
                    zeroCount++;
                }
            }
            System.out.println();

            double zeroPercentage = ((double) zeroCount / (b - a + 1)) * 100;
            System.out.printf("Hodnot s nulovou cetnosti je %.2f%%\n", zeroPercentage);
            
            char input;
            do {
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase().charAt(0);
            } while (input != 'a' && input != 'n');
            again = input != 'n';
        }
    }
    
    public static int[] generateArray(int a, int b, int n) {
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(a, b + 1);
        }
        
        return array;
    }

    public static int[] calculateFrequencies(int a, int b, int[] array) {
        int range = b - a + 1;
        int[] frequencies = new int[range];

        for (int num : array) {
            frequencies[num - a]++;
        }

        return frequencies;
    }
    
    public static void printByFrequency(int a, int b, int[] frequencies) {
        int range = b - a + 1;

        int[] sortedValues = new int[range];
        int[] sortedFrequencies = new int[range];
        for (int i = 0; i < range; i++) {
            sortedValues[i] = a + i;
            sortedFrequencies[i] = frequencies[i];
        }

        for (int i = 0; i < range - 1; i++) {
            for (int j = 0; j < range - i - 1; j++) {
                if (sortedFrequencies[j] < sortedFrequencies[j + 1]) {
                    int tempFreq = sortedFrequencies[j];
                    sortedFrequencies[j] = sortedFrequencies[j + 1];
                    sortedFrequencies[j + 1] = tempFreq;

                    int tempValue = sortedValues[j];
                    sortedValues[j] = sortedValues[j + 1];
                    sortedValues[j + 1] = tempValue;
                }
            }
        }

        for (int i = 0; i < range; i++) {
            System.out.println(sortedValues[i] + ": " + sortedFrequencies[i]);
        }
    }
}
