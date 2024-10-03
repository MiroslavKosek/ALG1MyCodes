package school.a2numbers;

/**
 *
 * @author Miroslav Košek
 */

//Test: in: 1 1 1 out: 1
//Test: in: 17 19 21 out: 19,50
public class U07AverageTemp {
    
    public static void main(String[] args) {
        //input
        int teplota_6 = 17;
        int teplota_12 = 19;
        int teplota_18 = 21;
        
        //processing
        final int POCET_TEPLOT = 4;
        final int DVOJNASOBNA_VAHA = 2;
        double prumer = (teplota_6 + teplota_12 + DVOJNASOBNA_VAHA * teplota_18) / (double)POCET_TEPLOT;

        //output
        System.out.format("Prumerna denni teplota je: %.2f\n", prumer);
    }
    
}
