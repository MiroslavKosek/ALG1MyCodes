package school.a3branchingloops;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Miroslav Košek
 */
public class U38GuessingNumber {

    static Scanner sc = new Scanner(System.in); //globalni promenna
    static int min = 1;
    static int max = 100;

    public static void main(String[] args) {
        boolean end = false;
        int choice;
        do {
            displayMenu();
            choice = choose();
            switch (choice) {
                case 1 ->
                    changeRange();
                case 2 ->
                    computerGuesses();
                case 3 ->
                    userGuesses();
                case 0 ->
                    end = true;
                default ->
                    System.out.println("Spatna volba.");
            }
        } while (!end);
    }

    private static void displayMenu() {
        System.out.println("1. Zmena rozsahu");
        System.out.println("2. Hada pocitac");
        System.out.println("3. Hada uzivatel");
        System.out.println("0. Konec\n");
    }

    private static int choose() {
        //return 0;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //input.
        System.out.println("Zadej volbu");
        int answer = sc.nextInt();
        return answer;
    }

    private static void changeRange() {
        boolean validRange = false;
        do {
            System.out.println("Zadej dolni mez:");
            min = sc.nextInt();
            System.out.println("Zadej horni mez:");
            max = sc.nextInt();

            if (min >= max) {
                System.out.println("Dolni mez musi byt mensi nez horni mez.");
            } else {
                validRange = true;
            }
        } while (!validRange);
    }

    private static void computerGuesses() {
        System.out.println("Mysli si cislo");
        int lower = min; //! pozor, nechceme menit globalni promenne
        int upper = max;
        boolean found = false;
        do {
            int middle = (lower + upper) / 2;
            System.out.println("Myslel jsi si cislo " + middle + "?");
            System.out.println("Vyber \n0. Uhodl \n1. Myslene cislo je vetsi \n-1. Myslene cislo je mensi");
            int answer = sc.nextInt();
            switch (answer) {
                case 0 ->
                    found = true;
                case 1 ->
                    lower = middle + 1;
                case -1 ->
                    upper = middle - 1;
                default -> {
                }
            }
        } while (!found && lower <= upper);

        if (found) {
            System.out.println("Huraa\n");
        } else {
            System.out.println("Pravdepodobne jsi si myslel cislo mimo rozsah\n");
        }
    }

    //testing main
//    public static void main(String[] args) {
//        //Test 50, 64, 37, limitni - 1, 100, 10.5, 105
//        computerGuesses();
//    }
    public static int generateRandomNumber(int min, int max) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    private static void userGuesses() {
        System.out.println("Myslim si cislo od " + min + " do " + max);
        int randomNumber = generateRandomNumber(min, max);

        boolean uhodl = false;
        do {
            System.out.println("Hadej: ");
            int userNumber = sc.nextInt();
            if (randomNumber > userNumber) {
                System.out.println("\nMyslim si vetsi cislo");
            } else if (randomNumber < userNumber) {
                System.out.println("\nMyslim si mensi cislo");
            } else {
                System.out.println("\nSpravne, uhodl jsi.\n");
                uhodl = true;
            }
        } while (!uhodl);
    }

}
