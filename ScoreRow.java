/**
 * {@link ScoreRow} represents one scoring row of the {@link ScoreSheet}.
 * <p>
 * "Twos", "Full House", and "Yahtzee" are examples of these scoring rows.
 * 
 * @see ScoreSheet
 * @see SumAllRow
 * @see FixedAmountRow
 * @see NumberRow
 * @see NumOfAKindRow
 * @see FullHouseRow
 * @see StraightRow
 * @see ChanceRow
 */
public abstract class ScoreRow {
    private String name;
    private int score;

    /**
     * Construct an instance of the abstraction {@link ScoreRow}.
     * 
     * @param name The scoring row's name.
     */
    ScoreRow(String name) {
        this.name = name;
        score = Yahtzee.UNSET;
    }

    /**
     * Getter of the row's {@link #name}.
     * 
     * @return Name of the scoring row.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the row's {@link #score}.
     * 
     * @return Score of the row.
     * @NOTE The score might be {@link Yahtzee#UNSET}.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the row's {@link #score}.
     * 
     * @param score New score for the row.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Shows the {@link ScoreRow#name} for the string followed by
     * {@link Yahtzee#SCORE_SPACES} spaces.
     * 
     * @return String representation of {@link ScoreRow}.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        // Set s to be the name padded with "SCORE_SPACES"
        String s = String.format("%-" + Yahtzee.SCORE_SPACES + "s--> ", name);

        // Add the score if it is SET
        if (score != Yahtzee.UNSET)
            s += Integer.toString(score);

        // Return the string representation
        return s;
    }

    /**
     * Print the {@link #toString()} to {@link System.out}.
     */
    public void display() {
        System.out.println(this.toString());
    }

    /**
     * Calculates and sets the score of the row for the given {@code dice}.
     * 
     * @param dice The dice that is getting scored.
     */
    public abstract void calculateScore(Dice dice);

    /**
     * Checks the validity of the given {@code dice} for the scoring row.
     * 
     * @param dice The dice that is getting verified.
     * @return Whether the {@code dice} is valid for this scoring row.
     */
    public abstract boolean isValid(Dice dice);

}