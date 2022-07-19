/**
 * {@link NumberRow} extends {@link ScoreRow} for the "Yahtzee" category and
 * implements the {@link #isValid(Dice)} function.
 * 
 * @see FixedAmountRow
 * @see ScoreRow
 * @author Arjun Subramanian
 */
public class YahtzeeRow extends FixedAmountRow {

    /**
     * Construct scoring row for the Yahtzee category.
     * 
     * @param name The scoring row's name.
     */
    public YahtzeeRow(String name) {
        super(name, Yahtzee.YAHTZEE_SCORE);
    }

    /**
     * {@inheritDoc} {@link YahtzeeRow} is valid if all dice have the same value.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public boolean isValid(Dice dice) {
        // ensure that all dice are the same as the 0th value
        int ensureNum = dice.getDie(0).getValue();
        boolean valid = true; // so far, all dice have been ensureNum
        for (int i = 1; i < Yahtzee.DICE_COUNT && valid; i++)
            valid = dice.getDie(i).getValue() == ensureNum;
        return valid;
    }

}