/**
 * {@link ChanceRow} extends {@link ScoreRow} for the "Chance" category and
 * implements the {@link #isValid(Dice)} function.
 * 
 * @see SumAllRow
 * @see ScoreRow
 * @author Arjun Subramanian
 */
public class ChanceRow extends SumAllRow {

    /**
     * Construct scoring row for the Chance category.
     * 
     * @param name The scoring row's name.
     */
    public ChanceRow(String name) {
        super(name);
    }

    /**
     * {@inheritDoc} A {@link ChanceRow} is always valid.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public boolean isValid(Dice dice) {
        return true;
    }

}