package school.sort;

/**
 *
 * @author Miroslav Košek
 */
public class InsertionSort {
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 0, -1, 46, -21516};
        
        sort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static void sort(int[] a) {
        int n = a.length;
        
        for (int i = 1; i <= n - 1; i++) {
            int j = i;
            while(j > 0 && a[j-1] > a[j]) {
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
                j--;
            }
        }
    }
}
