package school.a2numbers;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class U13BloodAlcohol {

    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        
        final double RHO = 0.8;
        final double R_MUZ = 0.7;
        final double R_ZENA = 0.6;
        final double BETA_MUZ = 0.1;
        final double BETA_ZENA = 0.085;

        System.out.println("Zadejte objem vypiteho napoje (v ml):");
        double Q = scanner.nextDouble();

        System.out.println("Zadejte podil alkoholu ve vypitem napoji (v procentech):");
        double p = scanner.nextDouble();

        System.out.println("Zadejte telesnou hmotnost konzumenta (v kg):");
        double mkonzument = scanner.nextDouble();

        System.out.println("Zadejte pohlavi konzumenta (muz/zena):");
        String pohlavi = scanner.next();

        //processing
        double r = (pohlavi.equalsIgnoreCase("muz")) ? R_MUZ : R_ZENA;
        double beta = (pohlavi.equalsIgnoreCase("muz")) ? BETA_MUZ : BETA_ZENA;

        double met = (Q * p * RHO) / 100;

        double prom = met / (mkonzument * r);

        double uet = mkonzument * beta;

        //output
        System.out.format("Promile alkoholu v krvi bezprostredne po konzumaci: %.2f ‰\n", prom);

        //input
        System.out.println("Zadejte dobu od konzumace (v hodinach):");
        double cas = scanner.nextDouble();

        //processing
        double zbytkovyAlkohol = prom - (uet * cas / mkonzument);

        //output
        if (zbytkovyAlkohol > 0) {
            System.out.format("Zbytkovy alkohol po %.2f hodinach: %.2f ‰\n", cas, zbytkovyAlkohol);
        } else {
            System.out.println("Zadny zbytkovy alkohol.");
        }

        //processing
        double casNaOdbourani = prom / beta;
        
        //output
        System.out.printf("Doba potrebna k uplnemu odbourani alkoholu: %.2f hodin\n", casNaOdbourani);
    }
    
}
