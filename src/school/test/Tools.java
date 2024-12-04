package school.test;

/**
 *
 * @author Miroslav Košek
 */
public class Tools {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 5, 5, 8},
            {0, 5, 9, 5},
            {0, 5, 8, 4},
            {0, 5, 5, 5}};
        System.out.println(maxRowNotNull(matrix)); //4
        
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 2};
        int[] sum = sumArray(a1, a2);
        System.out.print("[");
        for (int i = 0; i < sum.length; i++) {
            if (i < sum.length - 1) {
                System.out.print(sum[i] + ", ");
            } else {
                System.out.print(sum[i]);
            }
        }
        System.out.print("]\n");
        int[][]matrix2 = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}};
        System.out.println(oneMatrix(matrix2));
    }
    
    public static int[] sumArray(int[] a1, int[] a2) {
        int n = Math.max(a1.length, a2.length);
        int[] sum = new int[n];
        
        if (a1.length > a2.length) {  
            System.arraycopy(a2, 0, sum, 0, a2.length);
        } else {
            System.arraycopy(a1, 0, sum, 0, a1.length);
        }
        
        for (int i = 0; i < n; i++) {
            if (a1.length > a2.length) {
                sum[i] = sum[i] + a1[i];
            } else {
                sum[i] = sum[i] + a2[i];
            }
        }
        
        return sum;
    }
    
    public static int maxRowNotNull(int[][] matrix) {
        int maxCount = 0;
        int count = 0;
        int index = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    count++;
                }
            }
            if (maxCount <= count) {
                index = i;
                maxCount = count;
            }
            count = 0;
        }
        
        return index;
    }
    
    public static boolean oneMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                } else {
                    if (matrix[i][j] != 1) {
                        return false;
                    }
                }
            }
        }
                
        return true;
    }
}
