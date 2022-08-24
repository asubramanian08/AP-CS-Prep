/**
 * Class to define a single die
 * 
 * @author Marie-Pierre Jolly
 * @author Arjun Subramanian
 */
public class Die {

    /**
     * Constant for the number of faces on the die
     */
    public static final int numValues = 6;

    // die's face value
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
     * NOTE: The score might be {@code 0} if unset.
     * 
     * @return The current {@link #value}.
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for the {@link Die}'s {@link #value}.
     * 
     * @param v New value for the die.
     */
    public void setValue(int v) {
        value = v;
    }

    /**
     * Randomize the {@link #value} from {@code 1} to {@link #numValues}.
     */
    public void roll() {
        value = (int) (Math.random() * numValues) + 1;
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
     * Print the {@link #toString()} to System.out.
     */
    public void display() {
        System.out.println(this.toString());
    }

}