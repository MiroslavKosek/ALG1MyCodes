package school.a72darray;

/**
 *
 * @author Miroslav Košek
 */
public class U3 {
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 1, 8},
            {2, 4, 9, 5},
            {1, 9, 8, 4},
            {8, 5, 4, 5},
        };
        System.out.println(isSymmetricByDiagonal(matrix)); // true
        System.out.println(isSymmetricBySideDiagonal(matrix)); // false
        System.out.println(isSymmetricByVerticalAxe(matrix)); // false
        System.out.println(isSymmetricByHorizontalAxe(matrix)); // false
        System.out.println("");
        
        matrix = new int[][] {
            {10, 9, 8, 7},
            {9, 6, 5, 8},
            {8, 5, 6, 9},
            {7, 8, 9, 10},
        };
        System.out.println(isSymmetricByDiagonal(matrix)); // true
        System.out.println(isSymmetricBySideDiagonal(matrix)); // true
        System.out.println(isSymmetricByVerticalAxe(matrix)); // false
        System.out.println(isSymmetricByHorizontalAxe(matrix)); // false
        System.out.println("");
        
        matrix = new int[][] {
            {1, 2, 2, 1},
            {3, 4, 4, 3},
            {5, 6, 6, 5},
            {7, 8, 8, 7},
        };
        System.out.println(isSymmetricByDiagonal(matrix)); // false
        System.out.println(isSymmetricBySideDiagonal(matrix)); // false
        System.out.println(isSymmetricByVerticalAxe(matrix)); // true
        System.out.println(isSymmetricByHorizontalAxe(matrix)); // false
        System.out.println("");
        
        matrix = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {5, 6, 7, 8},
            {1, 2, 3, 4},
        };
        System.out.println(isSymmetricByDiagonal(matrix)); // false
        System.out.println(isSymmetricBySideDiagonal(matrix)); // false
        System.out.println(isSymmetricByVerticalAxe(matrix)); // false
        System.out.println(isSymmetricByHorizontalAxe(matrix)); // true
        System.out.println("");
    }
    
    public static boolean isSymmetricByDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 1; j < matrix.length-1; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isSymmetricBySideDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix.length-1-i; j++) {
                if (matrix[i][j] != matrix[matrix.length-1-j][matrix.length-1-i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isSymmetricByVerticalAxe(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                if (matrix[i][j] != matrix[i][matrix[i].length-1-j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isSymmetricByHorizontalAxe(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[matrix.length-1-i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
