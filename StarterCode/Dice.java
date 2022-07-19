/**
 * Class to define an array of die
 * 
 * @author Marie-Pierre Jolly
 * @author Arjun Subramanian
 */
public class Dice {
    /**
     * Constant for the number of dice
     */
    public static final int numDice = 5;

    // list of all the dice
    private Die[] dice;

    /**
     * Construct {@link #numDice} number of {@link Die}.
     */
    public Dice() {
        dice = new Die[numDice];
        for (int i = 0; i < numDice; i++)
            dice[i] = new Die();
    }

    /**
     * Getter for the {@code index}th {@link Die} in the {@link #dice} array.
     * 
     * @param index The index of the desired {@link Die}.
     * @return {@link Die} object at {@code index} position.
     */
    public Die getDie(int index) {
        return dice[index];
    }

    /**
     * Roll all {@link #numDice} dice.
     * 
     * @see Die#roll()
     */
    public void roll() {
        for (int i = 0; i < numDice; i++)
            dice[i].roll();
    }

    /**
     * Roll those dice in the array whose index is set to false in the toKeep array.
     * 
     * @param toKeep {@code true} if the die shouldn't be rerolled.
     * @see Die#roll()
     */
    public void roll(Boolean[] toKeep) {
        for (int i = 0; i < numDice; i++)
            if (!toKeep[i]) // Don't keep dice i
                dice[i].roll();
    }

    /**
     * Shows all {@link #numDice} number of dice separated by spaces.
     * 
     * @return String representation of {@link Dice}.
     * @see Die#toString()
     * @see java.lang.Object#toString()
     */
    public String toString() {
        // Initialize it with the 0th dice
        StringBuilder sb = new StringBuilder(dice[0].toString());
        for (int i = 1; i < numDice; i++)
            // every additional dice will lead with a space
            sb.append(' ' + dice[i].toString());
        return sb.toString();
    }

    /**
     * Print the {@link #toString()} to {@link System.out}.
     */
    public void display() {
        System.out.println(this.toString());
    }
}