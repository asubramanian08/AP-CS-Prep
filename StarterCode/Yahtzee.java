import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to play the game of Yahtzee and test the isValid method of the score
 * rows
 * 
 * @author Marie-Pierre Jolly
 * @author Arjun Subramanian
 */
public class Yahtzee {

    // Static variables
    public static final int ROLLS = 3;
    public static final int UNSET = -1;
    public static final int SCORE_SHEET_ROWS = 13;
    private static final Scanner sc = new Scanner(System.in);

    // Array used to test valid combinations
    private static final int[] correctCounts = new int[] {
            7776, 7776, 7776, 7776, 7776, 7776,
            1500, 150, 300, 1200, 240, 6, 7776 };

    /**
     * Main method to test valid combinations or play the game
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        playGame();
        // scoringTester();
        sc.close();
    }

    /**
     * Interact with the user to determine a {@link Dice}.
     * The used is given {@link #ROLLS} to get a dice they would like.
     * 
     * @return The dice settled on with the user.
     */
    public static Dice rollDice() {
        // Initialize all the needed variables
        Dice dice = new Dice();
        String[] ordinal = new String[] { "zeroth", "first", "second", "third" };

        // roll the first dice
        dice.roll();
        System.out.println("Your " + ordinal[1] + " roll of the dice is: " + dice.toString());

        // loop though at most ROLLS rolls
        for (int roll = 2; roll <= ROLLS; roll++) {

            // inform the user about what they should enter
            System.out.println("Enter the pattern xxxxx with 1 for keep and 0 for reroll");
            System.out.print("Enter q to stop rolling and pick your row in the score sheet: ");

            // read the input (handel a "q"uit)
            String input = sc.nextLine();
            if (input.equals("q"))
                break;

            // determine if the input is valid
            boolean valid = true;
            if (input.length() != Dice.numDice)
                valid = false;
            for (int i = 0; i < Dice.numDice && valid; i++)
                valid = (input.charAt(i) == '0') || (input.charAt(i) == '1');

            // handle invalid inputs
            if (!valid) {
                roll--;
                System.out.println("This is not an acceptable answer");
                continue;
            }

            // roll the dice and print the results
            Boolean toRoll[] = new Boolean[Dice.numDice];
            for (int i = 0; i < Dice.numDice; i++)
                toRoll[i] = (input.charAt(i) == '1');
            dice.roll(toRoll);
            System.out.println("Your " + ordinal[roll] + " roll of the dice is: " + dice.toString());
        }

        // display and return the final dice
        System.out.println("Your dice are: " + dice.toString());
        return dice;
    }

    /**
     * Get user input to pick a {@link ScoreRow} to score using the given dice.
     * 
     * @param s    {@link ScoreSheet} whose row is getting scored.
     * @param dice The dice that is getting scored by the picked row.
     * @see ScoreRow#calculateScore(Dice)
     */
    public static void pickRow(ScoreSheet s, Dice dice) {
        // declare variables
        int row = UNSET, input;

        // loop until a valid row is given
        while (row == UNSET) {

            // get an input (ensure it is an int)
            System.out.println("Your dice are: " + dice.toString());
            System.out.print("Enter the row number for the score: ");
            try {
                String inpStr = sc.nextLine();
                input = Integer.valueOf(inpStr);
            } catch (Exception e) {
                input = UNSET;
            }

            // check that the input is valid. If so, set row to input.
            if (input < 1 || input > SCORE_SHEET_ROWS)
                System.out.println("The row should be a number between 1 and " + Integer.toString(SCORE_SHEET_ROWS));
            else if (s.get(input - 1).getScore() != UNSET)
                System.out.println("The row '" + s.get(input - 1).getName() + "' already has a score");
            else if (!s.get(input - 1).isValid(dice)) {
                System.out.print("Do you really want to enter a 0 for '" +
                        s.get(input - 1).getName() + "' (y/n) ");
                if (sc.nextLine().equals("y"))
                    row = input;
            } else
                row = input;
        }

        // calculate and set the score of the determined row
        s.get(row - 1).calculateScore(dice);
    }

