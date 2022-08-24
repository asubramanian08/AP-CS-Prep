import java.util.ArrayList;

/**
 * List of {@link ScoreRow} that contains are the scoring categories and their
 * scores. For example: Threes, Four of a Kind, and Yahtzee are scoring rows.
 * 
 * @see ScoreRow
 * @see SumAllRow
 * @see FixedAmountRow
 * @see NumberRow
 * @see NumOfAKindRow
 * @see FullHouseRow
 * @see StraightRow
 * @see ChanceRow
 * @author Arjun Subramanian
 */
public class ScoreSheet extends ArrayList<ScoreRow> {

    /**
     * Construct a {@link ScoreSheet} with all the scoring rows.
     */
    public ScoreSheet() {
        this.add(new NumberRow("Ones", 1));
        this.add(new NumberRow("Twos", 2));
        this.add(new NumberRow("Threes", 3));
        this.add(new NumberRow("Fours", 4));
        this.add(new NumberRow("Fives", 5));
        this.add(new NumberRow("Sixes", 6));
        this.add(new NumOfAKindRow("Three of a Kind", 3));
        this.add(new NumOfAKindRow("Four of a Kind", 4));
        this.add(new FullHouseRow("Full House"));
        this.add(new StraightRow("Small Straight", Yahtzee.SMALL_STRAIGHT_COUNT));
        this.add(new StraightRow("Large Straight", Yahtzee.LARGE_STRAIGHT_COUNT));
        this.add(new YahtzeeRow("Yahtzee"));
        this.add(new ChanceRow("Chance"));
    }

    /**
     * Total score so far; used for {@link #display()}.
     * 
     * @return Sum of all {@link ScoreRow#getScore()} for each row.
     */
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < this.size(); i++)
            if (this.get(i).getScore() != Yahtzee.UNSET)
                total += this.get(i).getScore();
        return total;
    }

    /**
     * Determine if the score sheet is finished.
     * 
     * @return If the score sheet have been filled.
     */
    public boolean isFull() {
        boolean allUsed = true;
        for (int i = 0; i < this.size() && allUsed; i++)
            allUsed = this.get(i).getScore() != Yahtzee.UNSET;
        return allUsed;
    }

    /**
     * Print a visualized {@link ScoreSheet} to System.out.
     * 
     * Shows the row number followed by {@link ScoreRow#toString()}.
     * 
     * @see ScoreRow#toString()
     */
    public void display() {
        for (int i = 0; i < this.size(); i++)
            // Show the row number followed by the ScoreRow.toString() string
            System.out.println(String.format("%" + 2 + "d. %s", i + 1, this.get(i).toString()));
        // Additionally print out that total score, calculated by ScoreSheet.getTotal()
        System.out.println("Total = " + Integer.toString(this.getTotal()));
    }

}