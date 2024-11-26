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
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
