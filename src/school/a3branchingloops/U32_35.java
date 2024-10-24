package school.a3branchingloops;

/**
 *
 * @author Miroslav Košek
 */
public class U32_35 {
    
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        
        DrawLine(n);
        
        System.out.println("");
        
        DrawRectangle(m, n);
        
        System.out.println("");
        
        DrawRightAngledTriangle(n);
        
        System.out.println("");
        
        DrawTriangle(n);
    }
    
    public static void DrawLine(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println("");
    }
    
    public static void DrawRectangle(int m, int n) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    
    public static void DrawRightAngledTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    
    public static void DrawTriangle(int n) {
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
}
