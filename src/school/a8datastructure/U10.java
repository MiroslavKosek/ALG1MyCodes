package school.a8datastructure;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U10 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadejte pocet studentu:");
        int numStudents = sc.nextInt();
        
        System.out.println("Zadejte pocet znamek studentu:");
        int numMarks = sc.nextInt();
        
        int[][] students = new int[numStudents][numMarks];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < numMarks; j++) {
                students[numStudents][numMarks] = sc.nextInt();
            }
        }
        
        double[] averages = averages(students);
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Prumer " + (i + 1) + ". studenta je: " + averages[i]);
        }
        
    }
    
    public static double[] averages(int[][] students) {
        double[] averages = new double[students.length];
        
        int sum;
        for (int i = 0; i < students.length; i++) {
            sum = 0;
            for (int j = 0; j < students[i].length; j++) {
                sum += students[i][j];
            }
            averages[i] = sum / students[i].length;
        }
        
        return averages;
    }
}
