/**
 * {@link NumberRow} extends {@link ScoreRow} for the "Ones", "Twos", ...
 * "Sixes" categories and implements the {@link #isValid(Dice)} and
 * {@link #calculateScore(Dice)} function.
 * 
 * @see ScoreRow
 */
public class NumberRow extends ScoreRow {
    private int value;

    /**
     * Construct scoring row for the Full House category.
     * 
     * @param name  The scoring row's name.
     * @param value Dice value we want.
     *              <p>
     *              Ex. Twos is 2.
     */
    public NumberRow(String name, int value) {
        super(name);
        this.value = value;
    }

    /**
     * {@inheritDoc} {@link NumberRow}'s score is the sum of all {@link value} dice.
     * 
     * @see ScoreRow#calculateScore(Dice)
     */
    public void calculateScore(Dice dice) {
        int counter = 0;
        for (int i = 0; i < Yahtzee.DICE_COUNT; i++)
            // ith dice value is the value i'm seeking
            if (dice.getDie(i).getValue() == value)
                counter++;
        this.setScore(counter * value);
    }

    /**
     * {@inheritDoc} {@link NumberRow} is always valid.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public boolean isValid(Dice dice) {
        return true;
    }

}