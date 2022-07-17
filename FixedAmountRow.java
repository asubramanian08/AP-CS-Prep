/**
 * {@link FixedAmountRow} is an abstraction of {@link ScoreRow} that implements
 * the score calculations in {@link #calculateScore(Dice)} for all its
 * sub-classes.
 * 
 * @see #calculateScore(Dice)
 * @see ScoreRow
 * @see FullHouseRow
 * @see StraightRow
 * @see YahtzeeRow
 */
public abstract class FixedAmountRow extends ScoreRow {
    private int scoreValue;

    /**
     * Represent scoring for rows with a fixed score.
     * 
     * @param name       The scoring row's name.
     * @param scoreValue How much the row scores.
     *                   <p>
     *                   Ex. Full House - 25.
     */
    public FixedAmountRow(String name, int scoreValue) {
        super(name);
        this.scoreValue = scoreValue;
    }

    /**
     * {@inheritDoc}
     * For {@link FixedAmountRow}, the score is given by {@link #scoreValue}.
     * 
     * @see ScoreRow#calculateScore(Dice)
     */
    public void calculateScore(Dice dice) {
        this.setScore(scoreValue);
    }

}