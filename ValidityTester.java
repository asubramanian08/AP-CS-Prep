/**
 * This class tests whether the {@link ScoreRow#isValid(Dice)} method is
 * accurate. By iterating though all dice combinations
 * ({@link #diceCombinations(int)}) and determining the {@link #validDiceCount}
 * for each row in {@link ScoreSheet}. It then compares the
 * {@link #validDiceCount} values to {@link #correctCounts} to determine if
 * {@link ScoreRow#isValid(Dice)} is correct for all scoring rows.
 * 
 * @see ScoreRow#isValid(Dice)
 * @see Yahtzee#SCORE_SHEET_ROWS
 */
public class ValidityTester {
    private static final int[] correctCounts = new int[] {
            7776, 7776, 7776, 7776, 7776, 7776,
            1500, 150, 300, 1200, 240, 6, 7776 };
    private int[] validDiceCount;
    private ScoreSheet ss;
    private Dice dice;

    /**
     * Construct a {@link ValidityTester} to check whether
     * {@link ScoreRow#isValid(Dice)} method is accurate.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public ValidityTester() {
        validDiceCount = new int[Yahtzee.SCORE_SHEET_ROWS];
        ss = new ScoreSheet();
        dice = new Dice();
        diceCombinations(0);
    }

    /**
     * For a particular {@link #dice}, update the
     * {@link #validDiceCount} for all {@link Yahtzee#SCORE_SHEET_ROWS}.
     * Called by {@link #diceCombinations()} to count for all combinations.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    private void updateCounter() {
        for (int i = 0; i < Yahtzee.SCORE_SHEET_ROWS; i++)
            if (ss.get(i).isValid(dice))
                validDiceCount[i]++;
    }

    /**
     * Recurse though all dice combinations and call {@link #updateCounter()}.
     * 
     * @param depth The depth of the recursion, or the die number being changed.
     * @see #updateCounter()
     */
    private void diceCombinations(int depth) {
        if (depth == Yahtzee.DICE_COUNT)
            updateCounter();
        else
            // loop though all values of the dice
            for (int i = 1; i <= Yahtzee.DICE_SIDES; i++) {
                dice.getDie(depth).setValue(i);
                diceCombinations(depth + 1);
            }
    }

    /**
     * Checks that the {@link ScoreRow#isValid(Dice)} is correct
     * by comparing {@link #validDiceCount} to {@link #correctCounts}.
     * 
     * @return Whether or not {@link ScoreRow#isValid(Dice)} is correct.
     */
    public boolean isValid() {
        boolean valid = true;
        for (int i = 0; i < Yahtzee.SCORE_SHEET_ROWS && valid; i++)
            valid = validDiceCount[i] == correctCounts[i];
        return valid;
    }

    /**
     * Print out the number of {@link #validDiceCount} for each {@link ScoreRow}.
     */
    public void display() {
        System.out.println("Number of valid dice combinations for each scoring type");
        for (int i = 0; i < Yahtzee.SCORE_SHEET_ROWS; i++)
            // print each scoring row's validCount vs. what is expected
            System.out.println(String.format("%s: %d (expected %d)",
                    ss.get(i).getName(), validDiceCount[i], correctCounts[i]));
    }

}