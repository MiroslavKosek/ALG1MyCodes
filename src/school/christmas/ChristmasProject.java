package school.christmas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Miroslav Košek
 */
public class ChristmasProject {
    static final int SCREEN_WIDTH = 70;
    static final int SCREEN_HEIGHT = 30;
    static final String[][] screen = new String[SCREEN_HEIGHT][SCREEN_WIDTH];

    // ANSI color codes
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";
    static final String BROWN = "\u001B[38;5;94m";  // Simulate brown with extended ANSI color
    static final String DARK_GREEN = "\u001B[38;5;22m";  // Darker green for the tree
    static final String WHITE = "\u001B[37m";  // White color for names on ribbon

    static final char TREE_SYMBOL = '*';
    static final char TREE_TRUNK_SYMBOL = '|';
    static final char RIBBON_SYMBOL = '#';
    static final String[] COLORS = {RED, GREEN, BLUE, YELLOW, MAGENTA, CYAN};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize screen with empty spaces
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                screen[i][j] = " ";  // Initialize with empty strings
            }
        }

        // Draw the Christmas tree in the corner using loops
        drawTree(5, 3, 11, DARK_GREEN); // Start at baseX=5, baseY=3, tree height=11, tree color=DARK_GREEN

        // Ask the user for the number of presents
        System.out.print("Enter number of presents: ");
        int numPresents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Collect present names from the user
        ArrayList<String> nameTags = new ArrayList<>();
        for (int i = 0; i < numPresents; i++) {
            System.out.print("Enter name for present #" + (i + 1) + ": ");
            nameTags.add(scanner.nextLine());
        }

        // Draw presents with random colors
        Random rand = new Random();
        for (int i = 0; i < numPresents; i++) {
            boolean placed = false;
            while (!placed) {
                int x = rand.nextInt(SCREEN_WIDTH - 10);  // 10 is present width limit
                int y = rand.nextInt(SCREEN_HEIGHT - 6);  // 6 is present height
                if (canPlacePresent(x, y)) {
                    String randomColor = COLORS[rand.nextInt(COLORS.length)];
                    drawPresent(x, y, nameTags.get(i), randomColor);  // Assign random color
                    placed = true;
                }
            }
        }

        // Display the final screen
        displayScreen();
    }

    // Function to draw the Christmas tree using loops with color
    static void drawTree(int baseX, int baseY, int height, String color) {
        int width = 1;  // Starting width of the tree
        // Draw the yellow star at the top
        screen[baseY - 1][baseX + height - 1] = YELLOW + "*" + RESET;

        for (int i = 0; i < height; i++) {
            int offset = (height - i - 1);  // To center the tree as it grows in width
            for (int j = 0; j < width; j++) {
                screen[baseY + i][baseX + offset + j] = color + TREE_SYMBOL + RESET;
            }
            width += 2;  // Increase width of the tree for each layer
        }

        // Center the trunk under the tree
        int trunkCenter = baseX + height - 1;  // The center of the tree's base
        for (int i = 0; i < 3; i++) {
            // The trunk should be 3 characters wide, centered at the tree's base
            screen[baseY + height + i][trunkCenter - 1] = BROWN + TREE_TRUNK_SYMBOL + RESET;
            screen[baseY + height + i][trunkCenter] = BROWN + TREE_TRUNK_SYMBOL + RESET;
            screen[baseY + height + i][trunkCenter + 1] = BROWN + TREE_TRUNK_SYMBOL + RESET;
        }
    }

    // Function to check if a present can be placed at the given location
    static boolean canPlacePresent(int x, int y) {
        for (int i = y; i < y + 6; i++) {
            for (int j = x; j < x + 10; j++) {
                if (!screen[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to draw a present at the given coordinates using loops and ANSI colors
    static void drawPresent(int x, int y, String name, String color) {
        // Draw the border and ribbon
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || i == 5) {  // Top and bottom border
                    screen[y + i][x + j] = color + "+" + RESET;
                } else if (j == 0 || j == 9) {  // Side borders
                    screen[y + i][x + j] = color + "|" + RESET;
                } else if (i == 3) {  // Ribbon in the middle
                    screen[y + i][x + j] = color + RIBBON_SYMBOL + RESET;
                } else {
                    screen[y + i][x + j] = " ";  // Empty space inside the present
                }
            }
        }

        // Add name tag on the ribbon in white (up to 6 characters)
        name = name.length() > 6 ? name.substring(0, 6) : name;  // Limit name to 6 chars
        for (int i = 0; i < name.length(); i++) {
            screen[y + 3][x + 2 + i] = WHITE + name.charAt(i) + RESET;  // White names on the ribbon
        }
    }

    // Function to display the screen with ANSI colors
    static void displayScreen() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }
}
