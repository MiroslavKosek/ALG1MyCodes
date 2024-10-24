package school.a3branchingloops;

/**
 *
 * @author Miroslav Košek
 */
public class U3235For {
    
    public static void main(String[] args) {
        int n = 5;
        
        DrawLine(n);
        
        System.out.println("");
        
        int m = 6;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        
        System.out.println("");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
        
        System.out.println("");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    
    public static void DrawLine(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println("");
    }
    
}
