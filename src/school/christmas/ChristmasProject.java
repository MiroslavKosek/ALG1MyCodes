package school.christmas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class ChristmasProject {

    // ANSI color codes
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BROWN = "\u001B[38;5;94m";
    static final String DARK_GREEN = "\u001B[38;5;22m";
    static final String WHITE = "\u001B[37m";

    // Array of colors for presents
    static final String[] COLORS = {RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for tree height
        System.out.print("Enter the height of the Christmas tree: ");
        int height = sc.nextInt();
        sc.nextLine();

        // Ask for present names
        System.out.print("Enter the name for the first present: ");
        String present1 = sc.nextLine();

        System.out.print("Enter the name for the second present: ");
        String present2 = sc.nextLine();

        // Draw the Christmas tree
        drawTree(height);

        // Draw the presents with random colors
        drawPresent(present1, 0, getRandomColor());
        drawPresent(present2, 15, getRandomColor());
    }

    // Function to draw the Christmas tree
    public static void drawTree(int height) {
        Random rand = new Random();

        // Draw the star on top
        System.out.println(" ".repeat(height) + YELLOW + "*" + RESET);

        // Draw the tree with decorations
        for (int i = 0; i < height; i++) {
            int width = 1 + 2 * i;
            StringBuilder row = new StringBuilder(" ".repeat(height - i));
            for (int j = 0; j < width; j++) {
                if (rand.nextInt(100) < 25) {
                    row.append(rand.nextBoolean() ? RED + "*" + RESET : BLUE + "*" + RESET);
                } else {
                    row.append(DARK_GREEN + "*" + RESET);
                }
            }
            System.out.println(row);
        }

        // Draw the tree trunk
        for (int i = 0; i < 3; i++) {
            System.out.println(" ".repeat(height - 1) + BROWN + "|||" + RESET);
        }
    }

    // Function to draw a present with a name tag, color, and ribbons
    public static void drawPresent(String name, int offset, String color) {
        int presentWidth = 11;
        int presentHeight = 5;
        int ribbonColumn = presentWidth / 2;
        int nameStartPos = (presentWidth - 2 - name.length()) / 2; // Center the name if it's shorter

        // Draw the top of the present
        System.out.println(" ".repeat(offset) + color + "+++++++++++" + RESET);

        // Draw the sides and ribbons with the name on the horizontal ribbon in the middle row
        for (int i = 0; i < presentHeight; i++) {
            System.out.print(" ".repeat(offset) + color + "+");

            if (i == presentHeight / 2) { // Center row with horizontal ribbon and name
                System.out.print("#".repeat(nameStartPos) + WHITE + name + RESET + color + "#".repeat(presentWidth - nameStartPos - name.length() - 2) + "+");
            } else { // Other rows
                for (int j = 0; j < presentWidth - 2; j++) {
                    if (j == ribbonColumn - 1) { // Vertical ribbon down the middle
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print(color + "+");
            }
            System.out.println(RESET);
        }

        // Draw the bottom of the present
        System.out.println(" ".repeat(offset) + color + "+++++++++++" + RESET);
    }

    // Function to get a random color from the COLORS array
    public static String getRandomColor() {
        Random rand = new Random();
        return COLORS[rand.nextInt(COLORS.length)];
    }
}
