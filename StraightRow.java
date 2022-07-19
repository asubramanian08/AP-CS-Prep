import java.util.Arrays;

/**
 * {@link StraightRow} extends {@link ScoreRow} for the "Small Straight" and
 * "Large Straight" categories and implements the {@link #isValid(Dice)}
 * function.
 * 
 * @see FixedAmountRow
 * @see ScoreRow
 * @see Yahtzee#SMALL_STRAIGHT_COUNT
 * @see Yahtzee#LARGE_STRAIGHT_COUNT
 * @author Arjun Subramanian
 */
public class StraightRow extends FixedAmountRow {
    private int numInARow;

    /**
     * Construct scoring row for the catagories Larges and Small Straight.
     * 
     * @param name      The scoring row's name.
     * @param numInARow How many consecutive numbers we want.
     *                  <p>
     *                  Ex. Small Straight - 4.
     */
    public StraightRow(String name, int numInARow) {
        super(name, numInARow == Yahtzee.LARGE_STRAIGHT_COUNT
                ? Yahtzee.LARGE_STRAIGHT_SCORE
                : Yahtzee.SMALL_STRAIGHT_SCORE);
        this.numInARow = numInARow;
    }

    /**
     * {@inheritDoc} {@link StraightRow} is valid if there are {@link numInARow}
     * consecutive numbers.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public boolean isValid(Dice dice) {
        // sorted array representation of the dice values
        int[] values = new int[Yahtzee.DICE_COUNT];
        for (int i = 0; i < Yahtzee.DICE_COUNT; i++)
            values[i] = dice.getDie(i).getValue();
        Arrays.sort(values);

        // determine the maximum length of consecutive numbers
        int straightLen = 1, maxStraightLen = 0;
        for (int i = 1; i < Yahtzee.DICE_COUNT; i++)
            // values are consecutive numbers
            if (values[i] == values[i - 1] + 1)
                straightLen++;
            // there is a gap in the values
            else if (values[i] > values[i - 1] + 1) {
                if (maxStraightLen < straightLen)
                    maxStraightLen = straightLen;
                straightLen = 1;
            }
        // else: the values are equal (continue)
        if (maxStraightLen < straightLen)
            maxStraightLen = straightLen;

        // If the max straight is at least what we are looking for
        return maxStraightLen >= numInARow;
    }

}