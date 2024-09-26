package school.a1introduction;

import java.util.Calendar;

public class SentenceFromArgv {
    public static void main(String[] args) {
        //input
        if (args.length != 3) {
            System.out.println("Chyba: Zadejte jmeno, rok narozeni a pismeno tridy jako argumenty.");
            return;
        }

        String name = args[0];
        int yob = Integer.parseInt(args[1]);
        char classChar = args[2].charAt(0);
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
