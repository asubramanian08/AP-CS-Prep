/**
 * {@link FullHouseRow} extends {@link ScoreRow} for the "Full House" category
 * and implements the {@link #isValid(Dice)} function.
 * 
 * @see Yahtzee#FULL_HOUSE_HIGH_COUNT
 * @see Yahtzee#FULL_HOUSE_LOW_COUNT
 * @see FixedAmountRow
 * @see ScoreRow
 * @author Arjun Subramanian
 */
public class FullHouseRow extends FixedAmountRow {

    /**
     * Construct scoring row for the Full House category.
     * 
     * @param name The scoring row's name.
     */
    public FullHouseRow(String name) {
        super(name, Yahtzee.FULL_HOUSE_SCORE);
    }

    /**
     * {@inheritDoc} {@link FullHouseRow} is valid if there are
     * {@link Yahtzee#FULL_HOUSE_HIGH_COUNT} of one number and
     * {@link Yahtzee#FULL_HOUSE_LOW_COUNT} of the other.
     * 
     * @see ScoreRow#isValid(Dice)
     */
    public boolean isValid(Dice dice) {
        // num1 and num2 represent the two potential die values in a full house
        // num1Count and num2Count are the number of times the num1 and num2 appear in
        // the dice
        int num1 = dice.getDie(0).getValue(), num1Count = 1;
        int num2 = Yahtzee.UNSET, num2Count = 0;

        // Determine the counts of num1 and num2
        for (int i = 1; i < Yahtzee.DICE_COUNT; i++) {
            if (dice.getDie(i).getValue() == num1)
                num1Count++;
            else if (num2 == Yahtzee.UNSET)
                num2 = dice.getDie(i).getValue();

            if (dice.getDie(i).getValue() == num2)
                num2Count++;
        }

        // Swap the count so num1Count is the large one
        if (num1Count < num2Count) {
            int temp = num1Count;
            num1Count = num2Count;
            num2Count = temp;
        }

        // Check the count are consistent with that of a full house
        return (num1Count == Yahtzee.FULL_HOUSE_HIGH_COUNT) &&
                (num2Count == Yahtzee.FULL_HOUSE_LOW_COUNT);
    }

}