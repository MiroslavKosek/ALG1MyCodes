package school.a5libraryclasses;

/**
 *
 * @author Miroslav Košek
 */
public class MathTools {
    
    public static double cos(float x, float eps){
        double cos = 1;
        double last; 
        int i = 2;
        int k = 1;
        
        while (true){
            last = (Math.pow(x, i)) / factorial(i);
            if (last < eps){
                break;
            }
            cos = cos + last * (Math.pow(-1, k));
            i += 2;
            k++;
        }
        return cos;
    }

    private static double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }
    
}
