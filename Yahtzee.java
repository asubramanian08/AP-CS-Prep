import java.util.Scanner;

/**
 * {@link Yahtzee} acts as the "main" class for this Yahtzee project. Its two
 * important methods are {@link #playGame()} and {@link #scoringTester()}.
 * 
 * @see #playGame()
 * @see #scoringTester()
 * @see ValidityTester
 * @see ScoreSheet
 * @see Dice
 * @author Arjun Subramanian
 */
public class Yahtzee {

    // General static variables
    public static final int DICE_SIDES = 6;
    public static final int DICE_COUNT = 5;
    public static final int ROLLS = 3;
    public static final int UNSET = -1;
    public static final int SCORE_SPACES = 20;
    public static final int SCORE_SHEET_ROWS = 13;

    // Static variables used for the score sheet
    public static final int FULL_HOUSE_HIGH_COUNT = 3;
    public static final int FULL_HOUSE_LOW_COUNT = 2;
    public static final int SMALL_STRAIGHT_COUNT = 4;
    public static final int LARGE_STRAIGHT_COUNT = 5;

    // Static variables used for scoring
    public static final int FULL_HOUSE_SCORE = 25;
    public static final int SMALL_STRAIGHT_SCORE = 30;
    public static final int LARGE_STRAIGHT_SCORE = 40;
    public static final int YAHTZEE_SCORE = 50;

    // General input scanner used in rollDice() and pickRow()
    private static final Scanner sc = new Scanner(System.in);

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
            if (input.length() != DICE_COUNT)
                valid = false;
            for (int i = 0; i < DICE_COUNT && valid; i++)
                valid = (input.charAt(i) == '0') || (input.charAt(i) == '1');

            // handle invalid inputs
            if (!valid) {
                roll--;
                System.out.println("This is not an acceptable answer");
                continue;
            }

            // roll the dice and print the results
            Boolean toRoll[] = new Boolean[DICE_COUNT];
            for (int i = 0; i < Yahtzee.DICE_COUNT; i++)
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
     * Test the {@link ScoreRow#isValid(Dice)} method using {@link ValidityTester}.
     * 
     * @see ValidityTester
     * @see ScoreRow#isValid(Dice)
     */
    public static void scoringTester() {
        // Greet + initialize variables
        System.out.println("LET'S TEST THE YAHTZEE SCORE-SHEET");
        ValidityTester vt = new ValidityTester();

        // Print the results of the tester
        vt.display();
        System.out.println("The yahtzee score-sheet " + (vt.isValid() ? "is" : "isn't") + " valid!");
    }

    /**
     * Executes either {@link #playGame()} or {@link #scoringTester()}.
     * Closes the {@link Scanner} {@link #sc}.
     * 
     * @param args NONE
     * @see #playGame()
     * @see #scoringTester()
     */
    public static void main(String[] args) {
        playGame();
        // scoringTester();
        sc.close();
    }

}