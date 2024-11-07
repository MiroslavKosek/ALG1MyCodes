package school.a5libraryclasses;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Miroslav Košek
 */
public class NaturalNumbersTools {
    
    //testovaci main
    public static void main(String[] args) {
        System.out.println(testPrime(1)); //false
        System.out.println(testPrime(10)); //false
        System.out.println(testPrime(53)); //true
        System.out.println(findGreatestDivisor(20, 12)); // 4
        System.out.println(findGreatestDivisor(24, 12)); // 12
        System.out.println(findGreatestDivisor(23, 12)); // 4
    }
    
    /**
     * Tests whether the given number is prime has no other divisors than 1, and itself
     * @param number given natural number
     * @return true if the given number is prime, false otherwise
     */
    public static boolean testPrime(int number) {
        int n = 2;
        boolean isPrimeNumber = true;
        
        if(number <= 1) {
            isPrimeNumber = false;
        }
        
        for (int i = n; i <= Math.sqrt(number) && isPrimeNumber; i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
            }
        }
        
        return isPrimeNumber;
    }
    
    public static int findGreatestDivisor(int a, int b){
        int min;
        int divisor = 1;
        boolean divisorFound = false;
        min = (a > b) ? b : a;
        
        for(int i = min; i >= 2; i--)
        {
            if(a % i == 0 && b % i == 0)
            {
                divisor = i;
                return divisor;
            }             
        }
        
        return divisor;
    }
    
    public static int findLeastMultiple(int a, int b) {
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);
        
        int result = bigger;
        
        while (result % smaller != 0) {
            result += bigger;
        }
        
        return result;
    }
    
    public static int numberOfDivisors(int number)
    {
        int limit = (int)Math.sqrt(number);
        int count = 2;
        for(int i = 2 ; i <= limit ; i++)
        {
            if(number % i == 0)
            {
                count++;
                if(number / i != i)
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean testPerfect(long number) {
        int sum = 1;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) { 
                sum += i;
                if(i * i != number ){
                    sum += number / i;
                }
            }
        }
        
        return sum == number;
    }
    
    public static int generateNumberInRange(int min, int max) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
}
