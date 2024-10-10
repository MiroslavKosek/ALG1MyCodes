package school.a3branchingloops;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */

//Test IN: 1700 OUT: false 365
//Test IN: 2000 OUT: true 366
//Test IN: 2001 OUT: false 365
//Test IN: 2024 OUT: true 366
public class U14LeapYear {
    
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        
        final int DAYS_IN_YEAR = 365;
        final int LEAP_DAY = 1;
        
        System.out.println("Zadejte rok:");
        int year = sc.nextInt();
        
        //processing
        boolean leapYear = false;
        if (year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0))) {
            leapYear = true;
        }
        
        int days = leapYear ? DAYS_IN_YEAR + LEAP_DAY : DAYS_IN_YEAR;
        
        //output
        if (leapYear) {
            System.out.format("Rok %d je prestupny a ma %d dni\n", year, days);
        }
        else {
            System.out.format("Rok %d neni prestupny a ma %d dni\n", year, days);
        }
    }
    
}
