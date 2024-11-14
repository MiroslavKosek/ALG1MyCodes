package school.a6array;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Miroslav Košek
 */
public class ArrayTools {
    
    public static void main(String[] args) {
        int[] testArray = {3, 5, 2, 8, 1, 5, 2, 9, 4};
        
        System.out.println("Sum: " + getSum(testArray));
        System.out.println("Product: " + getProd(testArray));
        System.out.println("Max: " + getMax(testArray));
        System.out.println("Min: " + getMin(testArray));
        System.out.println("First max index: " + getFirstMax(testArray));
        System.out.println("First min index: " + getFirstMin(testArray));
        System.out.println("Count of 5: " + getCount(testArray, 5));
        System.out.println("Count of even numbers: " + getCountEven(testArray));
        System.out.println("Count of odd numbers: " + getCountOdd(testArray));
        System.out.println("First occurrence of 2: " + getFirstOccurrence(testArray, 2));
        System.out.println("Last occurrence of 2: " + getLastOccurrence(testArray, 2));
        System.out.println("Is sorted ascending: " + isSortedAscending(testArray));
        System.out.println("Is sorted descending: " + isSortedDescending(testArray));
        
        System.out.print("Array before reverse: ");
        for (int num : testArray) System.out.print(num + " ");
        
        reverse(testArray);
        
        System.out.print("\nArray after reverse: ");
        for (int num : testArray) System.out.print(num + " ");
        
        int[] randomArray = generateArray(10, 1, 100);
        System.out.print("\nGenerated random array: ");
        for (int num : randomArray) System.out.print(num + " ");
        System.out.println("");
    }

    public static int getSum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        
        return sum;
    }
    
    public static int getProd(int[] numbers) {
        int prod = 1;
        for (int i = 0; i < numbers.length; i++) {
            prod *= numbers[i];
        }
        
        return prod;
    }
    
    public static int getMax(int[] numbers) {
        int max = numbers[0];
        
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        
        return max;
    }
    
    public static int getMin(int[] numbers) {
        int min = numbers[0];
        
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        
        return min;
    }
    
    public static int getFirstMax(int[] numbers) {
        int max = numbers[0];
        int index = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
                index = i;
            }
        }
        
        return index;
    }
    
    public static int getLastMax(int[] numbers) {
        int max = numbers[0];
        int index = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (max <= numbers[i]) {
                max = numbers[i];
                index = i;
            }
        }
        
        return index;
    }
    
    public static int getFirstMin(int[] numbers) {
        int min = numbers[0];
        int index = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
                index = i;
            }
        }
        
        return index;
    }
    
    public static int getLastMin(int[] numbers) {
        int min = numbers[0];
        int index = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (min >= numbers[i]) {
                min = numbers[i];
                index = i;
            }
        }
        
        return index;
    }
    
    public static int getCount(int[] numbers, int n) {
        int count = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                count++;
            }
        }
        
        return count;
    }
    
    public static int getCountEven(int[] numbers) {
        int count = 0;
        
        for (int i = 0; i < numbers.length; i+=2) {
            if (numbers[i] % 2 == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public static int getCountOdd(int[] numbers) {
        int count = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public static int getFirstOccurrence(int[] numbers, int n) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int getLastOccurrence(int[] numbers, int n) {
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == n) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static boolean isSortedAscending(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isSortedDescending(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void reverse(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        
        while(left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
    }
    
    public static int[] generateArray(int n, int min, int max) {
        int[] array = new int[n];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomNumber(min, max);
        }
        
        return array;
    }
    
    public static int generateRandomNumber(int min, int max) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
}
