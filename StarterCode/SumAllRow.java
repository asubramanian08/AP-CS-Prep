/**
 * {@link SumAllRow} is an abstraction of {@link ScoreRow} that generalizes
 * the score calculations in {@link #calculateScore(Dice)}.
 * 
 * @see #calculateScore(Dice)
 * @see ChanceRow
 * @see NumOfAKindRow
 */
public abstract class SumAllRow extends ScoreRow {

    /**
     * Represent rows who's score is the sum of dices.
     * {@link SumAllRow#calculateScore(Dice)} determines this scoring.
     * 
     * @param name The scoring row's name.
     */
    public SumAllRow(String name) {
        super(name);
    }

    /**
     * {@inheritDoc} {@link SumAllRow}'s score is the sum of all dice.
     * 
     * @see ScoreRow#calculateScore(Dice)
     */
    public void calculateScore(Dice dice) {
        // initialized the score to 0
        int score = 0;

        // loop though each dice an add their value to score
        for (int i = 0; i < Dice.numDice; i++)
            score += dice.getDie(i).getValue();

        // set the score
        this.setScore(score);
    }

}