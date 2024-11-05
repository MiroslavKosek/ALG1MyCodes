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
        int height = -1;
        while (height <= 0 || height > 50) {
            System.out.print("Enter the height of the Christmas tree (1 to 50): ");
            if (sc.hasNextInt()) {
                height = sc.nextInt();
                if (height <= 0 || height > 50) {
                    System.out.println("Invalid input! Please enter a number between 1 and 50.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next();
            }
            sc.nextLine();
        }
        
        // Ask for present names
        System.out.print("Enter the name for the first present: ");
        String present1 = sc.nextLine();

        System.out.print("Enter the name for the second present: ");
        String present2 = sc.nextLine();

        // Draw the Christmas tree
        drawTree(height);

        // Draw the presents with random colors
        drawPresents(present1, present2, getRandomColor(), getRandomColor());
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

    // Function to draw two presents on the same row
    public static void drawPresents(String name1, String name2, String color1, String color2) {
        int presentWidth = 11;
        int presentHeight = 5;
        int ribbonColumn = presentWidth / 2;
        int spacing = 15;

        // Limit name length to fit within the present
        if (name1.length() > presentWidth - 2) {
            name1 = name1.substring(0, presentWidth - 2);
        }
        if (name2.length() > presentWidth - 2) {
            name2 = name2.substring(0, presentWidth - 2);
        }

        int name1StartPos = Math.max((presentWidth - 2 - name1.length()) / 2, 0);
        int name2StartPos = Math.max((presentWidth - 2 - name2.length()) / 2, 0);

        // Draw the top of both presents
        System.out.print(color1 + "+++++++++++" + RESET + " ".repeat(spacing) + color2 + "+++++++++++" + RESET + "\n");

        // Draw the sides and ribbons with the names
        for (int i = 0; i < presentHeight; i++) {
            // First present
            System.out.print(color1 + "+");
            if (i == presentHeight / 2) { // Center row with name on ribbon
                System.out.print("#".repeat(name1StartPos) + WHITE + name1 + RESET + color1 + "#".repeat(presentWidth - name1StartPos - name1.length() - 2) + "+");
            } else {
                for (int j = 0; j < presentWidth - 2; j++) {
                    if (j == ribbonColumn - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print(color1 + "+");
            }

            // Space between the two presents
            System.out.print(" ".repeat(spacing));

            // Second present
            System.out.print(color2 + "+");
            if (i == presentHeight / 2) { // Center row with name on ribbon
                System.out.print("#".repeat(name2StartPos) + WHITE + name2 + RESET + color2 + "#".repeat(presentWidth - name2StartPos - name2.length() - 2) + "+");
            } else {
                for (int j = 0; j < presentWidth - 2; j++) {
                    if (j == ribbonColumn - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print(color2 + "+");
            }
            System.out.println(RESET);
        }

        // Draw the bottom of both presents
        System.out.println(color1 + "+++++++++++" + RESET + " ".repeat(spacing) + color2 + "+++++++++++" + RESET);
    }

    // Function to get a random color from the COLORS array
    public static String getRandomColor() {
        Random rand = new Random();
        return COLORS[rand.nextInt(COLORS.length)];
    }
}