    /**
     * Use {@link #rollDice()} and {@link #pickRow(ScoreSheet, Dice)} to play the
     * yahtzee game. Keeps scoring until {@link ScoreSheet#isFull()}.
     * 
     * @see #rollDice()
     * @see #pickRow(ScoreSheet, Dice)
     * @see ScoreSheet#isFull
     */
    public static void playGame() {
        // Greet + initialize variables
        System.out.println("WELCOME TO THE YAHTZEE GAME\n");
        ScoreSheet s = new ScoreSheet();

        // loop until the score sheet is filled
        // display sheet, roll dice, and pick row
        while (!s.isFull()) {
            s.display();
            System.out.println('\n');
            Dice dice = rollDice();
            System.out.println();
            pickRow(s, dice);
            System.out.println();
        }

        // display the final scoring
        System.out.println("Final score-sheet: ");
        s.display();
    }

    /**
     * Test the {@link ScoreRow#isValid(Dice)} method using
     * {@link #generateAllDiceCombinations()}.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public static void scoringTester() {
        // Greet + initialize variables
        System.out.println("LET'S TEST THE YAHTZEE SCORE-SHEET");
        ArrayList<Dice> combinations = generateAllDiceCombinations();
        int[] validDiceCount = new int[SCORE_SHEET_ROWS];
        ScoreSheet ss = new ScoreSheet();

        // Count the valid combinations for each scoring type
        for (Dice dice : combinations)
            for (int i = 0; i < SCORE_SHEET_ROWS; i++)
                if (ss.get(i).isValid(dice))
                    validDiceCount[i]++;

        // Determine if the number of "valid combinations" is correct
        boolean valid = true;
        for (int i = 0; i < SCORE_SHEET_ROWS && valid; i++)
            if (validDiceCount[i] != correctCounts[i])
                valid = false;

        // Print the number of valid combinations and if the isValid function works
        System.out.println("Number of valid dice combinations for each scoring type");
        for (int i = 0; i < SCORE_SHEET_ROWS; i++)
            // print each scoring row's validCount vs. what is expected
            System.out.println(String.format("%s: %d (expected %d)",
                    ss.get(i).getName(), validDiceCount[i], correctCounts[i]));
        System.out.println("The yahtzee score-sheet " + (valid ? "is" : "isn't") + " valid!");
    }

    /**
     * Generate all possible combinations of dice to be used in testing the
     * ScoreRow isValid method for different kinds of rows
     * 
     * @return An array list of all possible dice combinations
     */
    public static ArrayList<Dice> generateAllDiceCombinations() {
        ArrayList<Dice> diceCombinations = new ArrayList<Dice>();
        // Starting values for the dice
        int[] values = new int[Dice.numDice];
        for (int i = 0; i < Dice.numDice; i++)
            values[i] = 1;
        boolean done = false;
        while (!done) {
            // Create the dice using the set of values
            Dice dice = new Dice();
            for (int i = 0; i < Dice.numDice; i++)
                dice.getDie(i).setValue(values[i]);
            // Add this new Dice object to the array list of combinations
            diceCombinations.add(dice);
            int currentDie = 0;
            boolean foundDie = false;
            // Change dice one at a time, look for the die to change
            while (!foundDie) {
                // If the value of the current die has not reached the last face value
                if (values[currentDie] < Die.numValues) {
                    // Increment the value of the die
                    values[currentDie]++;
                    foundDie = true;
                } else {
                    // Move on to the next die, reset this die back to starting value 1
                    values[currentDie] = 1;
                    currentDie++;
                    // If the current die is beyond the last die, we're done
                    if (currentDie == Dice.numDice) {
                        foundDie = true;
                        done = true;
                    }
                }
            }
        }
        return diceCombinations;
    }
}