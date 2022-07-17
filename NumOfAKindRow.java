/**
 * {@link NumberRow} extends {@link ScoreRow} for the "Three and Four of a Kind"
 * categories and implements the {@link #isValid(Dice)} function.
 * 
 * @see SumAllRow
 * @see ScoreRow
 */
public class NumOfAKindRow extends SumAllRow {
    private int numOfAKind;

    /**
     * Construct scoring row for the Three and Four of a Kind category.
     * 
     * @param name       The scoring row's name.
     * @param numOfAKind How many of a "kind" we want.
     *                   <p>
     *                   Ex. Three of a Kind - 3.
     */
    public NumOfAKindRow(String name, int numOfAKind) {
        super(name);
        this.numOfAKind = numOfAKind;
    }

    /**
     * {@inheritDoc} {@link NumOfAKindRow} is valid if there are
     * {@link #numOfAKind} of the same number.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public boolean isValid(Dice dice) {
        // once "numOfAKind" value are found, valid will be true
        boolean valid = false;

        // loop though all "SIDE" values (1 - DICE_SIDES)
        for (int i = 1; i <= Yahtzee.DICE_SIDES && !valid; i++) {
            int occurrences = 0; // Count the number of i's
            for (int j = 0; j < Yahtzee.DICE_COUNT; j++)
                if (dice.getDie(j).getValue() == i)
                    occurrences++;
            valid = occurrences == numOfAKind; // update valid
        }

        // return true if >= numOfAKind, occurrences are found
        return valid;
    }

}