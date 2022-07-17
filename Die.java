/**
 * Representation of a {@link Yahtzee#DICE_SIDES} sided dice.
 * 
 * @see Yahtzee#DICE_SIDES
 */
public class Die {
    private int value;

    /**
     * Construct an instance of {@link Die} with {@link #value} set to {@code 0}.
     */
    public Die() {
        value = 0;
    }

    /**
     * Getter for the {@link Die}'s {@link #value}.
     * 
     * @return The current {@link #value}.
     * @NOTE The score might be {@code 0} if unset.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for the {@link Die}'s {@link #value}.
     * 
     * @param score New value for the die.
     */
    public void setValue(int v) {
        value = v;
    }

    /**
     * Randomize the {@link #value} from {@code 1} to {@link Yahtzee#DICE_SIDES}.
     */
    public void roll() {
        value = (int) (Math.random() * Yahtzee.DICE_SIDES) + 1;
    }

    /**
     * Returns the {@link Die#value} as a String.
     * 
     * @return String representation of {@link Die}.
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Print the {@link #toString()} to {@link System.out}.
     */
    public void display() {
        System.out.println(this.toString());
    }

}