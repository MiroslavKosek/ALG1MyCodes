package school.a1introduction;

import java.util.Calendar;
import java.util.Scanner;

public class SentenceFromUser {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte jmeno ditete:");
        String name = sc.nextLine();

        System.out.println("Zadejte rok narozeni ditete:");
        int yob = sc.nextInt();

        System.out.println("Zadejte oznaceni tridy (pismeno):");
        char classChar = sc.next().charAt(0);
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
