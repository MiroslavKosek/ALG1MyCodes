package school.a1homework;

/**
 *
 * @author Miroslav Košek
 */
public class ToSecondsFromArgv {
    
    public static void main(String[] args) {
        //input
        if (args.length != 3) {
            System.out.println("Chyba: Zadejte pocet hodin, minut a sekund jako argumenty.");
            return;
        }

        int hours = Integer.parseInt(args[0]);
        int minutes = Integer.parseInt(args[1]);
        int seconds = Integer.parseInt(args[2]);

        //processing
        int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;

        //output
        System.out.println("Celkovy cas v sekundach: " + totalSeconds);
    }
    
}
