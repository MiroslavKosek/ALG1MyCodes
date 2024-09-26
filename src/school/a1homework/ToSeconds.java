package school.a1homework;

/**
 *
 * @author Miroslav Košek
 */
public class ToSeconds {
    
    public static void main(String[] args) {
        //input
        int hours = 2;
        int minutes = 30;
        int seconds = 45;

        //processing
        int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;

        //output
        System.out.println("Celkovy cas v sekundach: " + totalSeconds);
    }
    
}
