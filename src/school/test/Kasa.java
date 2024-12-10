package school.test;

import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class Kasa {
    private static final Scanner sc = new Scanner(System.in);
    private static final double CASHBACK_RATE = 0.02;
    private static final int STICKER_THRESHOLD = 200;
    private static final int MAX_VOUCHERS = 5;

    public static void main(String[] args) {
        boolean continueShopping;

        do {
            processPurchase();

            System.out.println("Chcete pokracovat s dalsim nakupem? (a/A pro ano):");
            String response = sc.nextLine().trim().toLowerCase();
            continueShopping = response.equals("a");
        } while (continueShopping);

        System.out.println("Dekujeme za pouziti registracni pokladny!");
    }

    private static void processPurchase() {
        double totalPrice = 0.0;
        double totalFoodPrice = 0.0;
        int totalItems = 0;
        int foodItems = 0;
        double minPrice = Double.MAX_VALUE;

        while (true) {
            System.out.println("Zadejte cenu polozky, mnozstvi a typ polozky (1 - potraviny, 2 - drogerie), nebo 0 pro ukonceni:");

            String input = sc.nextLine().trim();

            if (input.equals("0")) {
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 3) {
                System.out.println("Spatny format vstupu! Zadejte cenu, mnozstvi a typ oddelene mezerou.");
                continue;
            }

            try {
                double price = Double.parseDouble(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
                int type = Integer.parseInt(parts[2]);

                if (price < 0 || quantity <= 0 || (type != 1 && type != 2)) {
                    System.out.println("Chybne hodnoty! Zadejte kladne hodnoty a typ 1 (potraviny) nebo 2 (drogerie).");
                    continue;
                }

                double itemTotal = price * quantity;
                totalPrice += itemTotal;
                totalItems += quantity;

                if (price < minPrice) {
                    minPrice = price;
                }

                if (type == 1) { // Potraviny
                    foodItems += quantity;
                    totalFoodPrice += itemTotal;
                }

                System.out.printf("Prubezny soucet: %.2f Kc%n", totalPrice);

            } catch (NumberFormatException e) {
                System.out.println("Chybny format vstupu! Zkuste to znovu.");
            }
        }

        printSummary(totalPrice, totalItems, foodItems, totalFoodPrice, minPrice);

        handlePayment(totalPrice, totalFoodPrice);
    }

    private static void printSummary(double totalPrice, int totalItems, int foodItems, double totalFoodPrice, double minPrice) {
        System.out.println("\n--- Shrnuti nakupu ---");
        System.out.printf("Celkova cena nakupu: %.2f Kc%n", totalPrice);
        System.out.printf("Zaokrouhlena cena nakupu: %.0f Kc%n", (double) Math.round(totalPrice));
        System.out.printf("Celkove mnozstvi polozek: %d%n", totalItems);
        System.out.printf("Celkove mnozstvi polozek typu potraviny: %d%n", foodItems);
        System.out.printf("Celkova cena za potraviny: %.2f Kc%n", totalFoodPrice);
        System.out.printf("Minimalni cena polozky: %.2f Kc%n", minPrice == Double.MAX_VALUE ? 0.0 : minPrice);

        int stickers = (int) (totalPrice / STICKER_THRESHOLD);
        System.out.println(stickers > 0 ? "Mate narok na " + stickers + " samolepku/samolepek." : "Nemate narok na samolepky.");
    }

    private static void handlePayment(double totalPrice, double totalFoodPrice) {
        System.out.println("Zvolte zpusob platby (1 - kartou, 2 - stravenkami):");

        String input = sc.nextLine().trim();
        if (input.equals("1")) {
            double cashback = totalPrice * CASHBACK_RATE;
            System.out.printf("Zakaznik dostane zpet od kreditni spolecnosti: %.2f Kc%n", cashback);
        } else if (input.equals("2")) {
            System.out.println("Zadejte hodnotu jedne stravenky:");
            String voucherInput = sc.nextLine().trim();

            try {
                double voucherValue = Double.parseDouble(voucherInput);
                if (voucherValue > 0) {
                    int usedVouchers = Math.min(MAX_VOUCHERS, (int) (totalFoodPrice / voucherValue));
                    double voucherCoverage = usedVouchers * voucherValue;
                    double remainingToPay = totalPrice - voucherCoverage;

                    System.out.printf("Pouzite stravenky: %d (hodnota %.2f Kc)%n", usedVouchers, voucherCoverage);
                    System.out.printf("Zbyva doplatit: %.2f Kc%n", remainingToPay);
                } else {
                    System.out.println("Hodnota stravenky musi byt kladna!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chybny format hodnoty stravenky!");
            }
        } else {
            System.out.println("Neplatna volba platby!");
        }
    }
}
