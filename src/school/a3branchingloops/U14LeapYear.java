package school.a3branchingloops;

/**
 *
 * @author Miroslav Košek
 */

//Test IN: 1700 OUT: false
//Test IN: 2000 OUT: true
//Test IN: 2001 OUT: false
//Test IN: 2024 OUT: true
public class U14LeapYear {
    
    public static void main(String[] args) {
        //input
        int year = 2024;
        
        //processing
        boolean leapYear = false;
        if (year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0))) {
            leapYear = true;
        }
        
        int days = leapYear ? 366 : 365;
        
        //output
        if (leapYear) {
            System.out.format("Rok %d je prestupny a ma %d dni\n", year, days);
        }
        else {
            System.out.format("Rok %d neni prestupny a ma %d dni\n", year, days);
        }
    }
    
}
