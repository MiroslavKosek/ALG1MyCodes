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
    static final String BROWN = "\u001B[38;5;94m";
    static final String DARK_GREEN = "\u001B[38;5;22m";
    static final String WHITE = "\u001B[37m";

    static final String[] COLORS = {RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Initialize the screen
        clearScreen();

        //Draw the Christmas tree in the corner
        drawTree(0, 2, 15, DARK_GREEN);

        int numPresents = getPresentCount(sc);

        ArrayList<String> nameTags = new ArrayList<>();
        
        sc.nextLine();

        for (int i = 0; i < numPresents; i++) {
            System.out.println("Enter name for present #" + (i + 1) + ":");
            nameTags.add(sc.nextLine());
        }

        //Try to place all the presents
        placePresents(nameTags, sc);

        //Display the final screen
        displayScreen();
    }

    //Function to get a number of presents
    public static int getPresentCount(Scanner sc) {
        int numPresents = -1;
        while (numPresents <= 0 || numPresents > 30) {
            System.out.print("Enter number of presents (1 to 30): ");
            if (sc.hasNextInt()) {
                numPresents = sc.nextInt();
                if (numPresents <= 0 || numPresents > 30) {
                    System.out.println("Invalid input! Please enter a number between 1 and 30.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next();
            }
        }
        return numPresents;
    }

    //Function to draw the Christmas tree
    public static void drawTree(int baseX, int baseY, int height, String color) {
        int width = 1;
        Random rand = new Random();

        screen[baseY - 1][baseX + height - 1] = YELLOW + "*" + RESET;
        
        for (int i = 0; i < height; i++) {
            //To center the tree as it grows in width
            int offset = (height - i - 1);
            for (int j = 0; j < width; j++) {
                //25% chance to color
                boolean shouldColor = rand.nextInt(100) < 25;
                boolean canColor = isSafeToColor(baseX + offset + j, baseY + i);

                //Color randomly in red or blue
                if (shouldColor && canColor) {
                    String decorationColor = rand.nextBoolean() ? RED : BLUE;
                    screen[baseY + i][baseX + offset + j] = decorationColor + '*' + RESET;
                } else {
                    screen[baseY + i][baseX + offset + j] = DARK_GREEN + '*' + RESET;
                }
            }
            width += 2;
        }

        //Center the trunk under the tree
        int trunkCenter = baseX + height - 1;
        for (int i = 0; i < 3; i++) {
            screen[baseY + height + i][trunkCenter - 1] = BROWN + '|' + RESET;
            screen[baseY + height + i][trunkCenter] = BROWN + '|' + RESET;
            screen[baseY + height + i][trunkCenter + 1] = BROWN + '|' + RESET;
        }
    }
    
    // Function to check if a position is safe to color
    public static boolean isSafeToColor(int x, int y) {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};  //Directions to check (left, right, up, down, diagonals)
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};  //Corresponding y directions

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            //Ensure newX and newY are within bounds, and check if any neighbor is already colored
            if (newX >= 0 && newX < SCREEN_WIDTH && newY >= 0 && newY < SCREEN_HEIGHT) {
                if (!screen[newY][newX].equals(" ") && !screen[newY][newX].equals(DARK_GREEN + '*' + RESET)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Function to check if a present can be placed at the given location
    public static boolean canPlacePresent(int x, int y) {
        int treeHeight = 15;
        int treeWidth = 2 * treeHeight - 1;
        int treeX = 0, treeY = 2;

        if (y < treeY + treeHeight && x < treeX + treeWidth) {
            return false;
        }

        for (int i = y; i < y + 7; i++) {
            for (int j = x; j < x + 11; j++) {
                if (!screen[i][j].equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }

    //Function to draw a present at the given coordinates
    public static void drawPresent(int x, int y, String name, String color) {
        //Draw the border and ribbon
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 11; j++) {
                //Top and bottom border
                if (i == 0 || i == 6) {
                    screen[y + i][x + j] = color + "+" + RESET;
                }
                //Side borders
                else if (j == 0 || j == 10) {
                    screen[y + i][x + j] = color + "|" + RESET;
                }
                //Ribbon crosses in the center
                else if (i == 3 || j == 5) {
                    screen[y + i][x + j] = color + '#' + RESET;
                }
                //Empty space inside the present
                else {
                    screen[y + i][x + j] = " ";
                }
            }
        }

        //Add name tag on the ribbon
        name = name.length() > 7 ? name.substring(0, 7) : name; //Limit name to 7 chars
        for (int k = 0; k < name.length(); k++) {
            screen[y + 3][x + 2 + k] = WHITE + name.charAt(k) + RESET;
        }
    }

    //Function to attempt placing presents
    public static void placePresents(ArrayList<String> nameTags, Scanner sc) {
        Random rand = new Random();
        int numPresents = nameTags.size();

        for (int i = 0; i < numPresents; i++) {
            boolean placed = false;
            int attempts = 0;

            //Try to place the present
            while (!placed && attempts < 100) {
                int x = rand.nextInt(SCREEN_WIDTH - 10);
                int y = rand.nextInt(SCREEN_HEIGHT - 7);

                if (canPlacePresent(x, y)) {
                    String randomColor = COLORS[rand.nextInt(COLORS.length)];
                    drawPresent(x, y, nameTags.get(i), randomColor);
                    placed = true;
                }

                attempts++;
            }

            if (!placed) {
                System.out.println("Not enough room for more presents. Clearing the screen...");
                clearScreen();
                drawTree(0, 2, 15, DARK_GREEN);
                
                int newCount = -1;
                while (newCount < 0 || newCount >= numPresents) {
                    System.out.println("Enter new number of presents (must be less than current count of " + numPresents + "):");
                    newCount = sc.nextInt();
                    sc.nextLine();
                }
                
                nameTags.clear();
                for (int j = 0; j < newCount; j++) {
                    System.out.println("Enter name for present #" + (j + 1) + ":");
                    nameTags.add(sc.nextLine());
                }
                
                numPresents = newCount;
                i = -1; //Reset loop
            }
        }
    }

    //Function to clear the screen and reset all cells
    public static void clearScreen() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                screen[i][j] = " ";
            }
        }
    }

    //Function to display the screen
    public static void displayScreen() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }
}
