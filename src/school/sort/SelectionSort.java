package school.sort;

/**
 *
 * @author Miroslav Košek
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 0, -1, 46, -21516};
        
        sort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    public static void sort(int[] a) {
        int n = a.length;
        
        for (int i = 0; i < n - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[iMin]) {
                    iMin = j;
                }
            }
            if (iMin != i) {
                int temp = a[iMin];
                a[iMin] = a[i];
                a[i] = temp;
            }
        }
    }
}
