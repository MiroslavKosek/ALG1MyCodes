package school.a1introduction;

import java.util.Calendar;

/**
 *
 * @author Miroslav Košek
 */
public class Sentence {
    public static void main(String[] args) {
        //input
        String name = "Filip";
        int yob = 2010;
        char classChar = 'A';
        final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
        final int AGE_START_SCHOOL = 6;
        
        //processing
        int age = CURRENT_YEAR - yob;
        int grade = age - AGE_START_SCHOOL;

        //output
        String sentence = "Dite " + name + " ma " + age + " let a chodi do " + grade + "." + classChar + ".";
        System.out.println(sentence);
    }
}