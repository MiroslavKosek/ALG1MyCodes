package school.sort;

/**
 *
 * @author Miroslav Košek
 */
public class BubbleSort {
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 0, -1, 46, -21516};
        
        sort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static void sort(int[] a) {
        int n = a.length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
