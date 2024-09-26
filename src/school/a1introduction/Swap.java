package school.a1introduction;

/**
 *
 * @author Miroslav Košek
 */
public class Swap {
    public static void main(String[] args) {
        //input
        int a = 34;
        int b = 89;
        
        System.out.println("Puvodni hodnoty:");
        System.out.println("a = " + a + ", b = " + b);
        
        //1. Bez vymeny v pameti:
        System.out.println("1. Bez vymeny v pameti:");
        System.out.println("a = " + b + ", b = " + a);
        
        //2. S vymenou v pameti s pomocnou promennou:
        System.out.println("2. S vymenou v pameti s pomocnou promennou:");
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + ", b = " + b);
        
        //3. S vymenou v pameti bez pomocne promenne
        System.out.println("3. S vymenou v pameti bez pomocne promenne:");
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);
    }
}