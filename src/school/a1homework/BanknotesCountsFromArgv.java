package school.a1homework;

/**
 *
 * @author Miroslav Košek
 */
public class BanknotesCountsFromArgv {
    
    public static void main(String[] args) {
        //input
        if (args.length != 1) {
            System.out.println("Chyba: Zadejte castku jako parametr.");
            return;
        }

        int amount = Integer.parseInt(args[0]);

        //processing
        int[] values = {100, 50, 20, 10, 5, 2, 1};
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = amount / values[i];
            amount %= values[i];
        }

        //output
        System.out.println("Vycetka platidel:");
        for (int i = 0; i < values.length; i++) {
            if (numbers[i] > 0) {
                System.out.println(values[i] + " Kc: " + numbers[i] + " ks");
            }
        }
    }
    
}
