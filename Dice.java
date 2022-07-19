/**
 * {@link Dice} represents {@link Yahtzee#DICE_COUNT} number of {@link Die}.
 * 
 * @see Die
 * @see Yahtzee#DICE_COUNT
 * @see #roll(Boolean[])
 * @author Arjun Subramanian
 */
public class Dice {
    private Die[] dice;

    /**
     * Construct {@link Yahtzee#DICE_COUNT} number of {@link Die}.
     */
    public Dice() {
        dice = new Die[Yahtzee.DICE_COUNT];
        for (int i = 0; i < Yahtzee.DICE_COUNT; i++)
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
     * Roll all {@link Yahtzee#DICE_COUNT} dice.
     * 
     * @see Die#roll()
     */
    public void roll() {
        for (int i = 0; i < Yahtzee.DICE_COUNT; i++)
            dice[i].roll();
    }

    /**
     * Roll those dice in the array whose index is set to false in the toKeep array.
     * 
     * @param toKeep {@code true} if the die shouldn't be rerolled.
     * @see Die#roll()
     */
    public void roll(Boolean[] toKeep) {
        for (int i = 0; i < Yahtzee.DICE_COUNT; i++)
            if (!toKeep[i]) // Don't keep dice i
                dice[i].roll();
    }

    /**
     * Shows all {@link Yahtzee#DICE_COUNT} number of dice separated by spaces.
     * 
     * @return String representation of {@link Dice}.
     * @see Die#toString()
     * @see java.lang.Object#toString()
     */
    public String toString() {
        // Initialize it with the 0th dice
        StringBuilder sb = new StringBuilder(dice[0].toString());
        for (int i = 1; i < Yahtzee.DICE_COUNT; i++)
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